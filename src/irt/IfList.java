package irt;

/**
 * Created by Werner on 10/21/2014.
 */
public class IfList extends IrtList {
    public IrtNode true_end, false_end;

    public IfList(IrtNode start, IrtNode end) {
        super(start, end);
    }
}
