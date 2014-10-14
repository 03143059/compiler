package ast;

import java.io.PrintStream;
import java.util.List;
import java.util.LinkedList;

public class NodeList extends Node{
    private List<Node> list;
    PrintStream out;

    public int size() {
        return (list == null)? 0 : list.size();
    }

	public NodeList(){
        list = new LinkedList<Node>();
	}
	
	public void add(Node node){
		list.add(node);
	}
	
	public void print(String padding, PrintStream out){
        this.out = out;
		for(Node n : list){
			n.print(padding + "  ", out);
		}
	}
	
	public void print(){
		print("", out);
	}
} 
 
 
