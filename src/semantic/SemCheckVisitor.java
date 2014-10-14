package semantic;

import lib.Symbol;
import lib.SymbolTable;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.TerminalNode;
import parser.DecafParser;
import parser.DecafParserBaseVisitor;

/**
 * Created by Werner on 9/29/2014.
 */
public class SemCheckVisitor
        extends DecafParserBaseVisitor<SemNode>
        //       implements DecafParserVisitor<SemNode>
{
    private int ScopeHeap = 1; // control de scopes usando una pila
    private int BaseScope = 1; // Control de scopes multiples en otro scope
    private String currMethodIDForReturn = "";
    private boolean isForBreakAndContinue = false;

    @Override
    public SemNode visitStart(@NotNull DecafParser.StartContext ctx) {
        // CLASS PROGRAM LCURLY ( field_decls )*? ( method_decl )*? RCURLY
        // add global scope
        SymbolTable.addScope(ScopeHeap, BaseScope, ctx.start.getText());
        if (ctx.field_decls() != null) {
            for (DecafParser.Field_declsContext v : ctx.field_decls())
                visit(v);
        }
        if (ctx.method_decl() != null) {
            for (DecafParser.Method_declContext v : ctx.method_decl())
                visit(v);
        }
        // check for method main in symbol table
        final Symbol s = SymbolTable.lookup("main()", 1, false);
        if (s == null || (s.getParams() != null && s.getParams().length() > 0)) { // no existe
            System.err.println("ERROR: method main is missing from program at line " + ctx.getStop().getLine());
            return new SemNode("null") {
                @Override
                public boolean ok() {
                    return false;
                }
            };
        }

        return new SemNode(s.getType()) { // return type is main return type
            @Override
            public boolean ok() {
                return true;
            }
        };
    }

    @Override
    public SemNode visitMethod_expr(@NotNull DecafParser.Method_exprContext ctx) {
        // method_name LPAREN ( expr ( COMMA expr )*? )? RPAREN

        // build param signature using types from each expr
        StringBuilder params = new StringBuilder();
        if (ctx.expr() != null) {
            for (DecafParser.ExprContext expr : ctx.expr()) {
                if (params.length() > 0) params.append(",");
                params.append(visit(expr).getType());
            }
        }

        // check if method is already defined
        String methodId = ctx.method_name().getText() + "(" + params + ")";
        final Symbol s = SymbolTable.locate(methodId, ScopeHeap);
        if (s == null) { // no existe
            System.err.println("ERROR: " + methodId + " has not been declared at line " + ctx.getStart().getLine());
            return new SemNode() {
                @Override
                public boolean ok() {
                    return false;
                }
            };
        }

        boolean r = true;
        for (DecafParser.ExprContext expr : ctx.expr()) {
            SemNode v1 = visit(expr);
            r = r && v1.ok();
        }
        final SemNode v2 = visit(ctx.method_name());
        final boolean finalR = r;
        return new SemNode(s.getType()) { // return type is method return type
            @Override
            public boolean ok() {
                return finalR && v2.ok();
            }
        };
    }

    @Override
    public SemNode visitField_decls(@NotNull DecafParser.Field_declsContext ctx) {
        // type field_decl ( COMMA field_decl )*? SEMI
        for (DecafParser.Field_declContext field : ctx.field_decl()) {
            visit(field);
        }
        return new SemNode() {
            @Override
            public boolean ok() {
                return true;
            }
        };
    }

    @Override
    public SemNode visitVar_decl(@NotNull DecafParser.Var_declContext ctx) {
        // type ID (COMMA ID)*? SEMI
        for (TerminalNode id : ctx.ID()) {
            // check if var is already defined
            Symbol s = SymbolTable.lookup(id.getText(), ScopeHeap);
            if (s != null) { // existe
                System.err.println("ERROR: " + id.getText() + " is already declared at line " + ctx.getStart().getLine());
                return new SemNode() {
                    @Override
                    public boolean ok() {
                        return false;
                    }
                };
            }
            // add variable to global scope
            SymbolTable.store(id.getText(), ctx.type().getText(), ScopeHeap);

        }
        return new SemNode() {
            @Override
            public boolean ok() {
                return true;
            }
        };
    }

    @Override
    public SemNode visitMethod_param(@NotNull DecafParser.Method_paramContext ctx) {
        // type ID
        // check if var is already defined
        Symbol s = SymbolTable.lookup(ctx.ID().getText(), ScopeHeap, false);
        if (s != null) { // existe
            System.err.println("ERROR: " + ctx.ID().getText() + " is already declared at line " + ctx.getStart().getLine());
            return new SemNode() {
                @Override
                public boolean ok() {
                    return false;
                }
            };
        }

        // add variable to global scope
        SymbolTable.store(ctx.ID().getText(), ctx.type().getText(), ScopeHeap);

        return new SemNode() {
            @Override
            public boolean ok() {
                return true;
            }
        };
    }

    @Override
    public SemNode visitForstmt(@NotNull DecafParser.ForstmtContext ctx) {
        // FOR ID ASSIGNEQ init=expr COMMA cond=expr block
        isForBreakAndContinue = true;
        // check if var is already defined
        Symbol s = SymbolTable.locate(ctx.ID().getText(), ScopeHeap);
        if (s == null) { // no existe
            System.err.println("ERROR: " + ctx.ID().getText() + " has not been declared at line " + ctx.getStart().getLine());
            return new SemNode() {
                @Override
                public boolean ok() {
                    return false;
                }
            };
        }

        int oldScope = BaseScope;
        BaseScope = ScopeHeap;
        boolean r = true;
        final SemNode v1 = visit(ctx.init);
        if (v1.getType() != null && !v1.getType().equals("int")) {
            System.err.println("ERROR: the initial expression of for must be of type integer at line " + ctx.getStart().getLine());
            r = false;
        }
        final SemNode v2 = visit(ctx.end);
        if (v2.getType() != null && !v2.getType().equals("int")) {
            System.err.println("ERROR: the ending expression of for must be of type integer at line " + ctx.getStart().getLine());
            r = false;
        }
        final SemNode v3 = visit(ctx.block());

        BaseScope = oldScope;

        final boolean finalR = r;
        isForBreakAndContinue = false;
        return new SemNode() {
            @Override
            public boolean ok() {
                return finalR && v1.ok() && v2.ok() && v3.ok();
            }
        };
    }

    @Override
    public SemNode visitIfstmt(@NotNull DecafParser.IfstmtContext ctx) {
        // IF LPAREN expr RPAREN ifs=block ( ELSE els=block )?
        int oldScope = BaseScope;
        BaseScope = ScopeHeap;
        boolean r = true;

        final SemNode v1 = visit(ctx.expr());
        if (v1.getType() != null && !v1.getType().equals("boolean")) {
            System.err.println("ERROR: the expression of an if statement must be of type boolean at line " + ctx.getStart().getLine());
            r = false;
        }

        final SemNode v2 = visit(ctx.ifs);
        if (ctx.els != null) {
            SemNode v3 = visit(ctx.els);
            r = r && v3.ok();

        }
        final boolean finalR = r;
        BaseScope = oldScope;
        return new SemNode() {
            @Override
            public boolean ok() {
                return finalR && v1.ok() && v2.ok();
            }
        };
    }

    @Override
    public SemNode visitMethod_decl(@NotNull DecafParser.Method_declContext ctx) {
        // ( type | VOID ) ID LPAREN ( method_param ( COMMA method_param )*? )? RPAREN block

        // build param signature
        StringBuilder params = new StringBuilder();
        if (ctx.method_param() != null) {
            for (DecafParser.Method_paramContext param : ctx.method_param()) {
                if (params.length() > 0) params.append(",");
                params.append(param.type().getText());
            }
        }

        // check if method is already defined
        String methodID = ctx.ID().getText() + "(" + params.toString() + ")";
        Symbol s = SymbolTable.lookup(methodID, BaseScope);
        if (s != null && s.getParams() != null && s.getParams().equals(params.toString())) { // ya existe
            System.err.println("ERROR: " + ctx.ID().getText() + " is already declared at line " + ctx.getStart().getLine());
            return new SemNode() {
                @Override
                public boolean ok() {
                    return false;
                }
            };
        }

        // add method to global scope
        SymbolTable.store(methodID, ctx.VOID() == null ? ctx.type().getText() : "void", params.toString(), BaseScope);

        currMethodIDForReturn = methodID;

        ScopeHeap++;
        SymbolTable.addScope(ScopeHeap, BaseScope, ctx.ID().getText());

        boolean r = true;
        if (ctx.method_param() != null) {
            for (DecafParser.Method_paramContext param : ctx.method_param()) {
                SemNode v1 = visit(param);
                r = r && v1.ok();
            }
        }

        int oldScope = BaseScope;
        BaseScope = ScopeHeap;

        final SemNode v2 = visit(ctx.block());
        final boolean finalR = r;

        BaseScope = oldScope;

        return new SemNode() {
            @Override
            public boolean ok() {
                return v2.ok() && finalR;
            }
        };
    }

    @Override
    public SemNode visitBlock(@NotNull DecafParser.BlockContext ctx) {
        // LCURLY ( var_decl )*? ( statement )* RCURLY
        ScopeHeap++;
        SymbolTable.addScope(ScopeHeap, BaseScope, ctx.getText());

        boolean r = true;
        for (DecafParser.Var_declContext var : ctx.var_decl()) {
            SemNode v1 = visit(var);
            r = r && v1.ok();
        }

        int oldScope = BaseScope;
        BaseScope = ScopeHeap;

        boolean s = true;
        for (DecafParser.StatementContext stmt : ctx.statement()) {
            SemNode v1 = visit(stmt);
            s = s && v1.ok();
        }

        BaseScope = oldScope;

        final boolean finalR = r;
        final boolean finalS = s;
        return new SemNode() {
            @Override
            public boolean ok() {
                return finalR && finalS;
            }
        };
    }

    @Override
    public SemNode visitBlkstmt(@NotNull DecafParser.BlkstmtContext ctx) {
        int oldScope = BaseScope;
        BaseScope = ScopeHeap;
        SemNode node = visit(ctx.block());
        BaseScope = oldScope;
        return node;
    }

    //region simple rules

    @Override
    public SemNode visitMetcall(@NotNull final DecafParser.MetcallContext ctx) {
        return visit(ctx.method_expr());
    }

    @Override
    public SemNode visitCallout(@NotNull DecafParser.CalloutContext ctx) {
        // CALLOUT LPAREN STRING_LITERAL ( COMMA callout_arg )*? RPAREN
        boolean r = true;
        for (DecafParser.Callout_argContext arg : ctx.callout_arg()) {
            SemNode v1 = visit(arg);
            r = r && v1.ok();
        }
        final boolean finalR = r;
        return new SemNode() {
            @Override
            public boolean ok() {
                return finalR;
            }
        };
    }

    @Override
    public SemNode visitMinexpr(@NotNull DecafParser.MinexprContext ctx) {
        final SemNode v1 = visit(ctx.expr());
        final boolean r = v1.getType().equals("int");
        if (!r) {
            System.err.println("ERROR: minus expression is only valid for integer types at line " + ctx.getStart().getLine());
        }
        return new SemNode() {
            @Override
            public boolean ok() {
                return r && v1.ok();
            }
        };
    }

    @Override
    public SemNode visitLocstmt(@NotNull DecafParser.LocstmtContext ctx) {
        // location assign_op expr SEMI
        final SemNode v1 = visit(ctx.location());
        final SemNode v2 = visit(ctx.assign_op());
        final SemNode v3 = visit(ctx.expr());

        if (v1.getType()==null || v3.getType()==null){
            return new SemNode(null) {
                @Override
                public boolean ok() {
                    return false;
                }
            };
        }

        boolean r = true;

        if (ctx.assign_op().ASSIGNEQ()!= null) {
            r = v1.getType().equals(v3.getType());
            if (!r) {
                System.err.printf("ERROR: mismatch types (%s, %s) at line %d\n", v1.getType(), v3.getType(), ctx.getStart().getLine());
            }
        } else {
            r = v1.getType().equals("int") && v3.getType().equals("int");
            if (!r) {
                System.err.printf("ERROR: both sides of incremental assignments must be of type int at line %d\n", ctx.getStart().getLine());
            }
        }

        final boolean finalR = r;
        return new SemNode(v1.getType()) { // return type is left side type
            @Override
            public boolean ok() {
                return finalR && v1.ok() && v2.ok() && v3.ok();
            }
        };
    }

    @Override
    public SemNode visitAritexpr(@NotNull DecafParser.AritexprContext ctx) {
        final SemNode v1 = visit(ctx.left);
        final SemNode v2 = visit(ctx.right);
        final boolean r = v1.getType().equals("int") && v2.getType().equals("int");
        if (!r) {
            System.err.println("ERROR: arithmetic expression is only valid for integer types at line " + ctx.getStart().getLine());
        }
        return new SemNode("int") {
            @Override
            public boolean ok() {
                return r && v1.ok() && v2.ok();
            }
        };
    }

    @Override
    public SemNode visitRetstmt(@NotNull DecafParser.RetstmtContext ctx) {
        Symbol s = SymbolTable.locate(currMethodIDForReturn, BaseScope); // look in parent scope too
        String rt = s.getType();
        boolean r = true;
        if (rt.equals("void") && ctx.expr() != null) {
            System.err.println("ERROR: void methods can't have return values at line " + ctx.getStart().getLine());
            r = false;
        }

        if (!rt.equals("void") && ctx.expr() == null) {
            System.err.printf("ERROR: %s method must have %s return value at line %d\n", rt, rt, ctx.getStart().getLine());
            r = false;
        }

        if (ctx.expr() != null) {
            SemNode v1 = visit(ctx.expr());

            r = v1.ok();

            if (!rt.equals(v1.getType())) {
                System.err.println("ERROR: return value must match method type at line " + ctx.getStart().getLine());
                r = false;
            }
        }

        final boolean finalR = r;

        return new SemNode(rt) {
            @Override
            public boolean ok() {
                return finalR;
            }
        };
    }

    @Override
    public SemNode visitRelexpr(@NotNull DecafParser.RelexprContext ctx) {
        final SemNode v1 = visit(ctx.left);
        final SemNode v2 = visit(ctx.right);
        final boolean r = v1.getType().equals("int") && v2.getType().equals("int");
        if (!r) {
            System.err.println("ERROR: relation expression is only valid for integer types at line " + ctx.getStart().getLine());
        }
        return new SemNode("boolean") {
            @Override
            public boolean ok() {
                return r && v1.ok() && v2.ok();
            }
        };
    }

    @Override
    public SemNode visitCondexpr(@NotNull DecafParser.CondexprContext ctx) {
        final SemNode v1 = visit(ctx.left);
        final SemNode v2 = visit(ctx.right);
        final boolean r = v1.getType().equals("boolean") && v2.getType().equals("boolean");
        if (!r) {
            System.err.println("ERROR: conditional expression is only valid for boolean types at line " + ctx.getStart().getLine());
        }
        return new SemNode("boolean") {
            @Override
            public boolean ok() {
                return r && v1.ok() && v2.ok();
            }
        };
    }

    @Override
    public SemNode visitParenexpr(@NotNull DecafParser.ParenexprContext ctx) {
        final SemNode v1 = visit(ctx.expr());
        return new SemNode(v1.getType()) {
            @Override
            public boolean ok() {
                return v1.ok();
            }
        };
    }

    @Override
    public SemNode visitEqexpr(@NotNull DecafParser.EqexprContext ctx) {
        final SemNode v1 = visit(ctx.left);
        final SemNode v2 = visit(ctx.right);
        final boolean r = v1.getType().equals(v2.getType());
        if (!r) {
            System.err.println("ERROR: equality expression is only valid for same types at line " + ctx.getStart().getLine());
        }
        return new SemNode("boolean") {
            @Override
            public boolean ok() {
                return r && v1.ok() && v2.ok();
            }
        };
    }

    @Override
    public SemNode visitNotexpr(@NotNull DecafParser.NotexprContext ctx) {
        final SemNode v1 = visit(ctx.expr());
        final boolean r = v1.getType().equals("boolean");
        if (!r) {
            System.err.println("ERROR: not expression is only valid for boolean types at line " + ctx.getStart().getLine());
        }
        return new SemNode("boolean") {
            @Override
            public boolean ok() {
                return r && v1.ok();
            }
        };
    }

    @Override
    public SemNode visitLitexpr(@NotNull DecafParser.LitexprContext ctx) {
        return visit(ctx.literal());
    }

    @Override
    public SemNode visitLocexpr(@NotNull DecafParser.LocexprContext ctx) {
        return visit(ctx.location());
    }

    @Override
    public SemNode visitMetstmt(@NotNull DecafParser.MetstmtContext ctx) {
        return visit(ctx.method_call());
    }

    @Override
    public SemNode visitMetexpr(@NotNull DecafParser.MetexprContext ctx) {
        // check for the return type
        SemNode node = visit(ctx.method_expr());
        if (node.getType() == null) {
            return new SemNode() {
                @Override
                public boolean ok() {
                    return false;
                }
            };
        }
        final boolean r = node.getType().equals("void");
        if (r) {
            System.err.println("ERROR: method call used as expression must return a result at line " + ctx.getStart().getLine());
        }
        return new SemNode(node.getType()) {
            @Override
            public boolean ok() {
                return !r;
            }
        };
    }

    @Override
    public SemNode visitSingleid(@NotNull DecafParser.SingleidContext ctx) {
        // check if var is already defined
        Symbol s = SymbolTable.lookup(ctx.ID().getText(), ScopeHeap, false);  // these are only defined in main body
        if (s != null) { // existe
            System.err.println("ERROR: " + ctx.ID().getText() + " is already declared at line " + ctx.getStart().getLine());
        }

        String type = ((DecafParser.Field_declsContext) ctx.getParent()).type().getText();

        // add variable to global scope
        SymbolTable.store(ctx.ID().getText(), type, ScopeHeap);

        return new SemNode() {
            @Override
            public boolean ok() {
                return true;
            }
        };
    }

    @Override
    public SemNode visitArray(@NotNull DecafParser.ArrayContext ctx) {
        // ID LSQUARE INT_LITERAL RSQUARE
        int n = Integer.parseInt(ctx.INT_LITERAL().getText());
        final boolean r = n > 0;
        if (!r) {
            System.err.println("ERROR: array size must be greater than zero at line " + ctx.getStart().getLine());
        }

        // check if var is already defined
        String id = ctx.ID().getText() + "[]";
        Symbol s = SymbolTable.lookup(id, ScopeHeap, false); // arrays are only defined in main body
        if (s != null) { // existe
            System.err.println("ERROR: " + id + " is already declared at line " + ctx.getStart().getLine());
        }

        String type = ((DecafParser.Field_declsContext) ctx.getParent()).type().getText();

        // add variable to global scope
        SymbolTable.store(id, type, ScopeHeap);

        return new SemNode() {
            @Override
            public boolean ok() {
                return false;
            }
        };
    }

    @Override
    public SemNode visitLocarray(@NotNull DecafParser.LocarrayContext ctx) {
        // ID LSQUARE expr RSQUARE

        // check if array var is already defined. Must find a way to search without size
        String id = ctx.ID().getText() + "[]";
        final Symbol s = SymbolTable.locate(id, ScopeHeap);
        if (s == null) { // no existe
            System.err.println("ERROR: " + id + " has not been declared at line " + ctx.getStart().getLine());
            return new SemNode() {
                @Override
                public boolean ok() {
                    return false;
                }
            };
        }

        // check if id is of type array
        SemNode v1 = visit(ctx.expr());
        boolean r = v1.ok();
        if (!v1.getType().equals("int")) {
            System.err.println("ERROR: " + ctx.getText() + " array index must be of type integer at line " + ctx.getStart().getLine());
            r = false;
        }
        final boolean finalR = r;
        return new SemNode(s.getType()) {
            @Override
            public boolean ok() {
                return finalR;
            }
        };
    }

    @Override
    public SemNode visitLocid(@NotNull DecafParser.LocidContext ctx) {
        // check if var is already defined
        final Symbol s = SymbolTable.locate(ctx.ID().getText(), ScopeHeap);
        if (s == null) { // no existe
            System.err.println("ERROR: " + ctx.ID().getText() + " has not been declared at line " + ctx.getStart().getLine());
            return new SemNode() {
                @Override
                public boolean ok() {
                    return false;
                }
            };
        }
        return new SemNode(s.getType()) {
            @Override
            public boolean ok() {
                return true;
            }
        };
    }

    @Override
    public SemNode visitMethod_name(@NotNull DecafParser.Method_nameContext ctx) {
        return new SemNode() {
            @Override
            public boolean ok() {
                return true;
            }
        };
    }

    @Override
    public SemNode visitCallout_arg(@NotNull DecafParser.Callout_argContext ctx) {
        if (ctx.expr() != null)
            return visit(ctx.expr());
        else if (ctx.STRING_LITERAL() != null)
            return new SemNode() {
                @Override
                public boolean ok() {
                    return true;
                }
            };
        return null;
    }

    @Override
    public SemNode visitAssign_op(@NotNull DecafParser.Assign_opContext ctx) {
        return new SemNode() {
            @Override
            public boolean ok() {
                return true;
            }
        };
    }

    @Override
    public SemNode visitType(@NotNull DecafParser.TypeContext ctx) {
        return new SemNode() {
            @Override
            public boolean ok() {
                return true;
            }
        };
    }

    @Override
    public SemNode visitLiteral(@NotNull final DecafParser.LiteralContext ctx) {
        return new SemNode(ctx.BOOL_LITERAL() != null ? "boolean" :
                ctx.INT_LITERAL() != null ? "int" : null) {
            @Override
            public boolean ok() {
                return true;
            }
        };
    }

    @Override
    public SemNode visitBrkstmt(@NotNull DecafParser.BrkstmtContext ctx) {
        boolean r = true;
        if (!isForBreakAndContinue){
            System.err.println("ERROR: all break statements bust be inside a for body at line " + ctx.getStart().getLine());
            r = false;
        }
        final boolean finalR = r;
        return new SemNode() {
            @Override
            public boolean ok() {
                return finalR;
            }
        };
    }

    @Override
    public SemNode visitCntstmt(@NotNull DecafParser.CntstmtContext ctx) {
        boolean r = true;
        if (!isForBreakAndContinue){
            System.err.println("ERROR: all continue statements bust be inside a for body at line " + ctx.getStart().getLine());
            r = false;
        }
        final boolean finalR = r;
        return new SemNode() {
            @Override
            public boolean ok() {
                return finalR;
            }
        };
    }

    //endregion

}




