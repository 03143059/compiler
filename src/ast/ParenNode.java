package ast;

public class ParenNode extends Node {
        private final Node expr;

        public ParenNode(Node expr) {
            this.expr = expr;
        }

        @Override
        public void print(String padding) {
            System.out.println(padding + "(");
            expr.print(padding + "\t");
            System.out.println(padding + ")");
        }
    }
