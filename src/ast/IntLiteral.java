package ast;

import java.io.PrintStream;

public class IntLiteral extends Node {
    private int value;

    public IntLiteral(String v){
        value = Integer.parseInt(v);

    }

    public void print(String padding, PrintStream out){
        out.println(padding + "<Int>" + getValue() + "</Int>");
    }

    public int getValue() {
        return value;
    }
}
