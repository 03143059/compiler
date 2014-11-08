package irt;

import java.io.PrintStream;

/**
 * Created by Werner on 10/21/2014.
 */
public class LoadList extends IrtList {
    private final String loc;

    public LoadList(IrtNode expr, String loc) {
        super("Load", expr, new NopNode());
        this.loc = loc;
    }

    @Override
    public void print(PrintStream out){
        if (IrtNode.OutputAssembler) {
            out.println(getAssembler());
            return;
        }
        out.println("load " + loc);
        start.print(out);
    }

    @Override
    public String getAssembler() {
        StringBuilder sb = new StringBuilder();
        sb.append("\tlw\t$a, $b($c)");
        sb.append(System.lineSeparator());
        return sb.toString();
    }
}
