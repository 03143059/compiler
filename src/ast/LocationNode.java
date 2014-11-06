package ast;

import java.io.PrintStream;

public class LocationNode extends Node {
        private final Node location;
        private final OperatorType op;
        private final Node expr;

        public LocationNode(Node location, OperatorType op, Node expr) {

            this.location = location;
            this.op = op;
            this.expr = expr;
        }

        @Override
        public void print(String padding, PrintStream out) {
            out.println(padding + "<Assignment operator=\"" + getOp() + "\">");
            out.println(padding + "  <Location>");
            getLocation().print(padding + "    ", out);
            out.println(padding + "  </Location>");
            out.println(padding + "  <Expression>");
            getExpr().print(padding + "    ", out);
            out.println(padding + "  </Expression>");
            out.println(padding + "</Assignment>");
        }

    public Node getLocation() {
        return location;
    }

    public OperatorType getOp() {
        return op;
    }

    public Node getExpr() {
        return expr;
    }
}
