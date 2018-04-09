package data.structure.graph.undirected;

import java.util.HashSet;
import java.util.Set;

/**
 * Checks whether a graph is cyclic (has cycle) or acyclic. This is done with the help of DFS and tracking the parent of the lasted visited
 * node. 
 * <p>
 * <b>Theory</b> - If all the adjacent vertex (w) of a particular vertex (v) is visited (marked), then it should be equal to the parent (from which 
 * the vertex got searched using dfs). Else, there is a <b>Cycle</b>
 * 
 * @author santhosh
 * 
 * @param T - type of vertex
 *
 */
public class CycleDetection<T> {

	private Set<T> marked;
	
	private boolean hasCycle;
	
	public CycleDetection(GraphAL<T> graph) {
		this.marked = new HashSet<>();
		for(T s : graph.getVertices()) {
			if(!marked.contains(s))
				dfs(graph, s, s);
		}
	}

	private void dfs(GraphAL<T> graph, T v, T parent) {
		marked.add(v);
		for(T adjacentVertex : graph.adjacent(v)) {
			if(!marked.contains(adjacentVertex)) {
				dfs(graph, adjacentVertex, v);
			} else if(!adjacentVertex.equals(parent)) {
				this.hasCycle = true;
			}
		}
	}
	
	public boolean hasCycle() {
		return this.hasCycle;
	}
}
