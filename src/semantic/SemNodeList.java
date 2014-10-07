package semantic;

import java.io.PrintStream;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Werner on 10/6/2014.
 */
public class SemNodeList extends SemNode {
    private List<SemNode> list;

    public int size() {
        return (list == null)? 0 : list.size();
    }

    public SemNodeList(){
        list = new LinkedList<SemNode>();
    }

    public void add(SemNode node){
        list.add(node);
    }

    @Override
    public boolean ok() {
        for (SemNode node : list)
            if (!node.ok()) return false;
        return true;
    }
}
