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
        if (node instanceof ProgramNode){
            ProgramNode ctx = (ProgramNode)node;
            IrtNode end = new NopNode();
            IrtNode fd = new IrtNode();
            IrtList list = new IrtList(fd, end);
            if (ctx.getFields() != null) {
                for (Node v : ctx.getFields()) {
                    FieldNode fn = (FieldNode)v;

                   // fd = new LoadNode
                    if (!(fd instanceof NopNode)) fd = fd.next;
                }
            }
//            if (ctx.method_decl() != null) {
//                for (Method_declContext v : ctx.method_decl()) {
//                    fd = visit(v);
//                    if (!(fd instanceof NopNode)) fd = fd.next;
//                }
//            }
            return list;
        }
        return null;
    }

    public Semantic getSemantic() {
        return semantic;
    }
}
