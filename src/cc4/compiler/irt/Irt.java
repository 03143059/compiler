package irt;

import codegen.Codegen;
import lib.CompilerOptions;

public class Irt {

    public Irt(CompilerOptions compilerOptions) {
        compilerOptions.out.println("stage: IRT");
        if (compilerOptions.isDebbuggingActiveFor(this))
            compilerOptions.out.println("Debbugging IRT");
        if (!compilerOptions.stopAt(this))
            new Codegen(compilerOptions);
    }
}