package ast;

import java.io.PrintStream;

public class StringLiteral extends Node {
        private String value;

        public StringLiteral(String v){
            value = v;
        }

        public void print(String padding, PrintStream out){
            out.println(padding + value);
        }
    }
