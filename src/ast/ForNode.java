package ast;

import java.io.PrintStream;

public class ForNode extends Node {
        private final String varName;
        private final Node start;
        private final Node cond;
        private final Node block;

        public ForNode(String varName, Node start, Node cond, Node block) {
            this.varName = varName;
            this.start = start;
            this.cond = cond;
            this.block = block;
        }

        @Override
        public void print(String padding, PrintStream out) {
            out.println(padding + "for->");
            out.println(padding + "  "  + varName);
            out.println(padding + "start ->");
            start.print(padding + "  ", out);
            out.println(padding + "cond ->");
            cond.print(padding + "  ", out);
            out.println(padding + "block ->");
            block.print(padding + "  ", out);
        }
    }
