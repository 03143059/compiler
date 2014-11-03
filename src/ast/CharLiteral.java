package ast;

import java.io.PrintStream;

public class CharLiteral extends Node {

    private char value;

    public CharLiteral(String v) {
        // remove single quotes
        if (v.length() == 3)
            value = v.charAt(1);
        else if (v.length() == 1)
            value = v.charAt(0);
    }

    public void print(String padding, PrintStream out) {
        out.println(padding + "<Char>" + getValue() + "</Char>");
    }

    public char getValue() {
        return value;
    }
}
