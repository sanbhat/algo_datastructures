package data.structure.graph.undirected;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;

/**
 * This is a graph data structure implementation based on Adjacency list methodology. 
 * <p>
 * This is a generic graph (graph which can have any type of vertices), and have no limit on 
 * number of vertices.
 * 
 * @author santhosh
 * 
 * @param <T> - type of vertices
 */
public class GraphAL<T> {

	private final int v;
	private int e;
	private Map<T, LinkedList<T>> adj;
	
	public GraphAL(int v) {
		this.v = v;
		this.e = 0;
		this.adj = new HashMap<>();
	}
	
	public void addEdge(T v, T w) {
		if(!adj.containsKey(v)) {
			adj.put(v, new LinkedList<>());
		} 
		if(!adj.containsKey(w)) {
			adj.put(w, new LinkedList<>());
		}
		adj.get(v).add(w);
		adj.get(w).add(v);
		this.e ++;
	}
	
	public void removeEdge(T v, T w) {
		if(adj.containsKey(v) && adj.get(v).contains(w))
			adj.get(v).remove(w);
		if(adj.containsKey(w) && adj.get(w).contains(v))
			adj.get(w).remove(v);
		this.e--;
	}
	
	public Iterable<T> adjacent(T v) {
		return adj.get(v);
	}
	
	public int getV() {
		return v;
	}
	
	public int getE() {
		return e;
	}
	
	public Iterable<T> getVertices() {
		return new HashSet<>(adj.keySet());
	}
	
}
