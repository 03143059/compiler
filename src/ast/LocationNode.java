package ast;

import java.io.PrintStream;

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
        public void print(String padding, PrintStream out) {
            out.println(padding + "location ->");
            location.print(padding + "  ", out);
            out.println(padding + "op ->");
            op.print(padding + "  ", out);
            out.println(padding + "expr ->");
            expr.print(padding + "  ", out);
        }
    }
