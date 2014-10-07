package ast;

import lib.CompilerOptions;

import java.io.PrintStream;

/**
 * Created by Werner on 9/29/2014.
 */
public class ProgramNode extends Node {
    private final Node fields;
    private final Node methods;

    public ProgramNode(Node fields, Node methods) {
        this.fields = fields;
        this.methods = methods;
    }

    @Override
    public void print(String padding, PrintStream out) {
        out.println("Start ->");
        out.println(padding + "class");
        out.println(padding + "Program");
        out.println(padding + "Fields ->");
        fields.print(padding + "  ", out);
        out.println(padding + "Methods ->");
        methods.print(padding + "  ", out);
    }

}
