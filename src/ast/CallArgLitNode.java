package ast;

import java.io.PrintStream;

public class CallArgLitNode extends CallArgNode {
    private String expr;

    public CallArgLitNode(String expr) {
        this.expr = expr;
        // remove surrounding quotes
        if (this.expr.charAt(0) == '"') this.expr = this.expr.substring(1);
        if (this.expr.charAt(this.expr.length() - 1) == '"') this.expr = this.expr.substring(0, this.expr.length() - 1);
    }

    @Override
    public void print(String padding, PrintStream out) {
        out.println(padding + "<String>" + getExpr() + "</String>");
    }

    public String getExpr() {
        return expr;
    }
}
