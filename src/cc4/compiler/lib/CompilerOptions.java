package lib;

import ast.Ast;
import codegen.Codegen;
import irt.Irt;
import opt.Algebraic;
import opt.ConstantFolding;
import parser.CC4Parser;
import scanner.Scanner;
import semantic.Semantic;

import java.io.PrintStream;

/**
 * Created by Werner on 7/21/2014.
 */
public class CompilerOptions {
    private String filename = "";
    private String outputFile = "";
    private String target = "";
    private String opt = "";
    private String debug = "";
    public PrintStream out = null;

    public CompilerOptions() {
        setOut();
    }

    public String getFilename() {
        return filename;
    }

    public String getOutputFile() {
        return outputFile;
    }

    public String getTarget() {
        return target;
    }

    public String getOpt() {
        return opt;
    }

    public String getDebug() {
        return debug;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    private void setOut() {
        if (out == null) {
            out = System.out;
        } else {
            if (outputFile != null && outputFile.length() > 0){
                try {
                    out = new PrintStream(outputFile);
                } catch (Exception ex){
                    System.err.println("ERROR: " + ex.getMessage());
                }
            }
        }
    }

    public void setOutputFile(String outputFile) {
        this.outputFile = outputFile;
        setOut();
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public void setOpt(String opt) {
        this.opt = opt;
    }

    public void setDebug(String debug) {
        this.debug = debug;
    }

    public boolean isDebbuggingActiveFor(Object clase) {
        return (clase instanceof Scanner && debug.indexOf("scan") >= 0) ||
                (clase instanceof CC4Parser && debug.indexOf("parse") >= 0) ||
                (clase instanceof Ast && debug.indexOf("ast") >= 0) ||
                (clase instanceof Semantic && debug.indexOf("semantic") >= 0) ||
                (clase instanceof Irt && debug.indexOf("irt") >= 0) ||
                (clase instanceof Codegen && debug.indexOf("codegen") >= 0);
    }

    public boolean stopAt(Object clase) {
        return (target.length() > 0) &&
                ((clase instanceof Scanner && target.equals("scan")) ||
                (clase instanceof CC4Parser && target.equals("parse")) ||
                (clase instanceof Ast && target.equals("ast")) ||
                (clase instanceof Semantic && target.equals("semantic")) ||
                (clase instanceof Irt && target.equals("irt")) ||
                (clase instanceof Codegen && target.equals("codegen")));
    }
}
