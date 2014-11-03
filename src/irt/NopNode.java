package irt;

import java.io.PrintStream;

/**
 * Created by Werner on 10/20/2014.
 */
public class NopNode extends IrtNode {
    protected NopNode() {
        super("NOP");
    }

    @Override
    public void print(PrintStream out) {

    }
}
