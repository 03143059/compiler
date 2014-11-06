package irt;

import java.io.PrintStream;

/**
 * Created by Werner on 10/21/2014.
 */
public class BinOpList extends IrtList {

    private final IrtNode right;
    private final String op;

    public BinOpList(IrtNode left, IrtNode right, String op) {
        super("BinOP", left, new NopNode());
        this.right = right;
        this.op = op;
    }

    @Override
    public void print(PrintStream out){
        out.println("Binary operation: " + op);
        right.print(out);
        start.print(out);
    }

    @Override
    public String getAssembler() {
        StringBuilder sb = new StringBuilder();
        sb.append("COMMAND  $a, $b, $c");
        return sb.toString();
    }
}
