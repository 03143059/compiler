package ast;

import org.antlr.v4.runtime.misc.NotNull;
import parser.DecafParser;
import parser.DecafParserBaseVisitor;

/**
 * Created by Werner on 9/29/2014.
 */
public class AstVisitor
        extends DecafParserBaseVisitor<Node>
//        implements DecafParserVisitor<Node>
{

    @Override
    public Node visitStart(@NotNull DecafParser.StartContext ctx) {
        // CLASS PROGRAM LCURLY ( field_decls )*? ( method_decl )*? RCURLY
        NodeList<FieldNode> fields = null;
        if (ctx.field_decls() != null) {
            fields = new NodeList();
            for (DecafParser.Field_declsContext v : ctx.field_decls())
                fields.add((FieldNode)visit(v));
        }
        NodeList<MethodNode> methods = null;
        if (ctx.method_decl() != null) {
            methods = new NodeList();
            for (DecafParser.Method_declContext v : ctx.method_decl())
                methods.add((MethodNode)visit(v));
        }
        return new ProgramNode(fields, methods);
    }

    @Override
    public Node visitCallout_arg(@NotNull DecafParser.Callout_argContext ctx) {
        if (ctx.expr() != null)
            return new CallArgExprNode(visit(ctx.expr()));
        else if (ctx.STRING_LITERAL() != null)
            return new CallArgLitNode(ctx.STRING_LITERAL().getText());
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
        NodeList<MethodParamNode> params = null;
        if (ctx.method_param() != null) {
            params = new NodeList<MethodParamNode>();
            for (DecafParser.Method_paramContext param : ctx.method_param())
                params.add((MethodParamNode)visit(param));
        }
        if (ctx.VOID() != null)
            return new VoidMethodNode(name, params, visit(ctx.block()));
        else return (ctx.type().BOOLEAN() != null) ? new BooleanMethodNode(name, params, visit(ctx.block())) :
                (ctx.type().INT() != null) ? new IntMethodNode(name, params, visit(ctx.block())) : null; // no deberia de suceder
    }

    @Override
    public Node visitForstmt(@NotNull DecafParser.ForstmtContext ctx) {
        // FOR ID ASSIGNEQ init=expr COMMA cond=expr block
        return new ForNode(ctx.ID().getText(), visit(ctx.init), visit(ctx.end), visit(ctx.block()));
    }

    @Override
    public Node visitMinexpr(@NotNull DecafParser.MinexprContext ctx) {
        return new NegExprNode(visit(ctx.expr()));
    }

    @Override
    public Node visitLocstmt(@NotNull DecafParser.LocstmtContext ctx) {
        // location assign_op expr SEMI
        OperatorType op = ctx.assign_op().ASSIGNEQ() != null ? OperatorType.Equal :
                ctx.assign_op().ASSIGNMINUSEQ() != null ? OperatorType.MinusEqual :
                        ctx.assign_op().ASSIGNPLUSEQ() != null ? OperatorType.PlusEqual : null;
        return new LocationNode(visit(ctx.location()), op, visit(ctx.expr()));
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
        if ((ctx.type().BOOLEAN() != null)){
            NodeList<FieldTypeNode> fields = new NodeList<FieldTypeNode>();
            for (DecafParser.Field_declContext field : ctx.field_decl()) {
                fields.add((FieldTypeNode)visit(field));
            }
            return new BooleanFieldNode(fields);
        } else if (ctx.type().INT() != null){
            NodeList<FieldTypeNode> fields = new NodeList<FieldTypeNode>();
            for (DecafParser.Field_declContext field : ctx.field_decl()) {
                fields.add((FieldTypeNode)visit(field));
            }
            return new IntFieldNode(fields);
        }
        return null; // no deberia de suceder
    }

    //region field_decl
    @Override
    public Node visitSingleid(@NotNull DecafParser.SingleidContext ctx) {
        DecafParser.Field_declsContext parentContext = (DecafParser.Field_declsContext) ctx.getParent();
        FieldType type = (parentContext.type().BOOLEAN() != null) ? FieldType.Boolean : FieldType.Int;
        return new SingleIdNode(ctx.getText(), type);
    }

    @Override
    public Node visitArray(@NotNull DecafParser.ArrayContext ctx) {
        // ID LSQUARE INT_LITERAL RSQUARE
        DecafParser.Field_declsContext parentContext = (DecafParser.Field_declsContext) ctx.getParent();
        FieldType type = (parentContext.type().BOOLEAN() != null) ? FieldType.Boolean : FieldType.Int;
        int size = 0;
        try {
            size = Integer.parseInt(ctx.INT_LITERAL().getText());
        } catch (NumberFormatException ex) {

        }
        return new ArrayNode(ctx.ID().getText(), size, type);
    }
    //endregion

    @Override
    public Node visitVar_decl(@NotNull DecafParser.Var_declContext ctx) {
        // type ID (COMMA ID)*? SEMI
        return (ctx.type().BOOLEAN() != null) ? new BooleanVarNode(ctx.ID()) :
                (ctx.type().INT() != null) ? new IntVarNode(ctx.ID()) : null; // no deberia de suceder
    }

    @Override
    public Node visitLocid(@NotNull DecafParser.LocidContext ctx) {
        return new IdNode(ctx.ID().getText());
    }

    @Override
    public Node visitCallout(@NotNull DecafParser.CalloutContext ctx) {
        // CALLOUT LPAREN STRING_LITERAL ( COMMA callout_arg )*? RPAREN
        NodeList<CallArgNode> args = new NodeList<CallArgNode>();
        for (DecafParser.Callout_argContext arg : ctx.callout_arg()) {
            args.add((CallArgNode)visit(arg));
        }

        return new CalloutNode(ctx.STRING_LITERAL().getText(), args);
    }

    @Override
    public Node visitAritexpr(@NotNull DecafParser.AritexprContext ctx) {
        return new BinOp(ctx.op.getText(), visit(ctx.left), visit(ctx.right));
    }

    @Override
    public Node visitMetcall(@NotNull DecafParser.MetcallContext ctx) {
        // method_name LPAREN ( expr ( COMMA expr )*? )? RPAREN
        NodeList<Node> exprs = new NodeList<Node>();
        for (DecafParser.ExprContext expr : ctx.expr()) {
            exprs.add((Node)visit(expr));
        }
        String name = ((StringLiteral)visit(ctx.method_name())).getValue();
        return new MethodCallNode(name, exprs);
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
        // RETURN ( expr )? SEMI
        return new RetExprNode((ctx.expr() != null) ? visit(ctx.expr()) : null);
    }

    @Override
    public Node visitMethod_name(@NotNull DecafParser.Method_nameContext ctx) {
        return new StringLiteral(ctx.ID().getText());
    }

    @Override
    public Node visitMethod_param(@NotNull DecafParser.Method_paramContext ctx) {
        return (ctx.type().BOOLEAN() != null) ? new BooleanMethodParamNode(ctx.ID().getText()) :
                (ctx.type().INT() != null) ? new IntMethodParamNode(ctx.ID().getText()) : null; // no deberia de suceder
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
        NodeList<VarNode> vars = new NodeList<VarNode>();
        for (DecafParser.Var_declContext var : ctx.var_decl())
            vars.add((VarNode)visit(var));
        NodeList<Node> stmts = new NodeList<Node>();
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
        return new NotExprNode(visit(ctx.expr()));
    }

    @Override
    public Node visitMetexpr(@NotNull DecafParser.MetexprContext ctx) {
        return visit(ctx.method_call());
    }

    @Override
    public Node visitIfstmt(@NotNull DecafParser.IfstmtContext ctx) {
        // IF LPAREN expr RPAREN ifs=block ( ELSE els=block )?
        return new IfNode(visit(ctx.expr()), visit(ctx.ifs), ctx.els != null ? visit(ctx.els) : null);
    }

    @Override
    public Node visitBrkstmt(@NotNull DecafParser.BrkstmtContext ctx) {
        return new BreakNode();
    }

    @Override
    public Node visitCntstmt(@NotNull DecafParser.CntstmtContext ctx) {
        return new ContinueNode();
    }

}




