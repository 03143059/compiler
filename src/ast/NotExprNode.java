package ast;

import java.io.PrintStream;

public class NotExprNode extends Node {
    private final Node expr;

    public NotExprNode(Node expr) {
        this.expr = expr;
    }

    @Override
    public void print(String padding, PrintStream out) {
        out.println(padding + "<NotExpression>");
        getExpr().print(padding + "  ", out);
        out.println(padding + "</NotExpression>");
    }

    public Node getExpr() {
        return expr;
    }
}
