package parser;

import ast.Ast;
import lib.CompilerOptions;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.Utils;
import org.antlr.v4.runtime.tree.*;
import scanner.DescriptiveErrorListener;
import scanner.Scanner;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class CC4Parser {

    private final Scanner scanner;

    public CC4Parser(Scanner scanner) {
        this.scanner = scanner;
        CompilerOptions compilerOptions = scanner.getCompilerOptions();
        System.out.println("stage: parsing");
        if (compilerOptions.isDebbuggingActiveFor(this)) {
            System.out.println("Debbugging parsing");
            if (compilerOptions.hasGui())
                System.out.println("Using GUI for debugging output");
        }
        DecafParser parser = new DecafParser(new CommonTokenStream(scanner.getLexer()));

        if (compilerOptions.isDebbuggingActiveFor(this)) {
            System.out.println();

            //disable lexer debug
            scanner.getLexer().LexerDebug = false;
            // add custom error handler
           // parser.setErrorHandler(new MyErrorStrategy());

            DecafParser.StartContext tree = null;
            parser.setBuildParseTree(true);
            // print parse tree
            tree = parser.start(); // ParseTree
            if (parser.getNumberOfSyntaxErrors() == 0) {
                compilerOptions.out.println(tree.toStringTree(parser));
                if (compilerOptions.hasGui()) {
                    tree.inspect(parser); // show in gui
                }
                TreePrinterListener listener = new TreePrinterListener(parser);
                ParseTreeWalker.DEFAULT.walk(listener, tree);
                System.out.println(listener.toString());
            }
        }

        if (!compilerOptions.stopAt(this)) {
            if (parser.getNumberOfSyntaxErrors() == 0)
                new Ast(this);
            else
                System.err.println("There were syntax errors. Aborting.");
        }
    }

    public ParseTree parse() {
        scanner.getLexer().LexerDebug = false;
        DecafParser parser = new DecafParser(new CommonTokenStream(scanner.getLexer()));
        parser.setBuildParseTree(true);
        return parser.start(); // ParseTree
    }

    public Scanner getScanner() {
        return scanner;
    }

    class TreePrinterListener implements ParseTreeListener {
        private final List<String> ruleNames;
        private final StringBuilder builder = new StringBuilder();
        PriorityQueue<Integer> q = new PriorityQueue<Integer>();
        int count = 0;

        public TreePrinterListener(Parser parser) {
            this.ruleNames = Arrays.asList(parser.getRuleNames());
        }

        public TreePrinterListener(List<String> ruleNames) {
            this.ruleNames = ruleNames;
        }

        @Override
        public void visitTerminal(TerminalNode node) {
            if (builder.length() > 0) {
                builder.append(' ');
            }

            builder.append(Utils.escapeWhitespace(Trees.getNodeText(node, ruleNames), false));
        }

        @Override
        public void visitErrorNode(ErrorNode node) {
            if (builder.length() > 0) {
                builder.append(" ");
            }

            builder.append(Utils.escapeWhitespace(Trees.getNodeText(node, ruleNames), false));
        }

        @Override
        public void enterEveryRule(ParserRuleContext ctx) {
            count++;
            q.add(new Integer(count));
            builder.append("\nRULE " + count + ": ");
//            if (builder.length() > 0) {
//            }

//            if (ctx.getChildCount() > 0) {
//                builder.append('(');
//            }

            int ruleIndex = ctx.getRuleIndex();
            String ruleName;
            if (ruleIndex >= 0 && ruleIndex < ruleNames.size()) {
                ruleName = ruleNames.get(ruleIndex);
            }
            else {
                ruleName = Integer.toString(ruleIndex);
            }

            builder.append(ruleName);
        }

        @Override
        public void exitEveryRule(ParserRuleContext ctx) {
            if (ctx.getChildCount() > 0) {
//                Token positionToken = ctx.getStart();
//                if (positionToken != null) {
//                    builder.append(" [line ");
//                    builder.append(positionToken.getLine());
//                    builder.append(", offset ");
//                    builder.append(positionToken.getStartIndex());
//                    builder.append(':');
//                    builder.append(positionToken.getStopIndex());
//                    builder.append("])");
//                }
//                else {
//                    builder.append(')');
//                }
                builder.append(' ');
            }
        }

        @Override
        public String toString() {
            return builder.toString();
        }
    }
}

