package irt;

import ast.*;

/**
 * Created by Werner on 10/20/2014.
 */
public class IrtVisitor {


    public IrtNode visitStart(ProgramNode ctx) {
        // CLASS PROGRAM LCURLY ( field_decls )*? ( method_decl )*? RCURLY
        IrtNode end = new NopNode();
        IrtNode fd = new NopNode();
        IrtList list = new IrtList(fd, end);
        if (ctx.getFields() != null) {
            for (FieldNode v : ctx.getFields()) {
                fd = visitField_decls(v);
                if (!(fd instanceof NopNode)) fd = fd.next;
            }
        }
        if (ctx.getMethods() != null) {
            for (MethodNode v : ctx.getMethods()) {
                fd = visitMethod_decl(v);
                if (!(fd instanceof NopNode)) fd = fd.next;
            }
        }
        return list;
    }


    public IrtNode visitIfstmt(IfNode ctx) {
        // IF LPAREN expr RPAREN ifs=block ( ELSE els=block )?
        IrtNode end = new NopNode();
        IfList cList = new IfList(visit(ctx.getExpr()), end);
        IrtList ifList = (IrtList) visit(ctx.getIfs());
        IrtList elseList = ctx.getEls() == null ? new IrtList(end, end) : (IrtList) visit(ctx.getEls());
        ifList.end.next = end;
        elseList.end.next = end;
        cList.true_end.next = ifList.start;
        cList.false_end.next = elseList.start;
        return new IrtList(cList.start, end);
    }


    public IrtNode visitForstmt(ForNode ctx) {
        // FOR ID ASSIGNEQ init=expr COMMA end=expr block
        IrtNode end = new NopNode();
        ForList forList = new ForList(visit(ctx.getStart()), visit(ctx.getEnd()));
        IrtList blockList = (IrtList) visit(ctx.getBlock());
        blockList.end.next = forList.start;
        forList.end.next = blockList.start;
        return new IrtList(forList.start, end);
    }


    public IrtNode visit(Node ctx) {
        return new NopNode();
    }

    public IrtNode visitCallout(Node ctx) {
        return new NopNode();
    }


    public IrtNode visitAritexpr(Node ctx) {
        return new NopNode();
    }


    public IrtNode visitSingleid(Node ctx) {
        return new NopNode();
    }


    public IrtNode visitMetcall(Node ctx) {
        return new NopNode();
    }


    public IrtNode visitType(Node ctx) {
        return new NopNode();
    }


    public IrtNode visitRelexpr(Node ctx) {
        return new NopNode();
    }


    public IrtNode visitLiteral(Node ctx) {
        return new NopNode();
    }


    public IrtNode visitRetstmt(Node ctx) {
        return new NopNode();
    }


    public IrtNode visitArray(Node ctx) {
        return new NopNode();
    }


    public IrtNode visitMethod_name(Node ctx) {
        return new NopNode();
    }


    public IrtNode visitMethod_param(Node ctx) {
        return new NopNode();
    }


    public IrtNode visitLocarray(Node ctx) {
        return new NopNode();
    }


    public IrtNode visitLocexpr(Node ctx) {
        return new NopNode();
    }


    public IrtNode visitErrordecl(Node ctx) {
        return new NopNode();
    }


    public IrtNode visitCondexpr(Node ctx) {
        return new NopNode();
    }


    public IrtNode visitBlock(Node ctx) {
        return new NopNode();
    }


    public IrtNode visitMetstmt(Node ctx) {
        return new NopNode();
    }


    public IrtNode visitParenexpr(Node ctx) {
        return new NopNode();
    }


    public IrtNode visitEqexpr(Node ctx) {
        return new NopNode();
    }


    public IrtNode visitNotexpr(Node ctx) {
        return new NopNode();
    }


    public IrtNode visitMetexpr(Node ctx) {
        return new NopNode();
    }


    public IrtNode visitBad_field_decl(Node ctx) {
        return new NopNode();
    }


    public IrtNode visitBrkstmt(Node ctx) {
        return new NopNode();
    }


    public IrtNode visitCntstmt(Node ctx) {
        return new NopNode();
    }


    public IrtNode visitCallout_arg(Node ctx) {
        return new NopNode();
    }


    public IrtNode visitLitexpr(Node ctx) {
        return new NopNode();
    }


    public IrtNode visitBlkstmt(Node ctx) {
        return new NopNode();
    }


    public IrtNode visitMethod_decl(Node ctx) {
        return new NopNode();
    }


    public IrtNode visitMinexpr(Node ctx) {
        return new NopNode();
    }

    public IrtNode visitVar_decl(Node ctx) {
        return new NopNode();
    }


    public IrtNode visitLocstmt(Node ctx) {
        return new NopNode();
    }


    public IrtNode visitAssign_op(Node ctx) {
        return new NopNode();
    }


    public IrtNode visitField_decls(Node ctx) {
        return new NopNode();
    }


    public IrtNode visitLocid(Node ctx) {
        return new NopNode();
    }
}
