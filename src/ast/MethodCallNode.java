package ast;

import java.io.PrintStream;

public class MethodCallNode extends Node {
        private final Node name;
        private final Node exprs;

        public MethodCallNode(Node name, Node exprs) {
            this.name = name;
            this.exprs = exprs;
        }

        @Override
        public void print(String padding, PrintStream out) {
            out.println(padding + "Name ->");
            name.print(padding + "  ", out);
            out.println(padding + "Exprs ->");
            exprs.print(padding + "  ", out);
        }
    }
