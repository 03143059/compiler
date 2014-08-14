/**
 * Ciencias de la Computacion II
 * Nombre: Werner Garcia
 * Carnet: 031-43059
 * Fecha: 25/08/13 12:24 AM
 * Proyecto #1 - Bmp Image Handler
 */

package lib.CliManager;

public class HelpFormatter {

    public void printHelp(Options options) {
        Option[] ops = options.getOptions();
        int col1 = 0, col2 = 0, col3 = 0;
        for (int i = 0; i < ops.length; i++){
            String l = "-" + ops[i].getLongOpt();
            if (ops[i].getHasArg())
                l += " <" + ops[i].getArgName() + ">";
            if (l.length() > col1) col1 = l.length();
        }
        for (int i = 0; i < ops.length; i++){
            String l = "-" + ops[i].getLongOpt();
            if (ops[i].getHasArg())
                l += " <" + ops[i].getArgName() + ">";
            if (l.length() < col1)
                l += spaces(col1 - l.length());
            String desc = ops[i].getDescription();
            while (desc.length() > (77 - col1)) {
                int lastIdx = findLastIdx(desc, 77 - col1);
                String tmpDesc = desc.substring(0, lastIdx).trim();
                System.out.println(l + "  " + tmpDesc);
                l = spaces(col1);
                desc = desc.substring(lastIdx).trim();
            }
            System.out.println(l + "  " + desc);
        }
        System.out.println();
    }

    private int findLastIdx(String desc, int idx) {
        if (Character.isSpaceChar(desc.charAt(idx))) return idx;
        for (int i = idx; i >= 0; i--)
            if (Character.isSpaceChar(desc.charAt(i))) return i;
        return idx;
    }

    private String spaces(int num) {
        String r = "";
        for (int i = 0; i < num; i++)
            r += " ";
        return r;
    }
}
