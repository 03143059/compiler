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
        if (IrtNode.OutputAssembler) {
            out.println(getAssembler());
            return;
        }
        IrtNode n = getStart();
        while (n != null) {
//            if (!(n instanceof NopNode) && !(n instanceof StartNode) && !n.name.startsWith("-") && n.name.length()>0)
//                out.printf("\n[%s]\n", n.name.toUpperCase());
            n.print(out);
//            if (!(n instanceof NopNode) && !(n instanceof StartNode))
//                out.println();
            n = n.next;
        }
    }

    @Override
    public  String getAssembler() {
        StringBuilder sb = new StringBuilder();
        IrtNode n = getStart();
        while (n != null) {
            sb.append(n.getAssembler());
            n = n.next;
        }
        return sb.toString();
    }

    @Override
    public  String getString() {
        StringBuilder sb = new StringBuilder();
        IrtNode n = getStart();
        while (n != null) {
            if (sb.length() > 0) sb.append(", ");
            sb.append(n.getString());
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
