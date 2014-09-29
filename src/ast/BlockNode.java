package ast;

public class BlockNode extends Node {
        private final Node vars;
        private final Node stmts;

        public BlockNode(Node vars, Node stmts) {
            this.vars = vars;
            this.stmts = stmts;
        }

        @Override
        public void print(String padding) {
            vars.print(padding + "\t");
            stmts.print(padding + "\t");
        }
    }
