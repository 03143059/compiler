package irt;

import ast.*;
import codegen.Codegen;
import lib.CompilerOptions;
import semantic.Semantic;

import java.io.PrintStream;
import java.util.List;

public class Irt {

    private final Semantic semantic;

    public Irt(Semantic semantic) {
        this.semantic = semantic;
        CompilerOptions compilerOptions = semantic.getAst().getCc4Parser().getScanner().getCompilerOptions();
        System.out.println("stage: IRT");

        if (compilerOptions.isDebbuggingActiveFor(this))
            System.out.println("Debbugging IRT");

        try {
            IrtVisitor visitor = new IrtVisitor();
            IrtList list = (IrtList) visitor.visit(semantic.getAst().getStart());

            IrtNode.OutputAssembler = false;

          //  IrtList list = GenIntermediate(semantic.getAst().getStart());

            if (compilerOptions.stopAt(this))
                list.print(compilerOptions.out);
            if (compilerOptions.isDebbuggingActiveFor(this))
                list.print(System.out);


        } catch (Exception e) {
            System.err.println("ERROR: " + e.getMessage());
            e.printStackTrace();
        } finally {
            if (!compilerOptions.stopAt(this))
                new Codegen(this);
        }

    }

//    private IrtList GenIntermediate(Node node) {
//        IrtNode end = new NopNode();
//        IrtNode fd = new NopNode();
//
//        IrtList list = new IrtList("", fd, end);
//        if (node instanceof ProgramNode){
//            System.out.println("DEBUG: entering program");
//            ProgramNode ctx = (ProgramNode)node;
//            IrtList pList = new IrtList("program", fd, end);
//            for(MethodNode mn : ctx.getMethods()){
//                fd.next = GenIntermediate(mn);
//                if (!(fd instanceof NopNode)) fd = fd.next;
//            }
//            list.setStart(pList);
//        } else if (node instanceof MethodNode) {
//            MethodNode ctx = (MethodNode) node;
//            System.out.println("DEBUG: entering method " + ctx.getName() + ", returns " + ctx.getType());
//            IrtList pList = new IrtList(ctx.getName(), fd, end);
//            for (MethodParamNode mn : ctx.getParams()) {
//                fd.next = GenIntermediate(mn);
//                if (!(fd instanceof NopNode)) fd = fd.next;
//            }
//            fd.next = GenIntermediate(ctx.getBlock());
//            if (!(fd instanceof NopNode)) fd = fd.next;
//            list.setStart(pList);
//        } else if (node instanceof IfNode) {
//            IfNode ctx = (IfNode) node;
//            System.out.println("DEBUG: entering If");
//            IfList cList = new IfList(GenIntermediate(ctx.getExpr()), end);
//            IrtList ifList = GenIntermediate(ctx.getIfs());
//            IrtList elseList = ctx.getEls() == null ? new IrtList("", end, end) : GenIntermediate(ctx.getEls());
//            ifList.getEnd().next = end;
//            elseList.getEnd().next = end;
//            cList.true_end.next = ifList.getStart();
//            cList.false_end.next = elseList.getStart();
//            list.setStart(cList.getStart());
//        } else if (node instanceof ForNode) {
//            ForNode ctx = (ForNode) node;
//            System.out.println("DEBUG: entering For " + ctx.getVarName());
//            ForList forList = new ForList(GenIntermediate(ctx.getStart()), GenIntermediate(ctx.getEnd()));
//            IrtList blockList = GenIntermediate(ctx.getBlock());
//            blockList.getEnd().next = forList.getStart();
//            forList.getEnd().next = blockList.getStart();
//            list.setStart(forList.getStart());
//
//        } else if (node instanceof BlockNode) {
//            System.out.println("DEBUG: entering block");
//            BlockNode ctx = (BlockNode) node;
//            IrtList pList = new IrtList("block", fd, end);
//            for (VarNode mn : ctx.getVars()) {
//                fd.next = GenIntermediate(mn);
//                if (!(fd instanceof NopNode)) fd = fd.next;
//            }
//            for (Node mn : ctx.getStmts()) {
//                fd.next = GenIntermediate(mn);
//                if (!(fd instanceof NopNode)) fd = fd.next;
//            }
//            list.setStart(pList);
//        } else if (node instanceof VarNode) {
//            VarNode ctx = (VarNode) node;
//            System.out.println("DEBUG: variable type " + ctx.getType());
//            for (Object mn : ctx.getVarNames()) {
//                System.out.println("DEBUG: variable " + mn.toString());
//            }
//        }
//        return list;
//    }

    public Semantic getSemantic() {
        return semantic;
    }
}
