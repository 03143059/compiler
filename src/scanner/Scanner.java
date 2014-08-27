package scanner;

import lib.CompilerOptions;
import org.antlr.v4.runtime.*;
import parser.CC4Parser;

import java.io.*;

public class Scanner {

    private final CompilerOptions compilerOptions;
    private DecafLexer lexer = null;

    public Scanner(CompilerOptions compilerOptions) {
        this.compilerOptions = compilerOptions;
        compilerOptions.out.println("stage: scanning");
        if (compilerOptions.isDebbuggingActiveFor(this))
            compilerOptions.out.println("Debbugging scanning");

        try {
            lexer = new DecafLexer(new ANTLRFileStream(compilerOptions.getFilename()));
            if (compilerOptions.isDebbuggingActiveFor(this)) {
                System.out.println();
                // now, print all tokens
                while (lexer.nextToken().getType() != Token.EOF);        }
        } catch (IOException e) {
            System.err.println("El archivo " + compilerOptions.getFilename() + " no existe!");
            System.err.println(e.getMessage());
            System.exit(1);
        }

        if (!compilerOptions.stopAt(this))
            new CC4Parser(this);
    }

    public CompilerOptions getCompilerOptions() {
        return compilerOptions;
    }

    public DecafLexer getLexer() { return lexer; }

}