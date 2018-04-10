package data.structure.graph.directed;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import data.structure.queue.Stack;

/**
 * Cycle detection algorithm on a directed graph is done using the DFS path traversal
 * and tracking the recursive stack. 
 * <p>
 * <b>Theory</b> - While doing DFS, If we ever find a directed edge {@code v->w} to a vertex
 * {@code w} that is on that stack, we have found a cycle, since the stack is evidence of a directed
 * path from {@code w} to <code>v</code>, and the edge <code>v->w</code> completes the cycle.
 * 
 * 
 * @author santhosh
 * 
 * @param T - type of vertices
 *
 */
public class DirectedCycleDetection<T> {
	
	private Set<T> marked;
	
	private Set<T> recursiveStack;
	
	private Map<T, T> edgeTo;
	
	private Stack<T> cycle;
	
	public DirectedCycleDetection(Digraph<T> digraph) {
		marked = new HashSet<>();
		recursiveStack = new HashSet<>();
		edgeTo = new HashMap<>();
		
		for(T v : digraph.getVertices()) {
			if(!marked.contains(v)) {
				dfs(digraph, v);
			}
		}
	}
	
	private void dfs(Digraph<T> digraph, T v) {
		recursiveStack.add(v); // add a vertex to the recursive stack, before beginning the dfs on that
		marked.add(v); //mark the dfs searched vertex
		for(T w : digraph.adjacent(v)) {
			if(this.hasCycle()) {
				return;
			} else if(!marked.contains(w)) {
				edgeTo.put(w, v);
				dfs(digraph, w);
			} else if(recursiveStack.contains(w)) { //if for a vertex v, there is an adjacent vertex w, which is on recursive stack 
				this.cycle = new Stack<>(); // (already visited and whose dfs search is still going on), then there is cycle.
				for(T x = v; x != w; x = edgeTo.get(x)) {
					this.cycle.push(x);
				}
				this.cycle.push(w);
				this.cycle.push(v);
			}
		}
		recursiveStack.remove(v);
	}

	public boolean hasCycle() {
		return this.cycle != null;
	}
	
	public Stack<T> getCycle() {
		return cycle;
	}

}
