package ast;

public class MethodCallNode extends Node {
        private final Node name;
        private final Node exprs;

        public MethodCallNode(Node name, Node exprs) {
            this.name = name;
            this.exprs = exprs;
        }

        @Override
        public void print(String padding) {
            name.print(padding + "\t");
            exprs.print(padding + "\t");
        }
    }
