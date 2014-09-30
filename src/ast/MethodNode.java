package ast;

import java.io.PrintStream;

public abstract class MethodNode extends Node {
    private final String type;
    private final String name;
    private final NodeList params;
    private final Node block;

    public MethodNode(String type, String name, NodeList params, Node block) {
        this.type = type;
        this.name = name;
        this.params = params;
        this.block = block;
    }

    @Override
    public void print(String padding, PrintStream out) {
        out.println(padding + type + " " + name + " ->");
        if (params.size() > 0) {
            out.println(padding + "(");
            params.print(padding + "  ", out);
            out.println(padding + ")");
        }
        out.println(padding + "{");
        block.print(padding + "  ", out);
        out.println(padding + "}");
    }
}
