package ast;

/**
 * Created by Werner on 9/29/2014.
 */
public class IntMethodParamNode extends MethodParamNode {
    public IntMethodParamNode(String name) {
        super("INT", name);
        Ast.ast.add(this);
    }
}
