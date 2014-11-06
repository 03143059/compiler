package irt;

import java.io.PrintStream;

/**
 * Created by Werner on 11/5/2014.
 */
public class IrtStringNode extends IrtNode {
    private final String value;

    public IrtStringNode(String value) {
        super("string");
        this.value = value;
    }

    @Override
    public void print(PrintStream out) {
        out.println("load string " + value);
    }

    @Override
    public String getAssembler() {
        StringBuilder sb = new StringBuilder();
        sb.append("\t.data");
        sb.append(System.lineSeparator());
        sb.append("str1:\t.asciiz \"");
        sb.append(value);
        sb.append("\"");
        sb.append(System.lineSeparator());
        sb.append("\t.text");
        sb.append(System.lineSeparator());
        sb.append("\tla $t0, str1");
        sb.append(System.lineSeparator());
        return sb.toString();
    }
}
