package irt;

import java.io.PrintStream;

/**
 * Created by Werner on 11/5/2014.
 */
public class IrtProgramNode extends IrtNode {

    public IrtProgramNode() {
        super("-program");
    }

    @Override
    public void print(PrintStream out) {
        out.println("Start Program");
    }

    @Override
    public String getAssembler() {
        StringBuilder sb = new StringBuilder();
        sb.append("##################################");
        sb.append(System.lineSeparator());
        sb.append("# Global Declarations");
        sb.append(System.lineSeparator());
        sb.append("# Variables: int a, int b, int c[3]");
        sb.append(System.lineSeparator());
        sb.append("################################## ");
        sb.append(System.lineSeparator());
        sb.append("	.data");
        return sb.toString();
    }
}
