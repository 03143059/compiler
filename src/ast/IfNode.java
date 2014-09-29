package ast;

public class IfNode extends Node {
        private final Node expr;
        private final Node ifs;
        private final Node els;

        public IfNode(Node expr, Node ifs, Node els) {
            this.expr = expr;
            this.ifs = ifs;
            this.els = els;
        }

        @Override
        public void print(String padding) {
            System.out.println(padding + "If ");
            expr.print(padding + "\t");
            System.out.println(padding + "Verdadero:");
            ifs.print(padding + "\t");
            if (els != null) {
                System.out.println(padding + "Else:");
                els.print(padding + "\t");
            }
        }
    }
