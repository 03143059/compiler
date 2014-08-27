package semantic;

import ast.Ast;
import irt.Irt;
import lib.CompilerOptions;

public class Semantic {

    private final Ast ast;

    public Semantic(Ast ast) {
        this.ast = ast;
        CompilerOptions compilerOptions = ast.getCc4Parser().getScanner().getCompilerOptions();
        compilerOptions.out.println("stage: semantic");
        if (compilerOptions.isDebbuggingActiveFor(this))
            compilerOptions.out.println("Debbugging semantic");
        if (!compilerOptions.stopAt(this))
            new Irt(this);
    }

    public Ast getAst() {
        return ast;
    }
}