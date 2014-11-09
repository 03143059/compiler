package irt;

import java.io.PrintStream;

/**
 * Created by Werner on 11/5/2014.
 */
public class IrtLiteralNode extends IrtNode {
    private final int value;

    public IrtLiteralNode(int value) {
        super("literal");
        this.value = value;
    }

    @Override
    public void print(PrintStream out) {
        if (IrtNode.OutputAssembler) {
            out.println(getAssembler());
            return;
        }
        out.println("load immediate literal " + value);
    }

    @Override
    public String getAssembler() {
        StringBuilder sb = new StringBuilder();
        sb.append("\tli\t$t0, ");
        sb.append(value);
        sb.append(System.lineSeparator());
        return sb.toString();
    }
}
