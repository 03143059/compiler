package parser;

import ast.Ast;
import lib.CompilerOptions;

public class CC4Parser {

    public CC4Parser(CompilerOptions compilerOptions) {
        compilerOptions.out.println("stage: parsing");
        if (compilerOptions.isDebbuggingActiveFor(this))
            compilerOptions.out.println("Debbugging parsing");
        if (!compilerOptions.stopAt(this))
            new Ast(compilerOptions);
    }
}