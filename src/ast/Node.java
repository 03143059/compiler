package ast;

import lib.CompilerOptions;

import java.io.PrintStream;

public abstract class Node{
	public abstract void print(String padding, PrintStream out);
}
