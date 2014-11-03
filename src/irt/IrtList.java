package irt;

import java.io.PrintStream;

/**
 * Created by Werner on 10/20/2014.
 */
public class IrtList extends IrtNode {
    public IrtNode start, end;

    public IrtList(IrtNode start, IrtNode end) {
        super("");
        this.start = start;
        this.end = end;
    }

    public void print(PrintStream out) {
        IrtNode n = start;
        while (n != null) {
            out.println(n.getName());
            n = n.next;
        }
    }
}
