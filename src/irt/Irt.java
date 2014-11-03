package irt;

import ast.*;
import codegen.Codegen;
import lib.CompilerOptions;
import semantic.Semantic;

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
            IrtList list = GenIntermediate(semantic.getAst().getStart());

            if (compilerOptions.stopAt(this))
                list.print(compilerOptions.out);
            if (compilerOptions.isDebbuggingActiveFor(this))
                list.print(System.out);


        } catch (Exception e) {
            System.err.println("ERROR: " + e.getMessage());
            //e.printStackTrace();
        } finally {
            if (!compilerOptions.stopAt(this))
                new Codegen(this);
        }

    }

    private IrtList GenIntermediate(Node node) {
        IrtNode end = new NopNode();
        IrtNode fd = new NopNode();
        IrtList list = new IrtList(fd, end);
        if (node instanceof ProgramNode){
            System.out.println("DEBUG: entering program");
            ProgramNode ctx = (ProgramNode)node;
            for(MethodNode mn : ctx.getMethods()){
                fd.next = GenIntermediate(mn);
                if (!(fd instanceof NopNode)) fd = fd.next;
            }
        } else if (node instanceof MethodNode){
            MethodNode ctx = (MethodNode)node;
            System.out.println("DEBUG: entering method " + ctx.getName() + ", returns " + ctx.getType());
            for(MethodParamNode mn : ctx.getParams()){
                System.out.println("DEBUG: param name " + mn.getName() + ", type " + mn.getType());
            }
            System.out.println("DEBUG: body:");
            fd.next = GenIntermediate(ctx.getBlock());
        } else if (node instanceof IfNode){
            IfNode ctx = (IfNode)node;

        } else if (node instanceof ForNode){
            ForNode ctx = (ForNode)node;

        }
        return list;
    }

    public Semantic getSemantic() {
        return semantic;
    }
}
