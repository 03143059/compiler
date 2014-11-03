package ast;

public class BooleanFieldNode extends FieldNode<FieldTypeNode> {

    public BooleanFieldNode(NodeList<FieldTypeNode> fields) {
        super(FieldType.Boolean, fields);

    }

}
