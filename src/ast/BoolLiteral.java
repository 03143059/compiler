package ast;

import java.io.PrintStream;

public class BoolLiteral extends Node {
        private boolean value;

        public BoolLiteral(String v){
            value = Boolean.parseBoolean(v);
        }

        public void print(String padding, PrintStream out){
            out.println(padding + value);
        }
    }
