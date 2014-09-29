package ast;

import java.io.PrintStream;

public class FieldNode extends Node {

        private final Node fieldType;
        private final Node fields;

        public FieldNode(Node fieldType, Node fields) {
            this.fieldType = fieldType;
            this.fields = fields;
        }

        @Override
        public void print(String padding, PrintStream out) {
            out.println(padding + "type ->");
            fieldType.print(padding + "  ", out);
            out.println(padding + "fields ->");
            fields.print(padding + "  ", out);
        }
    }
