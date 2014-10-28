package irt;

import ast.Ast;
import ast.Node;
import ast.NodeList;
import codegen.Codegen;
import lib.CompilerOptions;
import lib.SymbolTable;
import semantic.Semantic;

import java.util.List;

public class Irt {

    private final Semantic semantic;

    public Irt(Semantic semantic) {
        this.semantic = semantic;
        CompilerOptions compilerOptions = semantic.getAst().getCc4Parser().getScanner().getCompilerOptions();
        System.out.println("stage: IRT");

        if (compilerOptions.isDebbuggingActiveFor(this))
            System.out.println("Debbugging IRT");

        try {
            printAst(Ast.ast.getList());

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
        } finally {
            if (!compilerOptions.stopAt(this))
                new Codegen(this);
        }

    }

    private void printAst(List<Node> list) {
        for (Node node : list){
            if (node instanceof NodeList){
                printAst(((NodeList)node).getList());
            } else
                System.out.println(node.getClass().getName());
        }
    }

    public Semantic getSemantic() {
        return semantic;
    }
}
