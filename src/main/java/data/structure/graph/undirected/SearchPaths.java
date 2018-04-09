package data.structure.graph.undirected;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import data.structure.queue.Stack;

public abstract class SearchPaths<T> {

	protected Set<T> marked;
	
	protected Map<T, T> edgeTo;
	
	protected final T s;
	
	public SearchPaths(T start) {
		this.s = start;
		marked = new HashSet<>();
		edgeTo = new HashMap<>();
	}
	
	public boolean hasPath(T w) {
		return marked.contains(w);
	}
	
	public Iterable<T> pathTo(T w) {
		Stack<T> stack = new Stack<>();
		for(T x = w; x != s; x = edgeTo.get(x)) {
			stack.push(x);
		}
		stack.push(s);
		return stack;
	}
	
}
