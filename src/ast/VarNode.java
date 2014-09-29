package ast;

import org.antlr.v4.runtime.tree.TerminalNode;

import java.io.PrintStream;
import java.util.List;

public class VarNode extends Node {

        private final Node varType;
        private final List<TerminalNode> varNames;

        public VarNode(Node varType, List<TerminalNode> varNames) {
            this.varType = varType;
            this.varNames = varNames;
        }

        @Override
        public void print(String padding, PrintStream out) {
            out.println(padding + "Type ->");
            varType.print(padding + "  ", out);
            out.println(padding + "Names ->");
            for(TerminalNode varName : varNames)
                out.println(padding + "  " + varName.getText());
        }
    }
