package ast;

import java.io.PrintStream;

public class RetExprNode extends Node {
    private final Node expr;

    public RetExprNode(Node expr) {
        this.expr = expr;
    }

    @Override
    public void print(String padding, PrintStream out) {
        if (getExpr() == null) {
            out.println(padding + "<Return/>");
        } else {
            out.println(padding + "<Return>");
            getExpr().print(padding + "  ", out);
            out.println(padding + "</Return>");
        }
    }

    public Node getExpr() {
        return expr;
    }
}
