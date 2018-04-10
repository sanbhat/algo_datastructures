package data.structure.graph.directed;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import data.structure.graph.undirected.GraphAL;
 
/**
 * Structure which represents the directed graph. The only difference between the undirected graph 
 * {@link GraphAL} and this class is that, in undirected graph, when we connected two vertices, we were
 * adding edges to each vertex from other vertex.
 * 
 * @author santhosh
 *
 * @param <T> type of vertices
 */
public class Digraph<T> {

	private final int v;
	
	private int e;
	
	private Map<T, List<T>> adj;
	
	private Set<T> vertices;
	
	public Digraph(int v) {
		this.v = v;
		adj = new HashMap<>();
		vertices = new HashSet<>();
	}
	
	public void addEdge(T v, T w) {
		if(!adj.containsKey(v)) {
			adj.put(v, new LinkedList<>());
		}
		adj.get(v).add(w);
		vertices.add(v);
		vertices.add(w);
		e++;
	}
	
	public Iterable<T> adjacent(T v) {
		List<T> adjacnetNodes = adj.get(v);
		if(adjacnetNodes == null) {
			adjacnetNodes = new LinkedList<>();
		}
		return adjacnetNodes;
	}
	
	public Iterable<T> getVertices() {
		return this.vertices;
	}
	
	public int getE() {
		return e;
	}
	
	public int getV() {
		return v;
	}
}
