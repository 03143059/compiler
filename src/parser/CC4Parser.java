package parser;

import ast.Ast;
import lib.CompilerOptions;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.RuleContext;
import org.antlr.v4.runtime.tree.ParseTree;
import scanner.Scanner;

public class CC4Parser {

    private final Scanner scanner;
    private static final boolean USE_GUI = false;

    public CC4Parser(Scanner scanner) {
        this.scanner = scanner;
        CompilerOptions compilerOptions = scanner.getCompilerOptions();
        compilerOptions.out.println("stage: parsing");
        if (compilerOptions.isDebbuggingActiveFor(this))
            compilerOptions.out.println("Debbugging parsing");

        DecafParser parser = new DecafParser(new CommonTokenStream(scanner.getLexer()));

        if (compilerOptions.isDebbuggingActiveFor(this)) {
            System.out.println();
            // print parse tree
            DecafParser.ProgramContext tree;
            if (USE_GUI) {
                parser.setBuildParseTree(true);
                tree = parser.program(); // RuleContext
                tree.inspect(parser); // show in gui
            } else {
                tree = parser.program(); // ParseTree
                System.out.println(tree.toStringTree(parser));
            }
        }

        if (!compilerOptions.stopAt(this))
            new Ast(this);
    }

    public Scanner getScanner() {
        return scanner;
    }
}