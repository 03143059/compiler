package semantic;

import ast.*;
import lib.*;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.TerminalNode;
import parser.DecafParser;
import parser.DecafParserBaseVisitor;

/**
 * Created by Werner on 9/29/2014.
 */
public class SemCheckVisitor
        extends DecafParserBaseVisitor<SemNode>
//        implements DecafParserVisitor<SemNode>
{
    private static int SCOPE_HEAP = 1; // control de scopes usando una pila

    @Override
    public SemNode visitStart(@NotNull DecafParser.StartContext ctx) {
        // CLASS PROGRAM LCURLY ( field_decls )*? ( method_decl )*? RCURLY
        // add global scope
        SymbolTable.addScope(SCOPE_HEAP);
        if (ctx.field_decls() != null) {
            for (DecafParser.Field_declsContext v : ctx.field_decls())
                visit(v);
        }
        if (ctx.method_decl() != null) {
            for (DecafParser.Method_declContext v : ctx.method_decl())
                visit(v);
        }
        return new SemNode() {
            @Override
            public boolean ok() {
                return true;
            }
        };
    }

    @Override
    public SemNode visitField_decls(@NotNull DecafParser.Field_declsContext ctx) {
        // type field_decl ( COMMA field_decl )*? SEMI
        for (DecafParser.Field_declContext field : ctx.field_decl()) {
            // check if var is already defined
            Symbol s = SymbolTable.lookup(field.getText(), SCOPE_HEAP);
            if (s != null) { // existe
                System.err.println("ERROR: " + field.getText() + " is already declared at line " + ctx.getStart().getLine());
                return new SemNode() {
                    @Override
                    public boolean ok() {
                        return false;
                    }
                };
            } else {
                // add variable to global scope
                SymbolTable.store(field.getText(), ctx.type().getText(), SCOPE_HEAP);
            }
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
            Symbol s = SymbolTable.lookup(id.getText(), SCOPE_HEAP);
            if (s != null) { // existe
                System.err.println("ERROR: " + id.getText() + " is already declared at line " + ctx.getStart().getLine());
                return new SemNode() {
                    @Override
                    public boolean ok() {
                        return false;
                    }
                };
            } else {
                // add variable to global scope
                SymbolTable.store(id.getText(), ctx.type().getText(), SCOPE_HEAP);
            }
        }
        return new SemNode() {
            @Override
            public boolean ok() {
                return true;
            }
        };
    }

    @Override
    public SemNode visitBlkstmt(@NotNull DecafParser.BlkstmtContext ctx) {
        return visit(ctx.block());
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
        return visit(ctx.method_call());
    }

    @Override
    public SemNode visitSingleid(@NotNull DecafParser.SingleidContext ctx) {
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
        return new SemNode() {
            @Override
            public boolean ok() {
                return true;
            }
        };
    }

    @Override
    public SemNode visitLocid(@NotNull DecafParser.LocidContext ctx) {
        return new SemNode() {
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
    public SemNode visitLiteral(@NotNull DecafParser.LiteralContext ctx) {
        return new SemNode() {
            @Override
            public boolean ok() {
                return true;
            }
        };
    }

    @Override
    public SemNode visitBrkstmt(@NotNull DecafParser.BrkstmtContext ctx) {
        return new SemNode() {
            @Override
            public boolean ok() {
                return true;
            }
        };
    }

    @Override
    public SemNode visitCntstmt(@NotNull DecafParser.CntstmtContext ctx) {
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
        final SemNode v1 = visit(ctx.init);
        final SemNode v2 = visit(ctx.cond);
        final SemNode v3 = visit(ctx.block());

        return new SemNode() {
            @Override
            public boolean ok() {
                return v1.ok() && v2.ok() && v3.ok();
            }
        };
    }

    @Override
    public SemNode visitMinexpr(@NotNull DecafParser.MinexprContext ctx) {
        final SemNode v1 = visit(ctx.expr());
        return new SemNode() {
            @Override
            public boolean ok() {
                return v1.ok();
            }
        };
    }

    @Override
    public SemNode visitLocstmt(@NotNull DecafParser.LocstmtContext ctx) {
        // location assign_op expr SEMI
        final SemNode v1 = visit(ctx.location());
        final SemNode v2 = visit(ctx.assign_op());
        final SemNode v3 = visit(ctx.expr());
        return new SemNode() {
            @Override
            public boolean ok() {
                return v1.ok() && v2.ok() && v3.ok();
            }
        };
    }

    @Override
    public SemNode visitAritexpr(@NotNull DecafParser.AritexprContext ctx) {
        final SemNode v1 = visit(ctx.left);
        final SemNode v2 = visit(ctx.right);
        return new SemNode() {
            @Override
            public boolean ok() {
                return v1.ok() && v2.ok();
            }
        };
    }

    @Override
    public SemNode visitRetstmt(@NotNull DecafParser.RetstmtContext ctx) {
        final SemNode v1 = visit(ctx.expr());
        return new SemNode() {
            @Override
            public boolean ok() {
                return v1.ok();
            }
        };
    }

    @Override
    public SemNode visitRelexpr(@NotNull DecafParser.RelexprContext ctx) {
        final SemNode v1 = visit(ctx.left);
        final SemNode v2 = visit(ctx.right);
        return new SemNode() {
            @Override
            public boolean ok() {
                return v1.ok() && v2.ok();
            }
        };
    }

    @Override
    public SemNode visitMethod_param(@NotNull DecafParser.Method_paramContext ctx) {
        return new SemNode() {
            @Override
            public boolean ok() {
                return true;
            }
        };
    }

    @Override
    public SemNode visitLocarray(@NotNull DecafParser.LocarrayContext ctx) {
        final SemNode v1 = visit(ctx.expr());
        return new SemNode() {
            @Override
            public boolean ok() {
                return v1.ok();
            }
        };
    }

    @Override
    public SemNode visitCondexpr(@NotNull DecafParser.CondexprContext ctx) {
        final SemNode v1 = visit(ctx.left);
        final SemNode v2 = visit(ctx.right);
        return new SemNode() {
            @Override
            public boolean ok() {
                return v1.ok() && v2.ok();
            }
        };
    }

    @Override
    public SemNode visitParenexpr(@NotNull DecafParser.ParenexprContext ctx) {
        final SemNode v1 = visit(ctx.expr());
        return new SemNode() {
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
        return new SemNode() {
            @Override
            public boolean ok() {
                return v1.ok() && v2.ok();
            }
        };
    }

    @Override
    public SemNode visitNotexpr(@NotNull DecafParser.NotexprContext ctx) {
        final SemNode v1 = visit(ctx.expr());
        return new SemNode() {
            @Override
            public boolean ok() {
                return v1.ok();
            }
        };
    }

    @Override
    public SemNode visitIfstmt(@NotNull DecafParser.IfstmtContext ctx) {
        // IF LPAREN expr RPAREN ifs=block ( ELSE els=block )?
        final SemNode v1 = visit(ctx.expr());
        final SemNode v2 = visit(ctx.ifs);
        boolean r = true;
        if (ctx.els != null){
            SemNode v3 = visit(ctx.els);
            r = v3.ok();
        }
        final SemNode v3 = visit(ctx.expr());
        final boolean finalR = r;
        return new SemNode() {
            @Override
            public boolean ok() {
                return v1.ok() && v2.ok() && finalR;
            }
        };
    }

/*

    @Override
    public SemNode visitMethod_decl(@NotNull DecafParser.Method_declContext ctx) {
        // ( type | VOID ) ID LPAREN ( method_param ( COMMA method_param )*? )? RPAREN block
        String name = ctx.ID().getText();
        SemNodeList params = null;
        if (ctx.method_param() != null) {
            params = new SemNodeList();
            for (DecafParser.Method_paramContext param : ctx.method_param())
                params.add(visit(param));
        }
        if (ctx.VOID() != null)
            return new VoidMethodNode(name, params, visit(ctx.block()));
        else return (ctx.type().BOOLEAN() != null)? new BooleanMethodNode(name, params, visit(ctx.block())) :
                (ctx.type().INT() != null) ?  new BooleanMethodNode(name, params, visit(ctx.block())) : null; // no deberia de suceder
    }

    @Override
    public SemNode visitMetcall(@NotNull DecafParser.MetcallContext ctx) {
        // method_name LPAREN ( expr ( COMMA expr )*? )? RPAREN
        SemNodeList exprs = new SemNodeList();
        for (DecafParser.ExprContext expr : ctx.expr()) {
            exprs.add(visit(expr));
        }
        return new MethodCallNode(visit(ctx.method_name()), exprs);
    }

    @Override
    public SemNode visitCallout(@NotNull DecafParser.CalloutContext ctx) {
        // CALLOUT LPAREN STRING_LITERAL ( COMMA callout_arg )*? RPAREN
        SemNodeList args = new SemNodeList();
        for (DecafParser.Callout_argContext arg : ctx.callout_arg()) {
            args.add(visit(arg));
        }
        return new CalloutNode(ctx.STRING_LITERAL().getText(), args);
    }

    @Override
    public SemNode visitBlock(@NotNull DecafParser.BlockContext ctx) {
        // LCURLY ( var_decl )*? ( statement )* RCURLY
        SemNodeList vars = new SemNodeList();
        for (DecafParser.Var_declContext var : ctx.var_decl())
            vars.add(visit(var));
        SemNodeList stmts = new SemNodeList();
        for (DecafParser.StatementContext stmt : ctx.statement())
            stmts.add(visit(stmt));
        return new BlockNode(vars, stmts);
    }




*/
}




