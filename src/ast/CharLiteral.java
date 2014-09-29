package ast;

public class CharLiteral extends Node {
        private char value;

        public CharLiteral(String v){
            value = v.charAt(0);
        }

        public void print(String padding){
            System.out.println(padding + value);
        }
    }
