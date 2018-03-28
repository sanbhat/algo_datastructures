package data.structure.graph;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * An <b>Edge Weighted Graph</b> is an undirected graph where the connection between the vertices have
 * some kind of <b>weightage</b> associated with them.
 * @author santhosh
 *
 * @param <T> - Type of vertex
 */
public class EdgeWeightedGraph<T> {
	
	private final int v;
	private int e;
	private Map<T, Set<Edge<T>>> adj;	
	
	public EdgeWeightedGraph(int v) {
		this.v = v;
		this.e = 0;
		this.adj = new HashMap<>();
	}
	
	public int getV() {
		return this.v;
	}
	
	public int getE() {
		return this.e;
	}
	
	public void addEdge(Edge<T> edge) {
		T v = edge.either();
		T w = edge.other(v);
		
		if(!adj.containsKey(v)) {
			adj.put(v, new HashSet<>());
		}
		adj.get(v).add(edge);
		
		if(!adj.containsKey(w)) {
			adj.put(w, new HashSet<>());
		}
		adj.get(w).add(edge);
		e++;
	}
	
	public Iterable<Edge<T>> adj(T v) {
		return adj.get(v);
	}
	
	public Collection<Edge<T>> edges() {
		Set<Edge<T>> allEdges = new HashSet<>();
		for(Set<Edge<T>> set : adj.values()) {
			allEdges.addAll(set);
		}
		return allEdges;
	}
}
