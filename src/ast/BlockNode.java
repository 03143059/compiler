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
            if (getVars().size() > 0) {
                out.println(padding + "<Variables>");
                getVars().print(padding + "  ", out);
                out.println(padding + "</Variables>");
            }
            if (getStmts().size() > 0) {
                out.println(padding + "<Statements>");
                getStmts().print(padding + "  ", out);
                out.println(padding + "</Statements>");
            }
        }

    public NodeList getVars() {
        return vars;
    }

    public NodeList getStmts() {
        return stmts;
    }
}
