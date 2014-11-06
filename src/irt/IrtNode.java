package irt;

import java.io.PrintStream;

/**
 * Created by Werner on 10/20/2014.
 */
public abstract class IrtNode {
    public IrtNode next = null;
    public String name;

    protected IrtNode(String name){
        this.name = name;
    }

    public abstract void print(PrintStream out);
    public abstract String getAssembler();

}
