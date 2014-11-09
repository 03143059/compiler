package irt;

import java.io.PrintStream;

/**
 * Created by Werner on 11/5/2014.
 */
public class IrtProgramNode extends IrtNode {

    private final String type;
    private final IrtNode nextField;

    public IrtProgramNode(String type) {
        this(type, null);
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
        String fieldsString = getFieldsString();
        if (type.equals("begin")) {
            out.println("Program Start");
            if (fieldsString.length() == 0) return;
            out.println("Begin Global Section");

            IrtNode n = nextField;
            while (n != null) {
                n.print(out);
                n = n.next;
            }
        } else if (type.equals("data")){
            if (fieldsString.length() > 0)
                out.println("End Global Section");
        } else if (type.equals("end")){
            out.println("Begin Program Body");
            out.println("Call Function main");
            out.println("End Program");
        }
    }

    @Override
    public String getAssembler() {
        StringBuilder sb = new StringBuilder();
        String fieldsString = getFieldsString();
        if (type.equals("begin")) {
            sb.append("##################################\n");
            sb.append("# Begin Program\n");
            sb.append("##################################\n\n");

            if (fieldsString.length() == 0) return sb.toString();

            sb.append("##################################\n");
            sb.append("# Global Declarations\n");
//            sb.append("# Variables: ");
//            sb.append(fieldsString);
            sb.append("\n##################################\n");
            sb.append("\t.data\n");

            IrtNode n = nextField;
            while (n != null) {
               sb.append(n.getAssembler());
                n = n.next;
            }
        } else if (type.equals("data")){
            if (fieldsString.length() > 0) {
                sb.append("##################################\n");
                sb.append("# End Global\n");
                sb.append("##################################\n\n");
            }
        } else if (type.equals("end")){
            sb.append("##################################\n");
            sb.append("# Program Body\n");
            sb.append("##################################\n\n");
            sb.append("\t.globl	main\n");
            sb.append("\t.text\n");
            sb.append("\tj\tmain\t# jump to main function\n");
            sb.append("\tli\t$v0, 10\n\tsyscall\t# exit\n\n");
            sb.append("##################################\n");
            sb.append("# End Program\n");
            sb.append("##################################\n\n");
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
