package codegen;

import irt.Irt;
import lib.CompilerOptions;

public class Codegen {

    private final Irt irt;

    public Codegen(Irt irt) {
        this.irt = irt;
        CompilerOptions compilerOptions = irt.getSemantic().getAst().getCc4Parser().getScanner().getCompilerOptions();
        System.out.println("stage: Code Generation");
        if (compilerOptions.isDebbuggingActiveFor(this))
            System.out.println("Debbugging Code Generation");

        try {


//            IrtVisitor visitor = new IrtVisitor();
//            IrtList list = (IrtList) visitor.visit(semantic.getAst().getTree());
//
//            if (compilerOptions.stopAt(this))
//                list.print(compilerOptions.out);
//            if (compilerOptions.isDebbuggingActiveFor(this))
//                list.print(System.out);



        } catch (Exception e){
            System.err.println("ERROR: " + e.getMessage());
            //e.printStackTrace();
        }
    }
}
