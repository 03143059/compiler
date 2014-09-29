package ast;

import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.List;

public class VarNode extends Node {

        private final Node varType;
        private final List<TerminalNode> varNames;

        public VarNode(Node varType, List<TerminalNode> varNames) {
            this.varType = varType;
            this.varNames = varNames;
        }

        @Override
        public void print(String padding) {
            System.out.println(padding + "Variables:");
            varType.print(padding + "\t");
            for(TerminalNode varName : varNames)
                System.out.println(padding + varName.getText());
        }
    }
