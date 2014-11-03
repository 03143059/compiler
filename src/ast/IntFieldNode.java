package ast;

public class IntFieldNode extends FieldNode<FieldTypeNode> {

    public IntFieldNode(NodeList<FieldTypeNode> fields) {
        super(FieldType.Int, fields);

    }

}
