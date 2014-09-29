package ast;

public class MethodNode extends Node {
    private final Node type;
    private final String name;
    private final Node params;
    private final Node body;

    public MethodNode(Node type, String name, Node params, Node body) {
        this.type = type;
        this.name = name;
        this.params = params;
        this.body = body;
    }

    @Override
    public void print(String padding) {
        type.print(padding + "\t");
        System.out.println(padding + name);
        if (params != null) {
            System.out.println(padding + "Parametros:");
            params.print(padding + "\t");
        }
        System.out.println(padding + "Cuerpo:");
        body.print(padding + "\t");
    }
}
