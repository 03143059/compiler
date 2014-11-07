package irt;

import ast.FieldType;

import java.io.PrintStream;

/**
 * Created by Werner on 10/20/2014.
 */
public class IrtFieldNode extends IrtNode {

    private final FieldType fieldType;
    private final String id;
    private final int size;

    public IrtFieldNode(String id, FieldType fieldType, int size) {
        super("-field");
        this.fieldType = fieldType;
        this.id = id;
        this.size = size;
    }

    @Override
    public void print(PrintStream out) {
        StringBuilder sb = new StringBuilder();
        sb.append("Global ");
        sb.append(fieldType);
        if (size > 0) {
            sb.append("[");
            sb.append(size);
            sb.append("]");
        }
        sb.append(" ");
        sb.append(id);
        out.println(sb.toString());
    }

    @Override
    public String getAssembler() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("var_%s:\t.word\t", id));
        sb.append((size==0)?1:"0:"+size);
        sb.append(String.format("\t# int %s", id));
        sb.append((size==0)?"":"["+size+"]");
        sb.append(System.lineSeparator());
        return sb.toString();
    }

    public FieldType getFieldType() {
        return fieldType;
    }

    public String getId() {
        return id;
    }

    public int getSize() {
        return size;
    }

    @Override
    public String getString(){
        String r = fieldType + " " + id;
        if (size > 0) {
            r += String.format("[%d]", size);
        }
        return r;
    }
}
