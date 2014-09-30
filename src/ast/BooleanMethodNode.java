package ast;

public class BooleanMethodNode extends MethodNode {

    public BooleanMethodNode(String name, NodeList params, Node block) {
        super("BOOLEAN", name, params, block);
    }

}
