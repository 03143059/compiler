package ast;

import lib.CompilerOptions;
import org.antlr.v4.runtime.tree.ParseTree;
import parser.CC4Parser;
import semantic.Semantic;

public class Ast {

    private final CC4Parser cc4Parser;
    private final ParseTree tree;

    public ParseTree getTree() {
        return tree;
    }

    public Ast(CC4Parser cc4Parser) {
        this.cc4Parser = cc4Parser;
        CompilerOptions compilerOptions = cc4Parser.getScanner().getCompilerOptions();
        System.out.println("stage: AST");
        if (compilerOptions.isDebbuggingActiveFor(this))
            System.out.println("Debbugging AST");

        tree = cc4Parser.parse();

        try{
            AstVisitor visitor = new AstVisitor();
            Node start = visitor.visit(tree);
            start.print("  ", compilerOptions.out);

            if (compilerOptions.isDebbuggingActiveFor(this))
                start.print("  ", System.out);

            if (!compilerOptions.stopAt(this))
                new Semantic(this);
        } catch(Exception e){}

    }

    public CC4Parser getCc4Parser() {
        return cc4Parser;
    }
}
