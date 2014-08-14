package semantic;

import irt.Irt;
import lib.CompilerOptions;

public class Semantic {

    public Semantic(CompilerOptions compilerOptions) {
        compilerOptions.out.println("stage: semantic");
        if (compilerOptions.isDebbuggingActiveFor(this))
            compilerOptions.out.println("Debbugging semantic");
        if (!compilerOptions.stopAt(this))
            new Irt(compilerOptions);
    }
}