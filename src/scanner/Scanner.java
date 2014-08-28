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
            lexer.removeErrorListeners();
            lexer.addErrorListener(DescriptiveErrorListener.INSTANCE);
            if (compilerOptions.isDebbuggingActiveFor(this)) {
                compilerOptions.out.println();
                //lexer.LexerDebug = true;

                // now, print all tokens
                compilerOptions.out.println("LINE  \tTYPE              \tATTRIBUTES");
                compilerOptions.out.println("------\t------------------\t----------------------------------------");
                Token token = lexer.nextToken();
                while (token.getType() != Token.EOF) {
                    if (DescriptiveErrorListener.INSTANCE.result) {
                        int l = token.getLine();
                        String t = lexer.getRuleNames()[token.getType()-1];
                        compilerOptions.out.println(String.format("%6d\t(%3d) %-14s\t@%-3d: %s",
                                l, token.getType(), t, token.getCharPositionInLine(), token.getText()));
                    }
                    token = lexer.nextToken();
                }
                compilerOptions.out.println();

            } else {
                while (lexer.nextToken().getType() != Token.EOF); // traverse and don't print
            }
            lexer.reset(); // if not, the parser throws an error
        } catch (IOException e) {
            System.err.println("File not found: " + compilerOptions.getFilename());
            System.err.println(e.getMessage());
            System.exit(1);
        }

        if (!compilerOptions.stopAt(this)) {
            if (DescriptiveErrorListener.INSTANCE.result)
                new CC4Parser(this);
            else
                System.err.println("There were lexical errors. Aborting.");
        }
    }

    public CompilerOptions getCompilerOptions() {
        return compilerOptions;
    }

    public DecafLexer getLexer() { return lexer; }

}