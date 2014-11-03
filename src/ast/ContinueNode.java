package ast;

import java.io.PrintStream;

public class ContinueNode extends Node {

    public ContinueNode() {
    }

    @Override
    public void print(String padding, PrintStream out) {
            out.println(padding + "<Continue/>");
    }

}
