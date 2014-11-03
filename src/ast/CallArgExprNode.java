package ast;

import java.io.PrintStream;

public class CallArgExprNode extends CallArgNode {
    private final Node expr;

    public CallArgExprNode(Node expr) {
        this.expr = expr;
    }

    @Override
    public void print(String padding, PrintStream out) {
        out.println(padding + "<Expression>");
        getExpr().print(padding + "  ", out);
        out.println(padding + "</Expression>");
    }

    public Node getExpr() {
        return expr;
    }
}
