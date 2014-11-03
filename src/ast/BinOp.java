package ast;

import java.io.PrintStream;

public class BinOp extends Node{
        private String operator;
        private Node left;
        private Node right;

        public BinOp(String op, Node l, Node r){

            operator = op;
            left = l;
            right = r;
        }

        public void print(String padding, PrintStream out){
            out.println(padding + "<BinaryOperation operator=\""+ getOperator() +"\">");
            out.println(padding + "  <LeftExpression>");
            getLeft().print(padding + "  ", out);
            out.println(padding + "  </LeftExpression>");
            out.println(padding + "  <RightExpression>");
            getRight().print(padding + "  ", out);
            out.println(padding + "  </RightExpression>");
            out.println(padding + "</BinaryOperation>");
        }

    public String getOperator() {
        return operator;
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }
}
