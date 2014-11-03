package ast;

import java.io.PrintStream;

public class ParenNode extends Node {
        private final Node expr;

        public ParenNode(Node expr) {
            this.expr = expr;

        }

        @Override
        public void print(String padding, PrintStream out) {
            out.println(padding + "<ExpressionGroup>");
            getExpr().print(padding + "    ", out);
            out.println(padding + "</ExpressionGroup>");
        }

    public Node getExpr() {
        return expr;
    }
}
