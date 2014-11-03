package ast;

import java.io.PrintStream;

public class BlockNode extends Node {
        private final NodeList<VarNode> vars;
        private final NodeList<Node> stmts;

        public BlockNode(NodeList<VarNode> vars, NodeList<Node> stmts) {

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

    public NodeList<VarNode> getVars() {
        return vars;
    }

    public NodeList<Node> getStmts() {
        return stmts;
    }
}
