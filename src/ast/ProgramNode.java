package ast;

import java.io.PrintStream;

/**
 * Created by Werner on 9/29/2014.
 */
public class ProgramNode extends Node {
    private final NodeList<FieldNode> fields;
    private final NodeList<MethodNode> methods;

    public ProgramNode(NodeList<FieldNode> fields, NodeList<MethodNode> methods) {
        this.fields = fields;
        this.methods = methods;
    }

    @Override
    public void print(String padding, PrintStream out) {
        out.println("<?xml version=\"1.0\"?>");
        out.println("<Program classname=\"Program\">");
        out.println(padding + "<Fields>");
        getFields().print(padding, out);
        out.println(padding + "</Fields>");
        out.println(padding + "<Methods>");
        getMethods().print(padding + "  ", out);
        out.println(padding + "</Methods>");
        out.println("</Program>");
    }

    public NodeList<FieldNode> getFields() {
        return fields;
    }

    public NodeList<MethodNode> getMethods() {
        return methods;
    }
}
