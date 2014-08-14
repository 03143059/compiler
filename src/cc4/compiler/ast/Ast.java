package ast;

import lib.CompilerOptions;
import semantic.Semantic;

public class Ast {

    public Ast(CompilerOptions compilerOptions) {
        compilerOptions.out.println("stage: AST");
        if (compilerOptions.isDebbuggingActiveFor(this))
            compilerOptions.out.println("Debbugging AST");
        if (!compilerOptions.stopAt(this))
            new Semantic(compilerOptions);
    }
}