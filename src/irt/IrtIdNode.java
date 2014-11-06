package irt;

import java.io.PrintStream;

/**
 * Created by Werner on 11/5/2014.
 */
public class IrtIdNode extends IrtNode {
    private final String id;

    public IrtIdNode(String id) {
        super("id");
        this.id = id;
    }

    @Override
    public void print(PrintStream out) {
        out.println("load variable " + id);
    }

    @Override
    public String getAssembler() {
        return "la $t0 var_" + id;
    }
}
