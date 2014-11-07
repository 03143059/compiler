package irt;

import java.io.PrintStream;

/**
 * Created by Werner on 10/21/2014.
 */
public class ForList extends IrtList {
    private final String varName;
    private final IrtNode until;
    private final IrtNode block;

    public ForList(IrtNode start, IrtNode end, String varName, IrtNode until, IrtNode block) {
        super("For", start, end);
        this.varName = varName;
        this.until = until;
        this.block = block;
    }

    @Override
    public void print(PrintStream out){
        out.println("use variable " + varName);
        start.print(out);
        until.print(out);
        block.print(out);
    }

    @Override
    public String getAssembler() {
        StringBuilder sb = new StringBuilder();
        sb.append("	li	$t0, 0		# t = 0");
        sb.append(System.lineSeparator());
        sb.append("test_for1:");
        sb.append(System.lineSeparator());
        sb.append("	bgt	$t0, 2, test_next1");
        sb.append(System.lineSeparator());
        sb.append("	sw	$t0, var_i	# i = t");
        sb.append(System.lineSeparator());
        sb.append("	");
        sb.append(System.lineSeparator());
        sb.append("	mul	$t1, $t0, $t0	# t = i*i");
        sb.append(System.lineSeparator());
        sb.append("	");
        sb.append(System.lineSeparator());
        sb.append("	lw	$t2, var_i	# load i, se usa t2 porque t0 y t1 ya estan utilizados");
        sb.append(System.lineSeparator());
        sb.append("	");
        sb.append(System.lineSeparator());
        sb.append("	sw	$t1, var_c($t2)	# c[i] = t");
        sb.append(System.lineSeparator());
        sb.append("	");
        sb.append(System.lineSeparator());
        sb.append("	addi	$t0, $t0, 1		# i++");
        sb.append(System.lineSeparator());
        sb.append("	j	test_for1");
        sb.append(System.lineSeparator());
        sb.append("test_next1:");
        sb.append(System.lineSeparator());
        return sb.toString();
    }
}
