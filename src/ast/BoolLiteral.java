package ast;

public class BoolLiteral extends Node {
        private boolean value;

        public BoolLiteral(String v){
            value = Boolean.parseBoolean(v);
        }

        public void print(String padding){
            System.out.println(padding + value);
        }
    }
