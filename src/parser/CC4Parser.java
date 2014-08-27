package parser;

import ast.Ast;
import lib.CompilerOptions;
import org.antlr.v4.runtime.*;
import scanner.DescriptiveErrorListener;
import scanner.Scanner;

public class CC4Parser {

    private final Scanner scanner;
    private static final boolean USE_GUI = true;

    public CC4Parser(Scanner scanner) {
        this.scanner = scanner;
        CompilerOptions compilerOptions = scanner.getCompilerOptions();
        compilerOptions.out.println("stage: parsing");
        if (compilerOptions.isDebbuggingActiveFor(this)) {
            compilerOptions.out.println("Debbugging parsing");
            if (USE_GUI)
                compilerOptions.out.println("Using GUI for debugging output");
        }
        DecafParser parser = new DecafParser(new CommonTokenStream(scanner.getLexer()));

        if (compilerOptions.isDebbuggingActiveFor(this)) {
            System.out.println();

            //disable lexer debug
            scanner.getLexer().LexerDebug = false;
            // add custom error handler
           // parser.setErrorHandler(new MyErrorStrategy());

            DecafParser.ProgramContext tree = null;
            if (USE_GUI) {
                parser.setBuildParseTree(true);
                tree = parser.program(); // RuleContext
                if (parser.getNumberOfSyntaxErrors() == 0)
                    tree.inspect(parser); // show in gui
            } else {
                // print parse tree
                tree = parser.program(); // ParseTree
                if (parser.getNumberOfSyntaxErrors() == 0)
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

