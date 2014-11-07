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
        sb.append("##################################");
        sb.append(System.lineSeparator());
        sb.append("# Function: ");
        sb.append(name);
        sb.append(System.lineSeparator());
        sb.append("# Params: ");
        sb.append(getParamString());
        sb.append(System.lineSeparator());
        sb.append("# Returns: ");
        sb.append(type);
        sb.append(System.lineSeparator());
        sb.append("################################## ");
        sb.append(System.lineSeparator());
        sb.append("test2:");
        sb.append(System.lineSeparator());
        sb.append("	.data");
        sb.append(System.lineSeparator());
        sb.append("	.text");
        sb.append(System.lineSeparator());
        sb.append("	addi	$sp, $sp, -4		# reserve stack");
        sb.append(System.lineSeparator());
        sb.append("	sw	$ra, 0($sp)");
        sb.append(System.lineSeparator());

        sb.append("	# SI NO HAY INSTRUCCIONES ESTO SE PUEDE REMOVER");
        sb.append(start.getAssembler());

        sb.append(System.lineSeparator());
        sb.append("	lw	$ra, 0($sp)");
        sb.append(System.lineSeparator());
        sb.append("	addi	$sp, $sp, 4		# restore stack");
        sb.append(System.lineSeparator());
        sb.append("	jr	$ra		# return");
        sb.append(System.lineSeparator());
        sb.append("################################## ");
        sb.append(System.lineSeparator());
        sb.append("# End Function ");
        sb.append(name);
        sb.append(System.lineSeparator());
        sb.append("################################## ");
        sb.append(System.lineSeparator());
        sb.append("");
        sb.append(System.lineSeparator());
        return sb.toString();
    }
}
