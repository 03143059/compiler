package ast;

import java.io.PrintStream;

public class MethodCallNode extends Node {
        private final String name;
        private final NodeList<Node> exprs;

        public MethodCallNode(String name, NodeList<Node> exprs) {

            this.name = name;
            this.exprs = exprs;
        }

        @Override
        public void print(String padding, PrintStream out) {
            out.println(padding + "<MethodCall method=\"" + name + "\">");
            if (getExprs().size() > 0) {
                out.println(padding + "  <Parameters>");
                getExprs().print(padding + "    ", out);
                out.println(padding + "  </Parameters>");
            }
            out.println(padding + "</MethodCall>");
        }

    public String getName() {
        return name;
    }

    public NodeList<Node> getExprs() {
        return exprs;
    }
}
