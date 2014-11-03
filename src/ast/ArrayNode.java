package ast;

import java.io.PrintStream;

public class ArrayNode extends Node {

    private final String id;
    private final int size;
    private final FieldType type;

    public ArrayNode(String id, int size, FieldType type) {
        this.id = id;
        this.size = size;
        this.type = type;
    }

    @Override
    public void print(String padding, PrintStream out) {
        out.println(padding + "<Array size=\""+ getSize() + "\" type=\"" + getType() + "\">" + getId() + "</Array>");
    }

    public String getId() {
        return id;
    }

    public int getSize() {
        return size;
    }

    public FieldType getType() {
        return type;
    }
}

