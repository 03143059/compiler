package ast;

import java.io.PrintStream;

public class CalloutNode extends Node {
        private final String func;
        private final Node args;

        public CalloutNode(String func, Node args) {
            Ast.ast.add(this);
            this.func = func;
            this.args = args;
        }

        @Override
        public void print(String padding, PrintStream out) {
            out.println(padding + "callout ");
            out.println(padding + "  " + func);
            out.println(padding + "args ->");
            args.print(padding + "  ", out);
        }
    }
