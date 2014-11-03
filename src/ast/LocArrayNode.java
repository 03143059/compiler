package ast;

import java.io.PrintStream;

public class LocArrayNode extends Node {
        private final String name;
        private final Node expr;

        public LocArrayNode(String name, Node expr) {

            this.name = name;
            this.expr = expr;
        }

        @Override
        public void print(String padding, PrintStream out) {
            out.println(padding + "<Array name=\""+ getName() + "\">");
            out.println(padding + "  <Index>");
            getExpr().print(padding + "    ", out);
            out.println(padding + "  </Index>");
            out.println(padding + "</Array>");
        }

    public String getName() {
        return name;
    }

    public Node getExpr() {
        return expr;
    }
}
