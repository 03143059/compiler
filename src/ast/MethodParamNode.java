package ast;

import java.io.PrintStream;

public abstract class MethodParamNode extends Node {
        private final String type;
        private final String name;

        public MethodParamNode(String type, String name) {
            this.type = type;
            this.name = name;
        }

        @Override
        public void print(String padding, PrintStream out) {
            out.println(padding + "<MethodParam type=\"" + getType() + "\">" + getName() + "</MethodParam>");
        }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }
}
