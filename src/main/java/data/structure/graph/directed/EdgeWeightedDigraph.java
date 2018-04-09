package data.structure.graph.directed;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

/**
 * An <b>EdgeWeightedDigraph</b> is a graph consisting of Directed edges which have
 * weight associated with them.
 * 
 * @author santhosh
 *
 * @param <T> type of vertex
 */
public class EdgeWeightedDigraph<T> {

	private final int  v;
	
	private int e;
	
	private Map<T, Set<DirectedEdge<T>>> adj;
	
	private Set<T> vertices;
	
	public EdgeWeightedDigraph(int v) {
		this.v = v;
		this.e = 0;
		this.adj = new HashMap<>();
		this.vertices = new HashSet<>();
	}
	
	public void addEdge(DirectedEdge<T> directedEdge) {
		vertices.add(directedEdge.from());
		vertices.add(directedEdge.to());
		
		if(!adj.containsKey(directedEdge.from())) {
			adj.put(directedEdge.from(), new LinkedHashSet<>());
		}
		adj.get(directedEdge.from()).add(directedEdge);
		this.e ++;
	}
	
	public int getV() {
		return this.v;
	}
	
	public int getE() {
		return this.e;
	}
	
	public Iterable<DirectedEdge<T>> adjacent(T v) {
		return adj.get(v);
	}
	
	public Iterable<DirectedEdge<T>> edges() {
		Set<DirectedEdge<T>> allEdges = new LinkedHashSet<>();
		for(Set<DirectedEdge<T>> edges : adj.values()) {
			allEdges.addAll(edges);
		}
		return allEdges;
	}
	
	public Iterable<T> vertices() {
		return new HashSet<>(this.vertices);
	}
	
}
