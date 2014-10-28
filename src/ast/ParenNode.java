package ast;

import java.io.PrintStream;

public class ParenNode extends Node {
        private final Node expr;

        public ParenNode(Node expr) {
            this.expr = expr;
            Ast.ast.add(this);
        }

        @Override
        public void print(String padding, PrintStream out) {
            out.println(padding + "(");
            expr.print(padding + "  ", out);
            out.println(padding + ")");
        }
    }
