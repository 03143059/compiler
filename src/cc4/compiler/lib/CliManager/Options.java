/**
 * Ciencias de la Computacion II
 * Nombre: Werner Garcia
 * Carnet: 031-43059
 * Fecha: 25/08/13 12:20 AM
 * Proyecto #1 - Bmp Image Handler
 */

package lib.CliManager;

import java.util.LinkedList;

public class Options {
    LinkedList<Option> options;

    public Options() {
        options = new LinkedList<Option>();
    }

    public void addOption(Option option) {
        options.add(option);
    }

    public Option[] getOptions() {
        return options.toArray(new Option[0]);
    }
}
