package irt;

import java.io.PrintStream;

/**
 * Created by Werner on 10/21/2014.
 */
public class CmdList extends IrtList {
    private final String cmd;

    public CmdList(IrtNode start, String cmd) {
        super("-Cmd", start, new NopNode());
        this.cmd = cmd;
    }

    @Override
    public void print(PrintStream out){
        if (IrtNode.OutputAssembler) {
            out.println(getAssembler());
            return;
        }
        start.print(out);
        out.println("Execute command: " + cmd);
    }

    @Override
    public String getAssembler() {
        StringBuilder sb = new StringBuilder();
        sb.append("\t");
        sb.append(cmd);
        sb.append("\t$a, $b, $c\n");
        return sb.toString();
    }
}
