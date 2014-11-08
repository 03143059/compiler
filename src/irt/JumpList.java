package irt;

import java.io.PrintStream;

/**
 * Created by Werner on 10/21/2014.
 */
public class JumpList extends IrtList {
    private final String id;

    public JumpList(String id, IrtNode params) {
        super("Jump", params, new NopNode());
        this.id = id;
    }

    @Override
    public void print(PrintStream out){
        if (IrtNode.OutputAssembler) {
            out.println(getAssembler());
            return;
        }
        out.println("load function parameters");
        IrtNode fd = start;
        while(fd != null) {
            fd.print(out);
            fd = fd.next;
        }
        out.println("jump to function: " + id);
    }

    @Override
    public String getAssembler() {
        StringBuilder sb = new StringBuilder();
        sb.append("\tj\t" + id);
        sb.append(System.lineSeparator());
        return sb.toString();
    }
}
