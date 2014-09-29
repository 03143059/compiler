package ast;

public class LocArrayNode extends Node {
        private final String name;
        private final Node expr;

        public LocArrayNode(String name, Node expr) {
            this.name = name;
            this.expr = expr;
        }

        @Override
        public void print(String padding) {
            System.out.println(padding + name);
            System.out.println(padding + "[");
            expr.print(padding + "\t");
            System.out.println(padding + "]");
        }
    }
