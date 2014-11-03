package ast;

import java.io.PrintStream;
import java.util.*;
import java.util.function.Consumer;

public class NodeList<T> extends Node implements Iterable<T>{
    private List<T> list;
    PrintStream out;

    public int size() {
        return (list == null)? 0 : list.size();
    }

	public NodeList(){
        list = new LinkedList<T>();
	}
	
	public void add(T node){
		list.add(node);
	}

    public void insert(T node){
        list.add(0, node);
    }

    public List<T> getList() { return list; }
	
	public void print(String padding, PrintStream out){
        this.out = out;
		for(T n : list){
            ((Node)n).print(padding + "  ", out);
		}
	}
	
	public void print(){
		print("", out);
	}


    @Override
    public Iterator<T> iterator() {
        return list.iterator();
    }

    @Override
    public void forEach(Consumer<? super T> action) {
        list.forEach(action);
    }

    @Override
    public Spliterator<T> spliterator() {
        return list.spliterator();
    }
}
 
 
