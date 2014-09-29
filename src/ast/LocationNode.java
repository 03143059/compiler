package ast;

public class LocationNode extends Node {
        private final Node location;
        private final Node op;
        private final Node expr;

        public LocationNode(Node location, Node op, Node expr) {
            this.location = location;
            this.op = op;
            this.expr = expr;
        }

        @Override
        public void print(String padding) {
            location.print(padding + "\t");
            op.print(padding + "\t");
            expr.print(padding + "\t");
        }
    }
