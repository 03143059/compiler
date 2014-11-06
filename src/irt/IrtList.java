package irt;

import java.io.PrintStream;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * Created by Werner on 10/20/2014.
 */

public class IrtList extends IrtNode{

    protected IrtNode start;
    protected IrtNode end;

    public IrtList(String name, IrtNode start, IrtNode end) {
        super(name);
        this.start = start;
        this.end = end;
    }

    public IrtList(IrtNode start, IrtNode end) {
        this("", start, end);
    }

    public void print(PrintStream out) {
        IrtNode n = getStart();
        while (n != null) {
            if (!(n instanceof NopNode) && !(n instanceof StartNode) && !n.name.startsWith("-") && n.name.length()>0)
                out.printf("[%s]\n", n.name.toUpperCase());
            n.print(out);
//            if (!(n instanceof NopNode) && !(n instanceof StartNode))
//                out.println();
            n = n.next;
        }
    }

    public  String getAssembler() {
        StringBuilder sb = new StringBuilder();
        IrtNode n = getStart();
        while (n != null) {
            sb.append(n.getAssembler());
            sb.append(System.lineSeparator());
            n = n.next;
        }
        return sb.toString();
    }


    public IrtNode getStart() {
        return start;
    }

    public void setStart(IrtNode node) {
        node.next = start;
        start = node;
    }

    public IrtNode getEnd() {
        return end;
    }

}
