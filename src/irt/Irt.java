package irt;

import codegen.Codegen;
import lib.CompilerOptions;
import lib.SymbolTable;
import semantic.Semantic;

public class Irt {

    private final Semantic semantic;

    public Irt(Semantic semantic) {
        this.semantic = semantic;
        CompilerOptions compilerOptions = semantic.getAst().getCc4Parser().getScanner().getCompilerOptions();
        System.out.println("stage: IRT");

        if (compilerOptions.isDebbuggingActiveFor(this))
            System.out.println("Debbugging IRT");

        try {
            IrtVisitor visitor = new IrtVisitor();
            visitor.visit(semantic.getAst().getTree());

            if (compilerOptions.stopAt(this))
                SymbolTable.print(compilerOptions.out);
            if (compilerOptions.isDebbuggingActiveFor(this))
                SymbolTable.print(System.out);
        } catch (Exception e){
            System.err.println("ERROR: " + e.getMessage());
            //e.printStackTrace();
        } finally {
            if (!compilerOptions.stopAt(this))
                new Codegen(this);
        }

    }

    public Semantic getSemantic() {
        return semantic;
    }
}
