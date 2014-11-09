package irt;

import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Werner on 11/5/2014.
 */
public class IrtMethodNode extends IrtNode {

    private final String functionName;
    private final String type;
    private final String returnType;
    private final IrtNode nextField;
    private final HashMap<String, String> params;

    public IrtMethodNode(String functionName, String returnType, String type, IrtNode nextField, HashMap<String, String> params) {
        super("-method");
        this.functionName = functionName;
        this.type = type;
        this.returnType = returnType;
        this.nextField = nextField;
        this.params = params;
    }

    @Override
    public void print(PrintStream out) {
        if (IrtNode.OutputAssembler) {
            out.println(getAssembler());
            return;
        }
        if (type.equals("begin")) {
            String fieldsString = getFieldsString();
            out.println("Function Start: " + functionName);

            if (fieldsString.length() == 0) return;

            out.println("Begin Data Section");

            IrtNode n = nextField;
            while (n != null) {
                n.print(out);
                n = n.next;
            }

        } else if (type.equals("data")) {
            String fieldsString = getFieldsString();
            if (fieldsString.length() > 0)
                out.println("End Data Section");
            out.println("Begin Function Body");
        } else  if (type.equals("end"))  {
            IrtNode n = nextField;
            while (n != null) {
                n.print(out);
                n = n.next;
            }
            out.println("Function End: " + functionName);
        }
    }

    @Override
    public String getAssembler() {
        StringBuilder sb = new StringBuilder();
        if (type.equals("begin")) {
            String fieldsString = getFieldsString();

            // function header
            sb.append("##################################\n");
            sb.append("# Function: ");
            sb.append(functionName);
            sb.append(System.lineSeparator());
            sb.append("# Params: ");
            sb.append(getParamString());
            sb.append(System.lineSeparator());
            sb.append("# Returns: ");
            sb.append(returnType.toLowerCase());
            sb.append(System.lineSeparator());
            sb.append("##################################\n");

            // function body
            sb.append(functionName);
            sb.append(":\n");

            if (fieldsString.length() == 0) return sb.toString();

            sb.append("##################################\n");
            sb.append("# Data Section\n");
            sb.append("\n##################################\n");
            sb.append("\t.data\n");

            IrtNode n = nextField;
            while (n != null) {
                sb.append(n.getAssembler());
                n = n.next;
            }

        } else if (type.equals("data")) {
            String fieldsString = getFieldsString();
            if (fieldsString.length() > 0) {
                sb.append("##################################\n");
                sb.append("# End Data\n");
                sb.append("##################################\n\n");
            }
            sb.append("##################################\n");
            sb.append("# Function Body\n");
            sb.append("##################################\n\n");
            // function body
            sb.append("\t.text\n");
        } else  if (type.equals("end")){

            String assembler = ((IrtList)nextField).getAssembler();

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
                sb.append(functionName);
                sb.append("_end:\n");

                // restaurar stack
                sb.append("\tlw	$ra, 0($sp)\t# restore stack\n");
                sb.append(String.format("\taddi	$sp, $sp, %d\n", 4 + params.size() * 4));
            }

            sb.append("\tjr	$ra\t# return\n");
            sb.append("##################################\n");
            sb.append("# End Function ");
            sb.append(functionName);
            sb.append("\n##################################\n\n");
        }
        return sb.toString();
    }

    private String getFieldsString() {
        StringBuilder sb = new StringBuilder();
        IrtNode n = nextField;
        while (n != null) {
            if (!(n instanceof StartNode)) {
                if (sb.length() > 0) sb.append(", ");
                sb.append(n.getString());
            }
            n = n.next;
        }
        return sb.toString();
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
}
