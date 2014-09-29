package ast;

import java.io.PrintStream;

public class MethodNode extends Node {
    private final Node type;
    private final String name;
    private final Node params;
    private final Node block;

    public MethodNode(Node type, String name, Node params, Node block) {
        this.type = type;
        this.name = name;
        this.params = params;
        this.block = block;
    }

    public MethodNode(String type, String name, Node params, Node block) {
        this.type = new StringLiteral(type);
        this.name = name;
        this.params = params;
        this.block = block;
    }

    @Override
    public void print(String padding, PrintStream out) {
        if (type != null) {
            out.println(padding + "Type ->");
            type.print(padding + "  ", out);
        }
        out.println(padding + "Name ->");
        out.println(padding + "  " + name);
        if (params != null) {
            out.println(padding + "Params ->");
            params.print(padding + "  ", out);
        }
        out.println(padding + "Block ->");
        block.print(padding + "  ", out);
    }
}
