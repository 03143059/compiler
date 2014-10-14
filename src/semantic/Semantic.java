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

        try {
            SemCheckVisitor visitor = new SemCheckVisitor();
            visitor.visit(ast.getTree());

            SymbolTable.print(compilerOptions.out);
            if (compilerOptions.isDebbuggingActiveFor(this))
                SymbolTable.print(System.out);
        } catch (Exception e){
            System.err.println("ERROR: " + e.getMessage());
            e.printStackTrace();
        } finally {
            if (!compilerOptions.stopAt(this))
                new Irt(this);
        }
    }

    public Ast getAst() {
        return ast;
    }
}
