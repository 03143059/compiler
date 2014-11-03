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
            out.println(padding + "<If>");
            out.println(padding + "  <Expression>");
            expr.print(padding + "    ", out);
            out.println(padding + "  </Expression>");
            out.println(padding + "  <Then>");
            ifs.print(padding + "    ", out);
            out.println(padding + "  </Then>");
            if (els != null) {
                out.println(padding + "  <Else>");
                els.print(padding + "    ", out);
                out.println(padding + "  </Else>");
            }
            out.println(padding + "</If>");
        }
    }
