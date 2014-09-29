package ast;

public class FieldNode extends Node {

        private final Node fieldType;
        private final Node fields;

        public FieldNode(Node fieldType, Node fields) {
            this.fieldType = fieldType;
            this.fields = fields;
        }

        @Override
        public void print(String padding) {
            System.out.println(padding + "Fields:");
            fieldType.print(padding + "\t");
            fields.print(padding + "\t");
        }
    }
