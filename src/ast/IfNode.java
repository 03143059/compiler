package ast;

import java.io.PrintStream;

public class IfNode extends Node {
        private final Node expr;
        private final Node ifs;
        private final Node els;

        public IfNode(Node expr, Node ifs, Node els) {
            this.expr = expr;
            this.ifs = ifs;
            this.els = els;
        }

        @Override
        public void print(String padding, PrintStream out) {
            out.println(padding + "if ->");
            expr.print(padding + "  ", out);
            out.println(padding + "block ->");
            ifs.print(padding + "  ", out);
            if (els != null) {
                out.println(padding + "block ->");
                els.print(padding + "  ", out);
            }
        }
    }
