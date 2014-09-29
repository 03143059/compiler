package ast;

import java.io.PrintStream;

public class BlockNode extends Node {
        private final Node vars;
        private final Node stmts;

        public BlockNode(Node vars, Node stmts) {
            this.vars = vars;
            this.stmts = stmts;
        }

        @Override
        public void print(String padding, PrintStream out) {
            out.println(padding + "Vars ->");
            vars.print(padding + "  ", out);
            out.println(padding + "Stmts ->");
            stmts.print(padding + "  ", out);
        }
    }
