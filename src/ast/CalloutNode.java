package ast;

import java.io.PrintStream;

public class CalloutNode extends Node {
        private String functionName;
        private final Node functionArgs;

        public CalloutNode(String functionName, Node functionArgs) {

            this.functionName = functionName;
            this.functionArgs = functionArgs;
            // remove surrounding quotes
            if (this.functionName.charAt(0) == '"') this.functionName = this.functionName.substring(1);
            if (this.functionName.charAt(this.functionName.length() - 1) == '"') this.functionName = this.functionName.substring(0, this.functionName.length() - 1);
        }

        @Override
        public void print(String padding, PrintStream out) {
            out.println(padding + "<Callout functionName=\"" + getFunctionName() + "\">");
            out.println(padding + "  <Arguments>");
            getFunctionArgs().print(padding + "  ", out);
            out.println(padding + "  </Arguments>");
            out.println(padding + "</Callout>");
        }

    public String getFunctionName() {
        return functionName;
    }

    public Node getFunctionArgs() {
        return functionArgs;
    }
}
