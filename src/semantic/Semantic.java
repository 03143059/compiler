package semantic;

import ast.Ast;
import ast.AstVisitor;
import ast.Node;
import irt.Irt;
import lib.CompilerOptions;
import lib.SymbolTable;

public class Semantic {

    private final Ast ast;
    public static boolean HasSemanticErrors = false;

    public Semantic(Ast ast) {
        this.ast = ast;
        CompilerOptions compilerOptions = ast.getCc4Parser().getScanner().getCompilerOptions();
        System.out.println("stage: semantic");
        if (compilerOptions.isDebbuggingActiveFor(this))
            System.out.println("Debbugging semantic");
        SemNode result = null;
        try {
            SemCheckVisitor visitor = new SemCheckVisitor();
            result = visitor.visit(ast.getTree());

            if (compilerOptions.stopAt(this))
                SymbolTable.print(compilerOptions.out);
            if (compilerOptions.isDebbuggingActiveFor(this))
                SymbolTable.print(System.out);
        } catch (Exception e){
            System.err.println("ERROR: " + e.getMessage());
            e.printStackTrace();
        } finally {
            if (!compilerOptions.stopAt(this)) {
                if (result != null && !HasSemanticErrors)
                    new Irt(this);
                else
                    System.err.println("There were semantic errors. IRT was not generated");
            }
        }
    }

    public Ast getAst() {
        return ast;
    }
}
