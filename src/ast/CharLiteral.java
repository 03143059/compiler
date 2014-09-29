package ast;

import java.io.PrintStream;

public class CharLiteral extends Node {
        //TODO: extract char value
        private String value;

        public CharLiteral(String v){
            value = v;
        }

        public void print(String padding, PrintStream out){
            out.println(padding + value);
        }
    }
