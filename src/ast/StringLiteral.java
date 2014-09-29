package ast;

public class StringLiteral extends Node {
        private String value;

        public StringLiteral(String v){
            value = v;
        }

        public void print(String padding){
            System.out.println(padding + value);
        }
    }
