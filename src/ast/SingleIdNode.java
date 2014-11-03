package ast;

import java.io.PrintStream;

public class SingleIdNode extends FieldTypeNode {

    private final String id;
    private final FieldType type;

    public SingleIdNode(String id, FieldType type) {
        this.id = id;
        this.type = type;
    }

    @Override
    public void print(String padding, PrintStream out) {
        out.println(padding + "<Single type=\"" + getType() + "\">" + getId() + "</Single>");
    }

    public String getId() {
        return id;
    }

    public FieldType getType() {
        return type;
    }
}

