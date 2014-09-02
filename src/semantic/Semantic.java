package semantic;

import ast.Ast;
import irt.Irt;
import lib.CompilerOptions;

public class Semantic {

    private final Ast ast;

    public Semantic(Ast ast) {
        this.ast = ast;
        CompilerOptions compilerOptions = ast.getCc4Parser().getScanner().getCompilerOptions();
        System.out.println("stage: semantic");
        if (compilerOptions.isDebbuggingActiveFor(this))
            System.out.println("Debbugging semantic");
        if (!compilerOptions.stopAt(this))
            new Irt(this);
    }

    public Ast getAst() {
        return ast;
    }
}