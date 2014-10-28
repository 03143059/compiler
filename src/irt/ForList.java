package irt;

/**
 * Created by Werner on 10/21/2014.
 */
public class ForList extends IrtList {
    private final IrtNode from;
    private final IrtNode to;

    public ForList(IrtNode from, IrtNode to) {
        super(from, new NopNode());

        this.from = from;
        this.to = to;
    }
}
