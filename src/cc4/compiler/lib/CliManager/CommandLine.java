/**
 * Ciencias de la Computacion II
 * Nombre: Werner Garcia
 * Carnet: 031-43059
 * Fecha: 25/08/13 12:24 AM
 * Proyecto #1 - Bmp Image Handler
 */

package lib.CliManager;

public class CommandLine {
    Option[] options;

    public CommandLine(Option[] options) {
        this.options = options;
    }

    public boolean hasOption(String opt) {
        for (int i = 0; i < options.length; i++)
            if ((opt.equals(options[i].getOpt())) || (opt.equals(options[i].getLongOpt()))) return true;
        return false;
    }

    public String getOptionValue(String opt) {
        for (int i = 0; i < options.length; i++)
            if ((opt.equals(options[i].getOpt())) || (opt.equals(options[i].getLongOpt()))) return options[i].getArgName();
        return null;
    }
}
