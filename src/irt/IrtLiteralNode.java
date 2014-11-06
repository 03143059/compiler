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
        out.println("load immediate literal " + value);
    }

    @Override
    public String getAssembler() {
        return "li $t0, " + value;
    }
}
