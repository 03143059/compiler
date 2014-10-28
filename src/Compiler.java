/* Compiler.java
 * Ciencias de la Computacion IV
 * Nombre: Werner Garcia
 * Carnet: 031-43059
 * Seccion: AN
 * Fecha: 21/07/14 01:58 PM
 * Proyecto #0 - Cli
 */

import lib.CliManager.*;
import lib.CompilerOptions;
import opt.Algebraic;
import opt.ConstantFolding;
import scanner.Scanner;

/**
 * Clase que controla las opciones del Compilador
 */
public class Compiler {
    /**
     * Cuerpo principal del programa
     *
     * @param args
     */
    public static void main(String[] args) {
        // crear el parseador de la linea de comandos
        CommandLineParser parser = new CommandLineParser();

        // crear las opciones
        Options options = new Options();
        options.addOption(Option
                .builder()
                .longOpt("gui")
                .desc("Muestra el resultado de debug del parser en forma grafica.")
                .build());
        options.addOption(Option
                .builder()
                .longOpt("o")
                .desc("Escribir el output a un archivo de texto llamado <outname>.")
                .hasArg()
                .argName("outname")
                .build());
        options.addOption(Option
                .builder()
                .longOpt("target")
                .desc("La compilacion procede hasta <stage>. Donde <stage> es uno de: scan, parse, ast, semantic, irt, codegen.")
                .hasArg()
                .argName("stage")
                .build());
        options.addOption(Option
                .builder()
                .longOpt("opt")
                .desc("Selecciona el nivel de optimizacion de la compilacion. Donde <optimization> es uno de: constant, algebraic.")
                .hasArg()
                .argName("optimization")
                .build());
        options.addOption(Option
                .builder()
                .longOpt("debug")
                .desc("Imprimir informacion de debugging por cada etapa listada en <stage>. Donde <stage> tiene las mismas opciones de -target. Tambien se pueden \"debuggear\" varias etapas, separandolas con ':' de la forma scan:parse:etc.")
                .hasArg()
                .argName("stage")
                .build());
        options.addOption(Option
                .builder()
                .longOpt("h")
                .desc("Muestra esta ayuda al usuario")
                .build());

        try {
            int argCount = args.length;

            // parsear los argumentos de la linea de comandos
            CommandLine cmdLine = parser.parse(options, args);

            CompilerOptions compilerOptions = new CompilerOptions();
            if (cmdLine.hasOption("gui")) {
                compilerOptions.setGui(true);
                argCount--;
            }

            // validar cada opcion
            if (cmdLine.hasOption("help") || cmdLine.hasOption("h")) {
                // generar automaticamente el texto de ayuda
                System.out.println("Uso: java Compiler [option] <filename>\n" +
                        "Simula el funcionamiento de un compilador");
                System.out.println();
                HelpFormatter formatter = new HelpFormatter();
                formatter.printHelp(options);
                System.exit(0);
            }

            if (cmdLine.hasOption("o")) {
                if (cmdLine.getOptionValue("o").length() == 0){
                    showHelp("ERROR en output: Debe indicar el nombre del archivo de salida");
                }
                argCount -= 2;
            }

            if (cmdLine.hasOption("target")) {
                // scan, parse, ast, semantic, irt, codegen
                String target = cmdLine.getOptionValue("target").toLowerCase();
                if (!target.equals("scan") &&
                        !target.equals("parse") &&
                        !target.equals("ast") &&
                        !target.equals("semantic") &&
                        !target.equals("irt") &&
                        !target.equals("codegen")) {
                    showHelp("ERROR en target: <target> debe ser uno de: scan, parse, ast, semantic, irt, codegen");
                }
                compilerOptions.setTarget(target);
                argCount -= 2;
            } else {
                /****************** SET DEFAULT MODE *************************/
                compilerOptions.setTarget("irt"); // default ast
                /****************** SET DEFAULT MODE *************************/
            }

            if (cmdLine.hasOption("opt")) {
                String opt = cmdLine.getOptionValue("opt").toLowerCase();
                // <optimization> es uno de: constant, algebraic.
                if (!opt.equals("constant") && !opt.equals("algebraic")) {
                    showHelp("ERROR en opt: <optimization> debe ser uno de: constant, algebraic");
                }
                compilerOptions.setOpt(opt);
                argCount -= 2;
            }

            if (cmdLine.hasOption("debug")) {
                String debug = cmdLine.getOptionValue("debug").toLowerCase();
                if (debug.indexOf("scan") < 0 &&
                        debug.indexOf("parse") < 0 &&
                        debug.indexOf("ast") < 0 &&
                        debug.indexOf("semantic") < 0 &&
                        debug.indexOf("irt") < 0 &&
                        debug.indexOf("codegen") < 0) {
                    showHelp("ERROR en debug: Debe indicar <stage>. Para mas informacion ver la ayuda.");
                }
                compilerOptions.setDebug(debug);
                argCount -= 2;
            }

            if (args.length == 0 || argCount != 1) {
                showHelp();
            }

            if (args[args.length - 1].startsWith("-"))
                showHelp("ERROR: El archivo de entrada debe ser un archivo valido.");

            compilerOptions.setFilename(args[args.length - 1]);
            // hasta aca para no generar el archivo antes de tiempo
            if (cmdLine.hasOption("o"))
                compilerOptions.setOutputFile(cmdLine.getOptionValue("o"));
            else {
                String f = args[args.length - 1];
                if (f.lastIndexOf('.') > 0)
                    f = f.substring(0, f.lastIndexOf('.'));
                f += ".s";
                compilerOptions.setOutputFile(f);
            }

            if (compilerOptions.getOpt().equals("algebraic"))
                new Algebraic(compilerOptions);
            else if (compilerOptions.getOpt().equals("constant"))
                new ConstantFolding(compilerOptions);

            Scanner scanner = new Scanner(compilerOptions);

        } catch (Exception exp) {
            System.out.println("Ha ocurrido un error: " + exp.getMessage());
            exp.printStackTrace();
        }
    }

    private static void showHelp() {
        showHelp("");
    }

    private static void showHelp(String msg) {
        if (msg.length() > 0) {
            System.out.println(msg);
            System.out.println();
        }
        System.out.println("Uso: java Compiler [option] <filename>\n" +
                "Utilice la opcion -h para ver la ayuda");
        System.out.println();
        System.exit(0);
    }

}
