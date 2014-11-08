package irt;

import java.io.PrintStream;

/**
 * Created by Werner on 10/21/2014.
 */
public class IfList extends IrtList {
    public IrtNode true_end, false_end;

    public IfList(IrtNode start, IrtNode end, IrtNode iftrue, IrtNode iffalse) {
        super("If", start, end);
        true_end = iftrue;
        false_end = iffalse;
    }

    @Override
    public void print(PrintStream out){
        if (IrtNode.OutputAssembler) {
            out.println(getAssembler());
            return;
        }
        out.println("Evaluate boolean expression");
        start.print(out);
        out.println("If result is true");
        true_end.print(out);
        if (false_end != null) {
            out.println("If result is false");
            false_end.print(out);
        }
    }

    @Override
    public String getAssembler() {
        StringBuilder sb = new StringBuilder();
        sb.append("# if stmt");
        sb.append(System.lineSeparator());
        sb.append("	beqz	$a1, gcd_lbl2	# lleva un lc (label count) por metodo, brinca al lc+2 (true block)");
        sb.append(System.lineSeparator());
        sb.append("	");
        sb.append(System.lineSeparator());
        sb.append("gcd_lbl1: # false block");
        sb.append(System.lineSeparator());
        sb.append("");
        sb.append(System.lineSeparator());
        sb.append("	lw	$t0, 8($sp)	# load param t0 = b");
        sb.append(System.lineSeparator());
        sb.append("	");
        sb.append(System.lineSeparator());
        sb.append("	lw	$t1, 4($sp)	# load param t1 = a");
        sb.append(System.lineSeparator());
        sb.append("	");
        sb.append(System.lineSeparator());
        sb.append("	div	$t1, $t0	# div a/b y recuperar residuo");
        sb.append(System.lineSeparator());
        sb.append("	mfhi	$t2		# t2 = a%b");
        sb.append(System.lineSeparator());
        sb.append("	");
        sb.append(System.lineSeparator());
        sb.append("	move	$a0, $t0	# param1 = t0");
        sb.append(System.lineSeparator());
        sb.append("	move	$a1, $t2	# param2 = t2");
        sb.append(System.lineSeparator());
        sb.append("	jal	gcd		# gcd(t0, t2)	");
        sb.append(System.lineSeparator());
        sb.append("	move	$t0, $v0	# guardar valor de retorno");
        sb.append(System.lineSeparator());
        sb.append("	");
        sb.append(System.lineSeparator());
        sb.append("	move	$v0, $t0	# return stmt");
        sb.append(System.lineSeparator());
        sb.append("	j	gcd_end	");
        sb.append(System.lineSeparator());
        sb.append("	");
        sb.append(System.lineSeparator());
        sb.append("	j	gcd_lbl3	# salir del if");
        sb.append(System.lineSeparator());
        sb.append("	");
        sb.append(System.lineSeparator());
        sb.append("gcd_lbl2: # true block");
        sb.append(System.lineSeparator());
        sb.append("	move	$t0, $a0	# return statement, copy value to return");
        sb.append(System.lineSeparator());
        sb.append("	");
        sb.append(System.lineSeparator());
        sb.append("	move	$v0, $t0	# return stmt");
        sb.append(System.lineSeparator());
        sb.append("	j	gcd_end");
        sb.append(System.lineSeparator());
        sb.append("	");
        sb.append(System.lineSeparator());
        sb.append("gcd_lbl3: # end if");
        sb.append(System.lineSeparator());
        return sb.toString();
    }
}
