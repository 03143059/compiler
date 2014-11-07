package irt;

import java.io.PrintStream;

/**
 * Created by Werner on 11/5/2014.
 */
public class IrtProgramNode extends IrtNode {

    private final String type;
    private final IrtNode nextField;

    public IrtProgramNode(String type) {
        super("-program");
        this.type = type;
        this.nextField = null;
    }

    public IrtProgramNode(String type, IrtNode nextField) {
        super("-program");
        this.type = type;
        this.nextField = nextField;
    }

    @Override
    public void print(PrintStream out) {
        if (IrtNode.OutputAssembler) {
            out.println(getAssembler());
            return;
        }

        if (type.equals("begin")) {
            out.println("PROGRAM START");
            out.println("BEGIN GLOBAL SECTION");

            IrtNode n = nextField;
            while (n != null) {
                n.print(out);
                n = n.next;
            }

        } else {
            out.println("END GLOBAL SECTION");
        }
    }

    @Override
    public String getAssembler() {
        StringBuilder sb = new StringBuilder();
        if (type.equals("begin")) {
            sb.append("##################################\n");
            sb.append("# Global Declarations\n");
//            sb.append("# Variables: ");
//            sb.append(getFieldsString());
            sb.append("##################################\n");
            sb.append("	.data\n");

            IrtNode n = nextField;
            while (n != null) {
               sb.append(n.getAssembler());
                n = n.next;
            }

        } else {
            sb.append("##################################\n");
            sb.append("# End Global\n");
            sb.append("##################################\n\n");
            sb.append("\t.globl	main\n");
            sb.append("\t.text\n");
            sb.append("\tj\tmain\t# jump to main program\n");
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
}
