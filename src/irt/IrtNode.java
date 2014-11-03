package irt;

import java.io.PrintStream;

/**
 * Created by Werner on 10/20/2014.
 */
public abstract class IrtNode {
    public IrtNode next = null;
    private String name;

    protected IrtNode(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract void print(PrintStream out);
}
