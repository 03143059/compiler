package ast;

import lib.CompilerOptions;
import parser.CC4Parser;
import semantic.Semantic;

public class Ast {

    private final CC4Parser cc4Parser;

    public Ast(CC4Parser cc4Parser) {
        this.cc4Parser = cc4Parser;
        CompilerOptions compilerOptions = cc4Parser.getScanner().getCompilerOptions();
        compilerOptions.out.println("stage: AST");
        if (compilerOptions.isDebbuggingActiveFor(this))
            compilerOptions.out.println("Debbugging AST");
        if (!compilerOptions.stopAt(this))
            new Semantic(this);
    }

    public CC4Parser getCc4Parser() {
        return cc4Parser;
    }
}