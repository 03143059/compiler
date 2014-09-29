package ast;

public class IntLiteral extends Node {
    private int value;

    public IntLiteral(String v){
        value = Integer.parseInt(v);
    }

    public void print(String padding){
        System.out.println(padding + value);
    }
}
