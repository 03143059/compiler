package irt;

import codegen.Codegen;
import lib.CompilerOptions;
import semantic.Semantic;

public class Irt {

    private final Semantic semantic;

    public Irt(Semantic semantic) {
        this.semantic = semantic;
        CompilerOptions compilerOptions = semantic.getAst().getCc4Parser().getScanner().getCompilerOptions();
        compilerOptions.out.println("stage: IRT");
        if (compilerOptions.isDebbuggingActiveFor(this))
            compilerOptions.out.println("Debbugging IRT");
        if (!compilerOptions.stopAt(this))
            new Codegen(this);
    }

    public Semantic getSemantic() {
        return semantic;
    }
}