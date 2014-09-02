package codegen;

import irt.Irt;
import lib.CompilerOptions;

public class Codegen {

    private final Irt irt;

    public Codegen(Irt irt) {
        this.irt = irt;
        CompilerOptions compilerOptions = irt.getSemantic().getAst().getCc4Parser().getScanner().getCompilerOptions();
        System.out.println("stage: Code Generation");
        if (compilerOptions.isDebbuggingActiveFor(this))
            System.out.println("Debbugging Code Generation");

    }
}