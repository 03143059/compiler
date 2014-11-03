package ast;

import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.List;

public class BooleanVarNode extends VarNode {

    public BooleanVarNode(List<TerminalNode> varNames) {
        super("BOOLEAN", varNames);

    }

}
