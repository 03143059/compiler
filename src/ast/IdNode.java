package ast;

import java.io.PrintStream;

public class IdNode extends Node {
    private final String name;

    public IdNode(String name) {
        this.name = name;
    }

    @Override
    public void print(String padding, PrintStream out) {
        out.println(padding + "<Id>" + getName() + "</Id>");
    }

    public String getName() {
        return name;
    }
}
