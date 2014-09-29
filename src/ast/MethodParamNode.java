package ast;

import java.io.PrintStream;

public class MethodParamNode extends Node {
        private final Node type;
        private final String name;

        public MethodParamNode(Node type, String name) {
            this.type = type;
            this.name = name;
        }

        @Override
        public void print(String padding, PrintStream out) {
            out.println(padding + "type ->");
            type.print(padding + "  ", out);
            out.println(padding + "  " + name);
        }
    }
