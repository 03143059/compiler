package irt;

import java.io.PrintStream;

/**
 * Created by Werner on 10/21/2014.
 */
public class JumpList extends IrtList {
    private final IrtNode from;
    private final IrtNode to;

    public JumpList(IrtNode from, IrtNode to) {
        super("For", from, new NopNode());

        this.from = from;
        this.to = to;
    }

    @Override
    public void print(PrintStream out){
        out.println(name);
        start.print(out);
        from.print(out);
        to.print(out);
    }

    @Override
    public String getAssembler() {
        StringBuilder sb = new StringBuilder();
        sb.append("j label");
        return sb.toString();
    }
}
