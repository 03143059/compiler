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
            getExpr().print(padding + "    ", out);
            out.println(padding + "  </Expression>");
            out.println(padding + "  <Then>");
            getIfs().print(padding + "    ", out);
            out.println(padding + "  </Then>");
            if (getEls() != null) {
                out.println(padding + "  <Else>");
                getEls().print(padding + "    ", out);
                out.println(padding + "  </Else>");
            }
            out.println(padding + "</If>");
        }

    public Node getExpr() {
        return expr;
    }

    public Node getIfs() {
        return ifs;
    }

    public Node getEls() {
        return els;
    }
}
