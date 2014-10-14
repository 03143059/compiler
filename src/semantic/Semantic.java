package semantic;

import ast.Ast;
import ast.AstVisitor;
import ast.Node;
import irt.Irt;
import lib.CompilerOptions;
import lib.SymbolTable;

public class Semantic {

    private final Ast ast;

    public Semantic(Ast ast) {
        this.ast = ast;
        CompilerOptions compilerOptions = ast.getCc4Parser().getScanner().getCompilerOptions();
        System.out.println("stage: semantic");
        if (compilerOptions.isDebbuggingActiveFor(this))
            System.out.println("Debbugging semantic");

        SemCheckVisitor visitor = new SemCheckVisitor();
        visitor.visit(ast.getTree());

        SymbolTable.print(compilerOptions.out);
        if (compilerOptions.isDebbuggingActiveFor(this))
            SymbolTable.print(System.out);

        if (!compilerOptions.stopAt(this))
            new Irt(this);
    }

    public Ast getAst() {
        return ast;
    }
}
