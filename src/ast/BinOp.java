package ast;

import java.io.PrintStream;

public class BinOp extends Node{
        private String operator;
        private Node left;
        private Node right;

        public BinOp(String op, Node l, Node r){
            Ast.ast.add(this);
            operator = op;
            left = l;
            right = r;
        }

        public void print(String padding, PrintStream out){
            out.println(padding + "expr ->");
            left.print(padding + "  ", out);
            out.println(padding + "op ->");
            out.println(padding + "  " + operator);
            out.println(padding + "expr ->");
            right.print(padding + "  ", out);
        }
    }
