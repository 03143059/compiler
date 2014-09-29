package ast;

public class ForNode extends Node {
        private final String varName;
        private final Node start;
        private final Node cond;
        private final Node body;

        public ForNode(String varName, Node start, Node cond, Node body) {
            this.varName = varName;
            this.start = start;
            this.cond = cond;
            this.body = body;
        }

        @Override
        public void print(String padding) {
            System.out.println(padding + "FOR "  + varName);
            System.out.println(padding + "Inicio:");
            start.print(padding + "\t");
            System.out.println(padding + "Condicion:");
            cond.print(padding + "\t");
            System.out.println(padding + "Cuerpo:");
            body.print(padding + "\t");
        }
    }
