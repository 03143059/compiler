package ast;

import java.io.PrintStream;

public class BlockNode extends Node {
        private final NodeList vars;
        private final NodeList stmts;

        public BlockNode(NodeList vars, NodeList stmts) {
            this.vars = vars;
            this.stmts = stmts;
        }

        @Override
        public void print(String padding, PrintStream out) {
            if (vars.size() > 0) {
                out.println(padding + "Vars ->");
                vars.print(padding + "  ", out);
            }
            if (stmts.size() > 0) {
                out.println(padding + "Stmts ->");
                stmts.print(padding + "  ", out);
            }
        }
    }
