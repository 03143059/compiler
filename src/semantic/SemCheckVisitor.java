package semantic;

import ast.*;
import lib.*;
import org.antlr.v4.runtime.misc.NotNull;
import parser.DecafParser;
import parser.DecafParserBaseVisitor;

/**
 * Created by Werner on 9/29/2014.
 */
public class SemCheckVisitor
        extends DecafParserBaseVisitor<SemNode>
//        implements DecafParserVisitor<SemNode>
{
    private static final int GLOBAL_SCOPE = 1;

    @Override
    public SemNode visitStart(@NotNull DecafParser.StartContext ctx) {
        // CLASS PROGRAM LCURLY ( field_decls )*? ( method_decl )*? RCURLY
        // add global scope
        SymbolTable.addScope(GLOBAL_SCOPE);
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
            Symbol s = SymbolTable.lookup(field.getText(), GLOBAL_SCOPE);
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
                SymbolTable.store(field.getText(), ctx.type().getText(), GLOBAL_SCOPE);
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
/*
    @Override
    public SemNode visitCallout_arg(@NotNull DecafParser.Callout_argContext ctx) {
        if (ctx.expr() != null)
            return visit(ctx.expr());
        else if (ctx.STRING_LITERAL() != null)
            return new StringLiteral(ctx.STRING_LITERAL().getText());
        return null;
    }

    @Override
    public SemNode visitLitexpr(@NotNull DecafParser.LitexprContext ctx) {
        return visit(ctx.literal());
    }

    @Override
    public SemNode visitBlkstmt(@NotNull DecafParser.BlkstmtContext ctx) {
        return visit(ctx.block());
    }

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
    public SemNode visitForstmt(@NotNull DecafParser.ForstmtContext ctx) {
        // FOR ID ASSIGNEQ init=expr COMMA cond=expr block
        return new ForNode(ctx.ID().getText(), visit(ctx.init), visit(ctx.cond), visit(ctx.block()));
    }

    @Override
    public SemNode visitMinexpr(@NotNull DecafParser.MinexprContext ctx) {
        return new PrefixNode(ctx.MINUS().getText(), visit(ctx.expr()));
    }

    @Override
    public SemNode visitLocstmt(@NotNull DecafParser.LocstmtContext ctx) {
        // location assign_op expr SEMI
        return new LocationNode(visit(ctx.location()), visit(ctx.assign_op()), visit(ctx.expr()));
    }

    @Override
    public SemNode visitAssign_op(@NotNull DecafParser.Assign_opContext ctx) {
        return new StringLiteral(ctx.ASSIGNEQ() != null ? ctx.ASSIGNEQ().getText() :
                ctx.ASSIGNMINUSEQ() != null ? ctx.ASSIGNMINUSEQ().getText() :
                        ctx.ASSIGNPLUSEQ() != null ? ctx.ASSIGNPLUSEQ().getText() : null);
    }



    //region field_decl
    @Override
    public SemNode visitSingleid(@NotNull DecafParser.SingleidContext ctx) {
        return new StringLiteral(ctx.getText());
    }

    @Override
    public SemNode visitArray(@NotNull DecafParser.ArrayContext ctx) {
        // ID LSQUARE INT_LITERAL RSQUARE
        // TODO: add array handling
        return new StringLiteral(ctx.ID().getText() + "[" + ctx.INT_LITERAL().getText() + "]");
    }
    //endregion

    @Override
    public SemNode visitVar_decl(@NotNull DecafParser.Var_declContext ctx) {
        // type ID (COMMA ID)*? SEMI
        return (ctx.type().BOOLEAN() != null)? new BooleanVarNode(ctx.ID()) :
                (ctx.type().INT() != null) ?  new IntVarNode(ctx.ID()) : null; // no deberia de suceder
    }

    @Override
    public SemNode visitLocid(@NotNull DecafParser.LocidContext ctx) {
        return new StringLiteral(ctx.ID().getText());
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
    public SemNode visitAritexpr(@NotNull DecafParser.AritexprContext ctx) {
        return new BinOp(ctx.op.getText(), visit(ctx.left), visit(ctx.right));
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
    public SemNode visitType(@NotNull DecafParser.TypeContext ctx) {
        return new StringLiteral(
                (ctx.INT() != null) ? ctx.INT().getText() :
                        (ctx.BOOLEAN() != null) ? ctx.BOOLEAN().getText() : null);
    }

    @Override
    public SemNode visitRelexpr(@NotNull DecafParser.RelexprContext ctx) {
        return new BinOp(ctx.op.getText(), visit(ctx.left), visit(ctx.right));
    }

    @Override
    public SemNode visitLiteral(@NotNull DecafParser.LiteralContext ctx) {
        if (ctx.BOOL_LITERAL() != null) return new BoolLiteral(ctx.BOOL_LITERAL().getText());
        else if (ctx.CHAR_LITERAL() != null) return new CharLiteral(ctx.CHAR_LITERAL().getText());
        else if (ctx.INT_LITERAL() != null) return new IntLiteral(ctx.INT_LITERAL().getText());
        return null;
    }

    @Override
    public SemNode visitRetstmt(@NotNull DecafParser.RetstmtContext ctx) {
        return new PrefixNode(ctx.RETURN().getText(), visit(ctx.expr()));
    }

    @Override
    public SemNode visitMethod_name(@NotNull DecafParser.Method_nameContext ctx) {
        return new StringLiteral(ctx.ID().getText());
    }

    @Override
    public SemNode visitMethod_param(@NotNull DecafParser.Method_paramContext ctx) {
        return (ctx.type().BOOLEAN() != null)? new BooleanMethodParamNode(ctx.ID().getText()) :
                (ctx.type().INT() != null) ?  new IntMethodParamNode(ctx.ID().getText()) : null; // no deberia de suceder
    }

    @Override
    public SemNode visitLocarray(@NotNull DecafParser.LocarrayContext ctx) {
        return new LocArrayNode(ctx.ID().getText(), visit(ctx.expr()));
    }

    @Override
    public SemNode visitLocexpr(@NotNull DecafParser.LocexprContext ctx) {
        return visit(ctx.location());
    }

    @Override
    public SemNode visitCondexpr(@NotNull DecafParser.CondexprContext ctx) {
        return new BinOp(ctx.op.getText(), visit(ctx.left), visit(ctx.right));
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

    @Override
    public SemNode visitMetstmt(@NotNull DecafParser.MetstmtContext ctx) {
        return visit(ctx.method_call());
    }

    @Override
    public SemNode visitParenexpr(@NotNull DecafParser.ParenexprContext ctx) {
        return new ParenNode(visit(ctx.expr()));
    }

    @Override
    public SemNode visitEqexpr(@NotNull DecafParser.EqexprContext ctx) {
        return new BinOp(ctx.op.getText(), visit(ctx.left), visit(ctx.right));
    }

    @Override
    public SemNode visitNotexpr(@NotNull DecafParser.NotexprContext ctx) {
        return new PrefixNode(ctx.NOT().getText(), visit(ctx.expr()));
    }

    @Override
    public SemNode visitMetexpr(@NotNull DecafParser.MetexprContext ctx) {
        return visit(ctx.method_call());
    }

    @Override
    public SemNode visitIfstmt(@NotNull DecafParser.IfstmtContext ctx) {
        // IF LPAREN expr RPAREN ifs=block ( ELSE els=block )?
        return new IfNode(visit(ctx.expr()), visit(ctx.ifs), ctx.els != null?visit(ctx.els):null);
    }

    @Override
    public SemNode visitBrkstmt(@NotNull DecafParser.BrkstmtContext ctx) {
        return new StringLiteral(ctx.BREAK().getText());
    }

    @Override
    public SemNode visitCntstmt(@NotNull DecafParser.CntstmtContext ctx) {
        return new StringLiteral(ctx.CONTINUE().getText());
    }
*/
}




