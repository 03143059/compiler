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
        sb.append("var_");
        sb.append(id);
        sb.append(":\t.word\t");
        sb.append((size==0)?1:"0:"+size);
        sb.append("\t# int ");
        sb.append(id);
        sb.append((size==0)?"":"["+size+"]");
        return sb.toString();
    }
}
