package irt;

import java.io.PrintStream;

/**
 * Created by Werner on 11/5/2014.
 */
public class IrtVarNode extends IrtNode {
    private final String id;
    private final String type;

    public IrtVarNode(String id, String type) {
        super("var");
        this.id = id;
        this.type = type;
    }

    @Override
    public void print(PrintStream out) {
        if (IrtNode.OutputAssembler) {
            out.println(getAssembler());
            return;
        }
        out.println("declare variable " + id);
    }

    @Override
    public String getAssembler() {
        StringBuilder sb = new StringBuilder();
        sb.append("var_");
        sb.append(id);
        sb.append(":\t.word\t1\t# int ");
        sb.append(id);
        sb.append("\n");
        return sb.toString();
    }
}
