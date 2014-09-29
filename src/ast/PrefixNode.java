package ast;

public class PrefixNode extends Node {
        private final String prefix;
        private final Node expr;

        public PrefixNode(String prefix, Node expr) {
            this.prefix = prefix;
            this.expr = expr;
        }

        @Override
        public void print(String padding) {
            System.out.println(padding + prefix);
            expr.print(padding + "\t");
        }
    }
