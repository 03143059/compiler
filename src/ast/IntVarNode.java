package ast;

import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.List;

public class IntVarNode extends VarNode {

    public IntVarNode(List<TerminalNode> varNames) {
        super("INT", varNames);

    }

}
