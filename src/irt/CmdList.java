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
        start.print(out);
        out.println("Execute command: " + cmd);
    }

    @Override
    public String getAssembler() {
        StringBuilder sb = new StringBuilder();
        sb.append("COMMAND  $a, $b, $c");
        return sb.toString();
    }
}
