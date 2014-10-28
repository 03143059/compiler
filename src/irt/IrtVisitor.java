package irt;

import org.antlr.v4.runtime.misc.NotNull;
import parser.DecafParser;
import parser.DecafParserBaseVisitor;

/**
 * Created by Werner on 10/20/2014.
 */
public class IrtVisitor extends DecafParserBaseVisitor<IrtNode> {

    @Override
    public IrtNode visitStart(@NotNull DecafParser.StartContext ctx) {
        // CLASS PROGRAM LCURLY ( field_decls )*? ( method_decl )*? RCURLY
        IrtNode end = new NopNode();
        IrtNode fd = new IrtNode();
        IrtList list = new IrtList(fd, end);
        if (ctx.field_decls() != null) {
            for (DecafParser.Field_declsContext v : ctx.field_decls()) {
                fd = visit(v);
                if (!(fd instanceof NopNode)) fd = fd.next;
            }
        }
        if (ctx.method_decl() != null) {
            for (DecafParser.Method_declContext v : ctx.method_decl()) {
                fd = visit(v);
                if (!(fd instanceof NopNode)) fd = fd.next;
            }
        }
        return list;
    }

    @Override
    public IrtNode visitIfstmt(@NotNull DecafParser.IfstmtContext ctx) {
        // IF LPAREN expr RPAREN ifs=block ( ELSE els=block )?
        IrtNode end = new NopNode();
        IfList cList = new IfList(visit(ctx.expr()), end);
        IrtList ifList = (IrtList) visit(ctx.ifs);
        IrtList elseList = ctx.els == null ? new IrtList(end, end) : (IrtList) visit(ctx.els);
        ifList.end.next = end;
        elseList.end.next = end;
        cList.true_end.next = ifList.start;
        cList.false_end.next = elseList.start;
        return new IrtList(cList.start, end);
    }

    @Override
    public IrtNode visitForstmt(@NotNull DecafParser.ForstmtContext ctx) {
        // FOR ID ASSIGNEQ init=expr COMMA end=expr block
        IrtNode end = new NopNode();
        ForList forList = new ForList(visit(ctx.init), visit(ctx.end));
        IrtList blockList = (IrtList) visit(ctx.block());
        blockList.end.next = forList.start;
        forList.end.next = blockList.start;
        return new IrtList(forList.start, end);
    }

    @Override
    public IrtNode visitCallout(@NotNull DecafParser.CalloutContext ctx) {
        return new NopNode();
    }

    @Override
    public IrtNode visitAritexpr(@NotNull DecafParser.AritexprContext ctx) {
        return new NopNode();
    }

    @Override
    public IrtNode visitSingleid(@NotNull DecafParser.SingleidContext ctx) {
        return new NopNode();
    }

    @Override
    public IrtNode visitMetcall(@NotNull DecafParser.MetcallContext ctx) {
        return new NopNode();
    }

    @Override
    public IrtNode visitType(@NotNull DecafParser.TypeContext ctx) {
        return new NopNode();
    }

    @Override
    public IrtNode visitRelexpr(@NotNull DecafParser.RelexprContext ctx) {
        return new NopNode();
    }

    @Override
    public IrtNode visitLiteral(@NotNull DecafParser.LiteralContext ctx) {
        return new NopNode();
    }

    @Override
    public IrtNode visitRetstmt(@NotNull DecafParser.RetstmtContext ctx) {
        return new NopNode();
    }

    @Override
    public IrtNode visitArray(@NotNull DecafParser.ArrayContext ctx) {
        return new NopNode();
    }

    @Override
    public IrtNode visitMethod_name(@NotNull DecafParser.Method_nameContext ctx) {
        return new NopNode();
    }

    @Override
    public IrtNode visitMethod_param(@NotNull DecafParser.Method_paramContext ctx) {
        return new NopNode();
    }

    @Override
    public IrtNode visitLocarray(@NotNull DecafParser.LocarrayContext ctx) {
        return new NopNode();
    }

    @Override
    public IrtNode visitLocexpr(@NotNull DecafParser.LocexprContext ctx) {
        return new NopNode();
    }

    @Override
    public IrtNode visitErrordecl(@NotNull DecafParser.ErrordeclContext ctx) {
        return new NopNode();
    }

    @Override
    public IrtNode visitCondexpr(@NotNull DecafParser.CondexprContext ctx) {
        return new NopNode();
    }

    @Override
    public IrtNode visitBlock(@NotNull DecafParser.BlockContext ctx) {
        return new NopNode();
    }

    @Override
    public IrtNode visitMetstmt(@NotNull DecafParser.MetstmtContext ctx) {
        return new NopNode();
    }

    @Override
    public IrtNode visitParenexpr(@NotNull DecafParser.ParenexprContext ctx) {
        return new NopNode();
    }

    @Override
    public IrtNode visitEqexpr(@NotNull DecafParser.EqexprContext ctx) {
        return new NopNode();
    }

    @Override
    public IrtNode visitNotexpr(@NotNull DecafParser.NotexprContext ctx) {
        return new NopNode();
    }

    @Override
    public IrtNode visitMetexpr(@NotNull DecafParser.MetexprContext ctx) {
        return new NopNode();
    }

    @Override
    public IrtNode visitBad_field_decl(@NotNull DecafParser.Bad_field_declContext ctx) {
        return new NopNode();
    }

    @Override
    public IrtNode visitBrkstmt(@NotNull DecafParser.BrkstmtContext ctx) {
        return new NopNode();
    }

    @Override
    public IrtNode visitCntstmt(@NotNull DecafParser.CntstmtContext ctx) {
        return new NopNode();
    }

    @Override
    public IrtNode visitCallout_arg(@NotNull DecafParser.Callout_argContext ctx) {
        return new NopNode();
    }

    @Override
    public IrtNode visitLitexpr(@NotNull DecafParser.LitexprContext ctx) {
        return new NopNode();
    }

    @Override
    public IrtNode visitBlkstmt(@NotNull DecafParser.BlkstmtContext ctx) {
        return new NopNode();
    }

    @Override
    public IrtNode visitMethod_decl(@NotNull DecafParser.Method_declContext ctx) {
        return new NopNode();
    }

    @Override
    public IrtNode visitMinexpr(@NotNull DecafParser.MinexprContext ctx) {
        return new NopNode();
    }

    @Override
    public IrtNode visitVar_decl(@NotNull DecafParser.Var_declContext ctx) {
        return new NopNode();
    }

    @Override
    public IrtNode visitLocstmt(@NotNull DecafParser.LocstmtContext ctx) {
        return new NopNode();
    }

    @Override
    public IrtNode visitAssign_op(@NotNull DecafParser.Assign_opContext ctx) {
        return new NopNode();
    }

    @Override
    public IrtNode visitField_decls(@NotNull DecafParser.Field_declsContext ctx) {
        return new NopNode();
    }

    @Override
    public IrtNode visitLocid(@NotNull DecafParser.LocidContext ctx) {
        return new NopNode();
    }
}
