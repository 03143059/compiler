package ast;

import lib.CompilerOptions;
import org.antlr.v4.runtime.tree.ParseTree;
import parser.CC4Parser;
import semantic.Semantic;

public class Ast {

    private final CC4Parser cc4Parser;
    public static NodeList ast = new NodeList();
    private ParseTree tree;

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

            if (compilerOptions.stopAt(this))
                start.print("  ", compilerOptions.out);

            if (compilerOptions.isDebbuggingActiveFor(this))
                start.print("  ", System.out);

        } catch(Exception e){
            e.printStackTrace();
        } finally {
            if (!compilerOptions.stopAt(this))
                new Semantic(this);
        }

    }

    public CC4Parser getCc4Parser() {
        return cc4Parser;
    }
}
