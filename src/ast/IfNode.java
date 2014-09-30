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
            out.println(padding + "(");
            expr.print(padding + "  ", out);
            out.println(padding + ")");
            out.println(padding + "then {");
            ifs.print(padding + "  ", out);
            out.println(padding + "}");
            if (els != null) {
                out.println(padding + "else {");
                els.print(padding + "  ", out);
                out.println(padding + "}");
            }
        }
    }
