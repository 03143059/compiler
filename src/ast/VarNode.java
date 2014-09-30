package ast;

import org.antlr.v4.runtime.tree.TerminalNode;

import java.io.PrintStream;
import java.util.List;

public abstract class VarNode extends Node {

        private final String varType;
        private final List<TerminalNode> varNames;

        public VarNode(String varType, List<TerminalNode> varNames) {
            this.varType = varType;
            this.varNames = varNames;
        }

        @Override
        public void print(String padding, PrintStream out) {
            out.println(padding + varType + " ->");
            for(TerminalNode varName : varNames)
                out.println(padding + "  " + varName.getText());
        }
    }
