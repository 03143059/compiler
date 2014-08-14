package scanner;

import lib.CompilerOptions;
import parser.CC4Parser;

public class Scanner {

    public Scanner(CompilerOptions compilerOptions) {
        compilerOptions.out.println("stage: scanning");
        if (compilerOptions.isDebbuggingActiveFor(this))
            compilerOptions.out.println("Debbugging scanning");
        if (!compilerOptions.stopAt(this))
            new CC4Parser(compilerOptions);
    }
}