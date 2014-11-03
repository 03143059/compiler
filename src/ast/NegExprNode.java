package ast;

import java.io.PrintStream;

public class NegExprNode extends Node {
    private final Node expr;

    public NegExprNode(Node expr) {
        this.expr = expr;
    }

    @Override
    public void print(String padding, PrintStream out) {
        out.println(padding + "<NegativeExpression>");
        getExpr().print(padding + "  ", out);
        out.println(padding + "</NegativeExpression>");
    }

    public Node getExpr() {
        return expr;
    }
}
