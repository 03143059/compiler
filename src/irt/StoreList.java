package irt;

import ast.OperatorType;

import java.io.PrintStream;

/**
 * Created by Werner on 10/21/2014.
 */
public class StoreList extends IrtList {
    private final IrtNode loc;
    private final OperatorType op;

    public StoreList(IrtNode expr, IrtNode loc, OperatorType op) {
        super("Store", expr, new NopNode());
        this.loc = loc;
        this.op = op;
    }

    @Override
    public void print(PrintStream out){
        out.println("store " + start.name + " on " + loc.name + " with op " + op);
        start.print(out);
    }

    @Override
    public String getAssembler() {
        StringBuilder sb = new StringBuilder();
        sb.append("sw  $a, $b($c)");
        return sb.toString();
    }
}
