package ast;

import java.io.PrintStream;

public class StringLiteral extends Node {
        private String value;

        public StringLiteral(String v){
            value = v;
            // remove surrounding quotes
            if (value.charAt(0) == '"') value = value.substring(1);
            if (value.charAt(value.length() - 1) == '"') value = value.substring(0, value.length() - 1);

        }

        public void print(String padding, PrintStream out){
            out.println(padding + getValue());
        }

    public String getValue() {
        return value;
    }
}
