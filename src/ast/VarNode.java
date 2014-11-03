package ast;

import org.antlr.v4.runtime.tree.TerminalNode;

import java.io.PrintStream;
import java.util.List;

public abstract class VarNode extends Node {

        private final String type;
        private final List<TerminalNode> varNames;

        public VarNode(String varType, List<TerminalNode> varNames) {
            this.type = varType;
            this.varNames = varNames;
        }

        @Override
        public void print(String padding, PrintStream out) {
            for(TerminalNode varName : getVarNames()) {
                out.println(padding + "<Variable type=\"" + getType() + "\">" + varName.getText() + "</Variable>");
            }
        }

    public String getType() {
        return type;
    }

    public List<TerminalNode> getVarNames() {
        return varNames;
    }
}
