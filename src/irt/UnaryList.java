package irt;

import java.io.PrintStream;

/**
 * Created by Werner on 10/21/2014.
 */
public class UnaryList extends IrtList {

    private final String op;

    public UnaryList(IrtNode start, String op) {
        super("UnaryOp", start, new NopNode());
        this.op = op;
    }

    @Override
    public void print(PrintStream out){
        if (IrtNode.OutputAssembler) {
            out.println(getAssembler());
            return;
        }
        start.print(out);
        out.println("Unary operation: " + op);
    }

    @Override
    public String getAssembler() {
        StringBuilder sb = new StringBuilder();
        sb.append("\t");
        sb.append(op);
        sb.append("\t$a, $b, $c\n");
        return sb.toString();
    }
}
