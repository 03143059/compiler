package ast;

import lib.CompilerOptions;
import org.antlr.v4.runtime.tree.ParseTree;
import parser.CC4Parser;
import semantic.Semantic;

public class Ast {

    private final CC4Parser cc4Parser;

    public Ast(CC4Parser cc4Parser) {
        this.cc4Parser = cc4Parser;
        CompilerOptions compilerOptions = cc4Parser.getScanner().getCompilerOptions();
        System.out.println("stage: AST");
        if (compilerOptions.isDebbuggingActiveFor(this))
            System.out.println("Debbugging AST");

        ParseTree tree = cc4Parser.parse();

        AstVisitor visitor = new AstVisitor();
        Node root = (Node)visitor.visit(tree);

        root.print("  ", compilerOptions.out);
        if (compilerOptions.isDebbuggingActiveFor(this))
            root.print("  ", System.out);

        if (!compilerOptions.stopAt(this))
            new Semantic(this);
    }

    public CC4Parser getCc4Parser() {
        return cc4Parser;
    }
}
