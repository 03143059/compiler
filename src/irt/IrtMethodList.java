package irt;

import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Werner on 10/21/2014.
 */
public class IrtMethodList extends IrtList {
    private final String type;
    private final HashMap<String, String> params;

    public IrtMethodList(String id, String type, HashMap<String, String> params, IrtNode block) {
        super(id, block, new NopNode());
        this.type = type;
        this.params = params;
    }

    @Override
    public void print(PrintStream out) {
        if (IrtNode.OutputAssembler) {
            out.println(getAssembler());
            return;
        }
        String r = getParamString();
        out.print("Method (name: " + name + ", returns: " + type);
        if (r.length() > 0)
            out.print(", params: " + r);
        out.println(")");
        start.print(out);
    }

    private String getParamString() {
        String r = "";
        for (Map.Entry<String, String> entry : params.entrySet()) {
            String var = entry.getKey();
            String type = entry.getValue();
            if (r.length() > 0) r += ", ";
            r += type + " " + var;
        }
        return r;
    }

    @Override
    public String getAssembler() {
        StringBuilder sb = new StringBuilder();
        // function header
        sb.append("##################################\n");
        sb.append("# Function: ");
        sb.append(name);
        sb.append(System.lineSeparator());
        sb.append("# Params: ");
        sb.append(getParamString());
        sb.append(System.lineSeparator());
        sb.append("# Returns: ");
        sb.append(type);
        sb.append(System.lineSeparator());
        sb.append("##################################\n");

        // function body
        sb.append(name);
        sb.append(":\n");

        // function variables
        sb.append("\t.data\n");

        // function body
        sb.append("\t.text\n");

        String assembler = start.getAssembler();

        if (assembler.length() > 0) {
            // reservar stack
            sb.append(String.format("\taddi	$sp, $sp, -%d\n", 4 + params.size() * 4));
            sb.append("\tsw	$ra, 0($sp)\t# reserve stack\n");
            int pc = 0;
            for (Map.Entry<String, String> ignored : params.entrySet()) {
                sb.append(String.format("\tsw	$a%d, %d($sp)\n", pc / 4, pc + 4));
                pc += 4;
            }

            sb.append(assembler);

            // function end
            sb.append(name);
            sb.append("_end:\n");

            // restaurar stack
            sb.append("\tlw	$ra, 0($sp)\t# restore stack\n");
            sb.append(String.format("\taddi	$sp, $sp, %d\n", 4 + params.size() * 4));
        }

        sb.append("\tjr	$ra\t# return\n");
        sb.append("##################################\n");
        sb.append("# End Function ");
        sb.append(name);
        sb.append("\n##################################\n\n");
        return sb.toString();
    }
}
