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
        out.println(padding + "<Method type=\""+ getType() + "\" name=\"" + getName() + "\">");
        if (getParams().size() > 0) {
            out.println(padding + "  <MethodParams>");
            getParams().print(padding + "  ", out);
            out.println(padding + "  </MethodParams>");
        }
        getBlock().print(padding + "  ", out);
        out.println(padding + "</Method>");
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public NodeList getParams() {
        return params;
    }

    public Node getBlock() {
        return block;
    }
}
