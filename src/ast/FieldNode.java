package ast;

import java.io.PrintStream;

public abstract class FieldNode extends Node {

        private final String fieldType;
        private final Node fields;

        public FieldNode(String fieldType, Node fields) {
            this.fieldType = fieldType;
            this.fields = fields;
        }

        @Override
        public void print(String padding, PrintStream out) {
            out.println(padding + fieldType + " ->");
            fields.print(padding + "  ", out);
        }
    }

