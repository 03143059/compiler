/**
 * Ciencias de la Computacion II
 * Nombre: Werner Garcia
 * Carnet: 031-43059
 * Fecha: 25/08/13 12:20 AM
 * Proyecto #1 - Bmp Image Handler
 */

package lib.CliManager;

public class CommandLineParser {
    public CommandLine parse(Options options, String[] args) throws Exception {
        Options tmpOps = new Options();
        Option[] ops = options.getOptions();
        for (int i = 0; i <args.length; i++){
            for (int j = 0; j < ops.length; j++) {
                if (args[i].charAt(0) == '-') {
                    String arg = args[i].substring(1);
                    if ((arg.equals(ops[j].getOpt())) || (arg.equals(ops[j].getLongOpt()))){
                        Option op = Option
                                .builder(ops[j].getOpt())
                                .longOpt(ops[j].getLongOpt())
                                .desc(ops[j].getDescription())
                                .build();
                        if (ops[j].getHasArg()) {
                            if (i+1 < args.length) {
                                if (args[i + 1].charAt(0) == '-'){
                                    throw new Exception("Hay un parametro en vez del archivo");
                                }
                                op.setArgName(args[i + 1]);
                                op.setHasArg();
                            } else {
                                throw new Exception("Falta el archivo");
                            }
                        }
                        tmpOps.addOption(op);
                    }
                }
            }
        }
        return new CommandLine(tmpOps.getOptions());
    }
}
