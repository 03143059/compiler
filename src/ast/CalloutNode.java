package ast;

public class CalloutNode extends Node {
        private final String func;
        private final Node args;

        public CalloutNode(String func, Node args) {
            this.func = func;
            this.args = args;
        }

        @Override
        public void print(String padding) {
            System.out.println(padding + "callout " + func );
            args.print(padding + "\t");
        }
    }
