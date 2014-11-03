package ast;

import java.io.PrintStream;

public class BreakNode extends Node {

    public BreakNode() {
    }

    @Override
    public void print(String padding, PrintStream out) {
        out.println(padding + "<Break/>");
    }

}
