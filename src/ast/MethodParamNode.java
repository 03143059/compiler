package ast;

public class MethodParamNode extends Node {
        private final Node type;
        private final String name;

        public MethodParamNode(Node type, String name) {
            this.type = type;
            this.name = name;
        }

        @Override
        public void print(String padding) {
            type.print(padding + "\t");
            System.out.println(padding + name);
        }
    }
