package ast;

import java.io.PrintStream;

public class MethodCallNode extends Node {
        private final Node name;
        private final NodeList exprs;

        public MethodCallNode(Node name, NodeList exprs) {
            this.name = name;
            this.exprs = exprs;
        }

        @Override
        public void print(String padding, PrintStream out) {
            out.println(padding + "Name ->");
            name.print(padding + "  ", out);
            if (exprs.size() > 0) {
                out.println(padding + "Exprs ->");
                exprs.print(padding + "  ", out);
            }
        }
    }
