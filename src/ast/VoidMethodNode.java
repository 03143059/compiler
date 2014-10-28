package ast;

public class VoidMethodNode extends MethodNode {

    public VoidMethodNode(String name, NodeList params, Node block) {
        super("VOID", name, params, block);
        Ast.ast.add(this);
    }

}
