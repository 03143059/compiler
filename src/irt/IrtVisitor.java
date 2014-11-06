package irt;

import ast.*;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Werner on 10/20/2014.
 */
public class IrtVisitor {

    private void debug(String s) {
        System.err.println(s);
    }

    public IrtNode visitStart(ProgramNode ctx) {
        debug("DEBUG: entering " + ctx.getClass().getName());
        IrtNode end = new NopNode();
        IrtNode fd = new StartNode();
        IrtList list = new IrtList("program", fd, end);

        if (ctx.getFields() != null) {
            for (FieldNode v : ctx.getFields()) {
                fd.next = visit(v);
                if (!(fd instanceof NopNode)) fd = fd.next;
            }
        }
        if (ctx.getMethods() != null) {
            for (MethodNode v : ctx.getMethods()) {
                fd.next = visit(v);
                if (!(fd instanceof NopNode)) fd = fd.next;
            }
        }

        return list;
    }

    public IrtNode visitMethod(MethodNode ctx) {
        debug("DEBUG: entering " + ctx.getClass().getName());
        IrtNode end = new NopNode();
        IrtNode fd = new StartNode();
        IrtList list = new IrtList("method", fd, end);

        HashMap<String, String> params = new HashMap<String, String>();
        if (ctx.getParams() != null) {
            for (MethodParamNode v : ctx.getParams()) {
                params.put(v.getName(), v.getType());
            }
        }

        fd.next = new IrtMethodList(ctx.getName(), ctx.getType(), params, visit(ctx.getBlock()));

        return list;
    }

    public IrtNode visitArray(ArrayNode ctx) {
        debug("DEBUG: entering " + ctx.getClass().getName());
        IrtNode end = new NopNode();
        IrtNode fd = new StartNode();
        IrtList list = new IrtList("array", fd, end);
        fd.next = new IrtFieldNode(ctx.getType(), ctx.getId(), ctx.getSize());
        return list;
    }

    public IrtNode visitSingleid(SingleIdNode ctx) {
        debug("DEBUG: entering " + ctx.getClass().getName());
        IrtNode end = new NopNode();
        IrtNode fd = new StartNode();
        IrtList list = new IrtList("single", fd, end);
        fd.next = new IrtFieldNode(ctx.getType(), ctx.getId(), 0);
        return list;
    }

    public IrtNode visitField(FieldNode ctx) {
        debug("DEBUG: entering " + ctx.getClass().getName());
        IrtNode end = new NopNode();
        IrtNode fd = new StartNode();
        IrtList list = new IrtList("fieldlist", fd, end);

        if (ctx.getFieldType() == FieldType.Boolean){
            for (FieldTypeNode field : ((BooleanFieldNode)ctx).getFields()) {
                fd.next = visit(field);
                if (!(fd instanceof NopNode)) fd = fd.next;
            }
        } else if (ctx.getFieldType() == FieldType.Int) {
            for (FieldTypeNode field : ((IntFieldNode)ctx).getFields()) {
                fd.next = visit(field);
                if (!(fd instanceof NopNode)) fd = fd.next;
            }
        }
        return list;
    }

    public IrtNode visitIfstmt(IfNode ctx) {
        debug("DEBUG: entering " + ctx.getClass().getName());
        IrtNode end = new NopNode();
        IfList cList = new IfList(visit(ctx.getExpr()), end);
        IrtList ifList = (IrtList) visit(ctx.getIfs());
        IrtList elseList = ctx.getEls() == null ? new IrtList(end, end) : (IrtList) visit(ctx.getEls());
        ifList.getEnd().next = end;
        elseList.getEnd().next = end;
        cList.true_end.next = ifList.getStart();
        cList.false_end.next = elseList.getStart();
        return new IrtList(cList.getStart(), end);
    }

    public IrtNode visitForstmt(ForNode ctx) {
        debug("DEBUG: entering " + ctx.getClass().getName());
        IrtNode end = new NopNode();
        ForList forList = new ForList(visit(ctx.getStart()), visit(ctx.getEnd()));
        IrtList blockList = (IrtList) visit(ctx.getBlock());
        blockList.getEnd().next = forList.getStart();
        forList.getEnd().next = blockList.getStart();
        return new IrtList(forList.getStart(), end);
    }

    public IrtNode visitBlock(BlockNode ctx) {
        debug("DEBUG: entering " + ctx.getClass().getName());
        IrtNode end = new NopNode();
        IrtNode fd = new StartNode();
        IrtList list = new IrtList("block", fd, end);

        if (ctx.getVars() != null) {
            for (VarNode v : ctx.getVars()) {
                fd.next = visitVar(v);
                if (!(fd instanceof NopNode)) fd = fd.next;
            }
        }
        if (ctx.getStmts() != null) {
            for (Node v : ctx.getStmts()) {
                fd.next = visit(v);
                if (!(fd instanceof NopNode)) fd = fd.next;
            }
        }
        return list;
    }

    public IrtNode visitLocid(IdNode ctx) {
        debug("DEBUG: entering " + ctx.getClass().getName());
        IrtNode end = new NopNode();
        IrtNode fd = new StartNode();
        IrtList list = new IrtList("id", fd, end);
        fd.next = new IrtIdNode(ctx.getName());
        return list;
    }

    public IrtNode visitAritexpr(BinOp ctx) {
        debug("DEBUG: entering " + ctx.getClass().getName());
        IrtList left = (IrtList) visit(ctx.getLeft()); // devuelve
        IrtList right = (IrtList) visit(ctx.getRight());
        right.getEnd().next = left;
        return new BinOpList(left, right, ctx.getOperator());
    }

    public IrtNode visitLocstmt(LocationNode ctx) {
        debug("DEBUG: entering " + ctx.getClass().getName());
        IrtList loc = (IrtList)visit(ctx.getLocation());
        IrtList expr = (IrtList)visit(ctx.getExpr());
        expr.getEnd().next = loc;
        return new StoreList(expr, loc, ctx.getOp());
    }

    public IrtNode visitLiteral(Node ctx) {
        debug("DEBUG: entering " + ctx.getClass().getName());
        if (ctx instanceof IntLiteral)
            return new IrtList("literal", new IrtLiteralNode(((IntLiteral)ctx).getValue()), new NopNode());
        if (ctx instanceof CharLiteral)
            return new IrtList("literal", new IrtLiteralNode(((CharLiteral)ctx).getValue()), new NopNode());
        if (ctx instanceof BoolLiteral)
            return new IrtList("literal", new IrtLiteralNode(((BoolLiteral)ctx).getValue()?1:0), new NopNode());
        return new NopNode();
    }

    public IrtNode visitLocarray(LocArrayNode ctx) {
        debug("DEBUG: entering " + ctx.getClass().getName());
        return new IrtList(ctx.getName(), visit(ctx.getExpr()), new NopNode());
    }


    public IrtNode visitMetcall(MethodCallNode ctx) {
        debug("DEBUG: entering " + ctx.getClass().getName());
        IrtNode end = new NopNode();
        IrtNode fd = new StartNode();
        IrtList list = new IrtList(ctx.getName(), fd, end);
        for(Node node : ctx.getExprs()) {
            fd.next = visit(node);
            if (!(fd instanceof NopNode)) fd = fd.next;
        }
        return list;
    }

    public IrtNode visitCallout(CalloutNode ctx) {
        debug("DEBUG: entering " + ctx.getClass().getName());
        IrtNode end = new NopNode();
        IrtNode fd = new StartNode();
        IrtList list = new IrtList(ctx.getFunctionName(), fd, end);
        for(Node node : ctx.getFunctionArgs()) {
            fd.next = visit(node);
            if (!(fd instanceof NopNode)) fd = fd.next;
        }
        return list;
    }

    public IrtNode visitCallout_arg(CallArgNode ctx) {
        debug("DEBUG: entering " + ctx.getClass().getName());
        IrtNode end = new NopNode();
        IrtNode fd = new StartNode();
        IrtList list = new IrtList("callout arg", fd, end);
        if (ctx instanceof CallArgLitNode){
            String expr = ((CallArgLitNode)ctx).getExpr();
            fd.next = new IrtStringNode(expr);
        } else if (ctx instanceof CallArgExprNode){
            fd.next = visit(((CallArgExprNode)ctx).getExpr());
        }
        return list;
    }

    public IrtNode visit(Node ctx) {

        if (ctx instanceof ProgramNode)
            return visitStart((ProgramNode) ctx);

        if (ctx instanceof BlockNode)
            return visitBlock((BlockNode) ctx);

        if (ctx instanceof ForNode)
            return visitForstmt((ForNode) ctx);

        if (ctx instanceof IfNode)
            return visitIfstmt((IfNode) ctx);

        if (ctx instanceof FieldNode)
            return visitField((FieldNode) ctx);

        if (ctx instanceof MethodNode)
            return visitMethod((MethodNode) ctx);

        if (ctx instanceof SingleIdNode)
            return visitSingleid((SingleIdNode) ctx);

        if (ctx instanceof ArrayNode)
            return visitArray((ArrayNode) ctx);

        if (ctx instanceof MethodCallNode)
            return visitMetcall((MethodCallNode) ctx);

        if (ctx instanceof BinOp)
            return visitAritexpr((BinOp)ctx);

        if (ctx instanceof RetExprNode)
            return visitRetstmt((RetExprNode)ctx);

        if (ctx instanceof LocationNode)
            return visitLocstmt((LocationNode)ctx);

        if (ctx instanceof IdNode)
            return visitLocid((IdNode) ctx);

        if (ctx instanceof LocArrayNode)
            return visitLocarray((LocArrayNode) ctx);

        if (ctx instanceof IntLiteral || ctx instanceof CharLiteral || ctx instanceof BoolLiteral)
            return visitLiteral(ctx);

        if (ctx instanceof CalloutNode)
            return visitCallout((CalloutNode) ctx);

        if (ctx instanceof CallArgLitNode || ctx instanceof CallArgExprNode)
            return visitCallout_arg((CallArgNode) ctx);

        System.out.println("DEBUG: missing " + ctx.toString());

        return new NopNode();
    }

    public IrtNode visitType(Node ctx) {
        debug("DEBUG: entering " + ctx.getClass().getName());
        return new NopNode();
    }

    public IrtNode visitRelexpr(Node ctx) {
        debug("DEBUG: entering " + ctx.getClass().getName());
        return new NopNode();
    }

    public IrtNode visitRetstmt(RetExprNode ctx) {
        debug("DEBUG: entering " + ctx.getClass().getName());
        return new NopNode();
    }

    public IrtNode visitMethod_name(Node ctx) {
        debug("DEBUG: entering " + ctx.getClass().getName());
        return new NopNode();
    }

    public IrtNode visitLocexpr(Node ctx) {
        debug("DEBUG: entering " + ctx.getClass().getName());
        return new NopNode();
    }

    public IrtNode visitErrordecl(Node ctx) {
        debug("DEBUG: entering " + ctx.getClass().getName());
        return new NopNode();
    }

    public IrtNode visitCondexpr(Node ctx) {
        debug("DEBUG: entering " + ctx.getClass().getName());
        return new NopNode();
    }

    public IrtNode visitMetstmt(MethodNode ctx) {
        debug("DEBUG: entering " + ctx.getClass().getName());
        return new NopNode();
    }

    public IrtNode visitParenexpr(ParenNode ctx) {
        debug("DEBUG: entering " + ctx.getClass().getName());
        return new NopNode();
    }

    public IrtNode visitEqexpr(Node ctx) {
        debug("DEBUG: entering " + ctx.getClass().getName());
        return new NopNode();
    }

    public IrtNode visitNotexpr(NotExprNode ctx) {
        debug("DEBUG: entering " + ctx.getClass().getName());
        return new NopNode();
    }

    public IrtNode visitMetexpr(Node ctx) {
        debug("DEBUG: entering " + ctx.getClass().getName());
        return new NopNode();
    }

    public IrtNode visitBad_field_decl(Node ctx) {
        debug("DEBUG: entering " + ctx.getClass().getName());
        return new NopNode();
    }

    public IrtNode visitBrkstmt(BreakNode ctx) {
        debug("DEBUG: entering " + ctx.getClass().getName());
        return new NopNode();
    }

    public IrtNode visitCntstmt(ContinueNode ctx) {
        debug("DEBUG: entering " + ctx.getClass().getName());
        return new NopNode();
    }

    public IrtNode visitLitexpr(Node ctx) {
        debug("DEBUG: entering " + ctx.getClass().getName());
        return new NopNode();
    }

    public IrtNode visitBlkstmt(Node ctx) {
        debug("DEBUG: entering " + ctx.getClass().getName());
        return new NopNode();
    }

    public IrtNode visitMinexpr(Node ctx) {
        debug("DEBUG: entering " + ctx.getClass().getName());
        return new NopNode();
    }

    public IrtNode visitVar(VarNode ctx) {
        debug("DEBUG: entering " + ctx.getClass().getName());
        return new NopNode();
    }

    public IrtNode visitAssign_op(Node ctx) {
        debug("DEBUG: entering " + ctx.getClass().getName());
        return new NopNode();
    }

}
