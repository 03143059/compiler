package ast;

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.TerminalNode;
import parser.DecafParser;
import parser.DecafParserBaseVisitor;
import parser.DecafParserVisitor;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Werner on 9/29/2014.
 */
public class AstVisitor
        extends DecafParserBaseVisitor<Node>
//        implements DecafParserVisitor<Node>
{

    @Override
    public Node visitStart(@NotNull DecafParser.StartContext ctx) {
        Root root = new Root();
        root.add(visit(ctx.CLASS()));
        root.add(visit(ctx.PROGRAM()));
        for (DecafParser.Field_declsContext e : ctx.field_decls()) root.add(visit(e));
        for (DecafParser.Method_declContext e : ctx.method_decl()) root.add(visit(e));
        return root;
    }

    @Override
    public Node visitCallout_arg(@NotNull DecafParser.Callout_argContext ctx) {
        if (ctx.expr() != null)
            return visit(ctx.expr());
        else if (ctx.STRING_LITERAL() != null)
            return new StringLiteral(ctx.STRING_LITERAL().getText());
        return null;
    }

    @Override
    public Node visitLitexpr(@NotNull DecafParser.LitexprContext ctx) {
        return visit(ctx.literal());
    }

    @Override
    public Node visitBlkstmt(@NotNull DecafParser.BlkstmtContext ctx) {
        return visit(ctx.block());
    }

    @Override
    public Node visitMethod_decl(@NotNull DecafParser.Method_declContext ctx) {
        // ( type | VOID ) ID LPAREN ( method_param ( COMMA method_param )*? )? RPAREN block
        String name = ctx.ID().getText();
        Root params = new Root("param");
        for (DecafParser.Method_paramContext param : ctx.method_param())
            params.add(visit(param));
        return new MethodNode(visit(ctx.type()), name, params, visit(ctx.block()));
    }

    @Override
    public Node visitForstmt(@NotNull DecafParser.ForstmtContext ctx) {
        // FOR ID ASSIGNEQ init=expr COMMA cond=expr block
        return new ForNode(ctx.ID().getText(), visit(ctx.init), visit(ctx.cond), visit(ctx.block()));
    }

    @Override
    public Node visitMinexpr(@NotNull DecafParser.MinexprContext ctx) {
        return new PrefixNode(ctx.MINUS().getText(), visit(ctx.expr()));
    }

    @Override
    public Node visitVar_decl(@NotNull DecafParser.Var_declContext ctx) {
        // type ID (COMMA ID)*? SEMI
        return new VarNode(visit(ctx.type()), ctx.ID());
    }

    @Override
    public Node visitLocstmt(@NotNull DecafParser.LocstmtContext ctx) {
        // location assign_op expr SEMI
        return new LocationNode(visit(ctx.location()), visit(ctx.assign_op()), visit(ctx.expr()));
    }

    @Override
    public Node visitAssign_op(@NotNull DecafParser.Assign_opContext ctx) {
        return new StringLiteral(ctx.ASSIGNEQ() != null ? ctx.ASSIGNEQ().getText() :
                ctx.ASSIGNMINUSEQ() != null ? ctx.ASSIGNMINUSEQ().getText() :
                        ctx.ASSIGNPLUSEQ() != null ? ctx.ASSIGNPLUSEQ().getText() : null);
    }

    @Override
    public Node visitField_decls(@NotNull DecafParser.Field_declsContext ctx) {
        // type field_decl ( COMMA field_decl )*? SEMI
        Root fields = new Root("field");
        for (DecafParser.Field_declContext field : ctx.field_decl()) {
            fields.add(visit(field));
        }
        return new FieldNode(visit(ctx.type()), fields);
    }

    @Override
    public Node visitLocid(@NotNull DecafParser.LocidContext ctx) {
        return new StringLiteral(ctx.ID().getText());
    }

    @Override
    public Node visitCallout(@NotNull DecafParser.CalloutContext ctx) {
        // CALLOUT LPAREN STRING_LITERAL ( COMMA callout_arg )*? RPAREN
        Root args = new Root("args");
        for (DecafParser.Callout_argContext arg : ctx.callout_arg()) {
            args.add(visit(arg));
        }
        return new CalloutNode(ctx.STRING_LITERAL().getText(), args);
    }

    @Override
    public Node visitAritexpr(@NotNull DecafParser.AritexprContext ctx) {
        return new BinOp(ctx.op.getText(), visit(ctx.left), visit(ctx.right));
    }

    @Override
    public Node visitSingleid(@NotNull DecafParser.SingleidContext ctx) {
        return new StringLiteral(ctx.getText());
    }

    @Override
    public Node visitMetcall(@NotNull DecafParser.MetcallContext ctx) {
        // method_name LPAREN ( expr ( COMMA expr )*? )? RPAREN
        Root exprs = new Root("exprs");
        for (DecafParser.ExprContext expr : ctx.expr()) {
            exprs.add(visit(expr));
        }
        return new MethodCallNode(visit(ctx.method_name()), exprs);
    }

    @Override
    public Node visitType(@NotNull DecafParser.TypeContext ctx) {
        return new StringLiteral(
                (ctx.INT() != null) ? ctx.INT().getText() :
                        (ctx.BOOLEAN() != null) ? ctx.BOOLEAN().getText() : null);
    }

    @Override
    public Node visitRelexpr(@NotNull DecafParser.RelexprContext ctx) {
        return new BinOp(ctx.op.getText(), visit(ctx.left), visit(ctx.right));
    }

    @Override
    public Node visitLiteral(@NotNull DecafParser.LiteralContext ctx) {
        if (ctx.BOOL_LITERAL() != null) return new BoolLiteral(ctx.BOOL_LITERAL().getText());
        else if (ctx.CHAR_LITERAL() != null) return new CharLiteral(ctx.CHAR_LITERAL().getText());
        else if (ctx.INT_LITERAL() != null) return new IntLiteral(ctx.INT_LITERAL().getText());
        return null;
    }

    @Override
    public Node visitRetstmt(@NotNull DecafParser.RetstmtContext ctx) {
        return new PrefixNode(ctx.RETURN().getText(), visit(ctx.expr()));
    }

    @Override
    public Node visitArray(@NotNull DecafParser.ArrayContext ctx) {
        // ID LSQUARE INT_LITERAL RSQUARE
        // TODO: add array handling
        return new StringLiteral(ctx.ID().getText() + "[" + ctx.INT_LITERAL().getText() + "]");
    }

    @Override
    public Node visitMethod_name(@NotNull DecafParser.Method_nameContext ctx) {
        return new StringLiteral(ctx.ID().getText());
    }

    @Override
    public Node visitMethod_param(@NotNull DecafParser.Method_paramContext ctx) {
        return new MethodParamNode(visit(ctx.type()), ctx.ID().getText());
    }

    @Override
    public Node visitLocarray(@NotNull DecafParser.LocarrayContext ctx) {
        return new LocArrayNode(ctx.ID().getText(), visit(ctx.expr()));
    }

    @Override
    public Node visitLocexpr(@NotNull DecafParser.LocexprContext ctx) {
        return visit(ctx.location());
    }

    @Override
    public Node visitCondexpr(@NotNull DecafParser.CondexprContext ctx) {
        return new BinOp(ctx.op.getText(), visit(ctx.left), visit(ctx.right));
    }

    @Override
    public Node visitBlock(@NotNull DecafParser.BlockContext ctx) {
        // LCURLY ( var_decl )*? ( statement )* RCURLY
        Root vars = new Root("vars");
        for (DecafParser.Var_declContext var : ctx.var_decl())
            vars.add(visit(var));
        Root stmts = new Root("stmts");
        for (DecafParser.StatementContext stmt : ctx.statement())
            stmts.add(visit(stmt));
        return new BlockNode(vars, stmts);
    }

    @Override
    public Node visitMetstmt(@NotNull DecafParser.MetstmtContext ctx) {
        return visit(ctx.method_call());
    }

    @Override
    public Node visitParenexpr(@NotNull DecafParser.ParenexprContext ctx) {
        return new ParenNode(visit(ctx.expr()));
    }

    @Override
    public Node visitEqexpr(@NotNull DecafParser.EqexprContext ctx) {
        return new BinOp(ctx.op.getText(), visit(ctx.left), visit(ctx.right));
    }

    @Override
    public Node visitNotexpr(@NotNull DecafParser.NotexprContext ctx) {
        return new PrefixNode(ctx.NOT().getText(), visit(ctx.expr()));
    }

    @Override
    public Node visitMetexpr(@NotNull DecafParser.MetexprContext ctx) {
        return visit(ctx.method_call());
    }

    @Override
    public Node visitIfstmt(@NotNull DecafParser.IfstmtContext ctx) {
        // IF LPAREN expr RPAREN ifs=block ( ELSE els=block )?
        return new IfNode(visit(ctx.expr()), visit(ctx.ifs), visit(ctx.els));
    }

    @Override
    public Node visitBrkstmt(@NotNull DecafParser.BrkstmtContext ctx) {
        return new StringLiteral(ctx.BREAK().getText());
    }

    @Override
    public Node visitCntstmt(@NotNull DecafParser.CntstmtContext ctx) {
        return new StringLiteral(ctx.CONTINUE().getText());
    }

}




