package ast;

import java.io.PrintStream;
import java.util.*;
import java.util.function.Consumer;

public class NodeList extends Node implements Iterable<Node>{
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

    public void insert(Node node){
        list.add(0, node);
    }

    public List<Node> getList() { return list; }
	
	public void print(String padding, PrintStream out){
        this.out = out;
		for(Node n : list){
			n.print(padding + "  ", out);
		}
	}
	
	public void print(){
		print("", out);
	}


    @Override
    public Iterator<Node> iterator() {
        return list.iterator();
    }

    @Override
    public void forEach(Consumer<? super Node> action) {
        list.forEach(action);
    }

    @Override
    public Spliterator<Node> spliterator() {
        return list.spliterator();
    }
}
 
 
