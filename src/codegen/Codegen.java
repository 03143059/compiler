package codegen;

import irt.Irt;
import irt.IrtList;
import irt.IrtNode;
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
           IrtList list = irt.GetList();
           IrtNode.OutputAssembler = true;

            if (compilerOptions.stopAt(this))
                list.print(compilerOptions.out);
            if (compilerOptions.isDebbuggingActiveFor(this))
                list.print(System.out);

        } catch (Exception e) {
            System.err.println("ERROR: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
