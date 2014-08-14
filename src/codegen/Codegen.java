package codegen;

import lib.CompilerOptions;

public class Codegen {

    public Codegen(CompilerOptions compilerOptions) {
        compilerOptions.out.println("stage: Code Generation");
        if (compilerOptions.isDebbuggingActiveFor(this))
            compilerOptions.out.println("Debbugging Code Generation");

    }
}