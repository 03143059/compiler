package irt;

import java.io.PrintStream;

/**
 * Created by Werner on 10/20/2014.
 */
public class StartNode extends IrtNode {
    protected StartNode() {
        super("START");
    }

    @Override
    public void print(PrintStream out) {
    }

    @Override
    public String getAssembler() {
        return "";
    }
}
