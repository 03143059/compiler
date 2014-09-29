package ast;

public class BinOp extends Node{
        private String operator;
        private Node left;
        private Node right;

        public BinOp(String op, Node l, Node r){
            operator = op;
            left = l;
            right = r;
        }

        public void print(String padding){
            System.out.println(padding + operator);
            left.print(padding + "\t");
            right.print(padding + "\t");
        }
    }
