package irt;

import ast.*;
import codegen.Codegen;
import lib.CompilerOptions;
import semantic.Semantic;

import java.io.PrintStream;
import java.util.List;

public class Irt {

    private IrtList list;

    public IrtList GetList(){
        return list;
    }

    private final Semantic semantic;

    public Irt(Semantic semantic) {
        this.semantic = semantic;
        CompilerOptions compilerOptions = semantic.getAst().getCc4Parser().getScanner().getCompilerOptions();
        System.out.println("stage: IRT");

        if (compilerOptions.isDebbuggingActiveFor(this))
            System.out.println("Debbugging IRT");

        try {
            IrtVisitor visitor = new IrtVisitor();
            list = (IrtList) visitor.visit(semantic.getAst().getStart());

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

    public Semantic getSemantic() {
        return semantic;
    }
}
