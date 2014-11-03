package ast;

import java.io.PrintStream;

public abstract class FieldNode<T> extends Node {

        private final FieldType fieldType;
        private final NodeList<T> fields;

        public FieldNode(FieldType fieldType, NodeList<T> fields) {
            this.fieldType = fieldType;
            this.fields = fields;
        }

        @Override
        public void print(String padding, PrintStream out) {
            getFields().print(padding, out);
        }

    public FieldType getFieldType() {
        return fieldType;
    }

    public NodeList<T> getFields() {
        return fields;
    }
}

