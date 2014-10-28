package ast;

import java.io.PrintStream;

public class LocArrayNode extends Node {
        private final String name;
        private final Node expr;

        public LocArrayNode(String name, Node expr) {
            Ast.ast.add(this);
            this.name = name;
            this.expr = expr;
        }

        @Override
        public void print(String padding, PrintStream out) {
            out.println(padding + name);
            out.println(padding + "[");
            expr.print(padding + "  ", out);
            out.println(padding + "]");
        }
    }
