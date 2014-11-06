package ast;

import java.io.PrintStream;

public class ForNode extends Node {
        private final String varName;
        private final Node start;
        private final Node end;
        private final Node block;

        public ForNode(String varName, Node start, Node end, Node block) {

            this.varName = varName;
            this.start = start;
            this.end = end;
            this.block = block;
        }

        @Override
        public void print(String padding, PrintStream out) {
            out.println(padding + "<For variable=\"" + getVarName() + "\">");
            out.println(padding + "  <Start>");
            getStart().print(padding + "    ", out);
            out.println(padding + "  </Start>");
            out.println(padding + "  <End>");
            getEnd().print(padding + "    ", out);
            out.println(padding + "  </End>");
            out.println(padding + "  <Block>");
            getBlock().print(padding + "    ", out);
            out.println(padding + "  </Block>");
            out.println(padding + "</For>");
        }

    public String getVarName() {
        return varName;
    }

    public Node getStart() {
        return start;
    }

    public Node getEnd() {
        return end;
    }

    public Node getBlock() {
        return block;
    }
}
