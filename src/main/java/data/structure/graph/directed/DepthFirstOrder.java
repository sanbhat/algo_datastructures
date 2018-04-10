package data.structure.graph.directed;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

import data.structure.queue.Stack;

/**
 * Depth first order class demonstrates the different order in which we can visit all the
 * vertices of a graph, while traversing in DFS fashion. These orders are
 * <ul>
 * 	<li>Pre</li> - Add the current vertex to the {@link Queue} at the beginning of dfs - Records original DFS order
 * 	<li>Post</li> - Add the current vertex to the {@link Queue} at the end of dfs  - Records reverse level traversal from leaf to root
 *  <li>Reverse Post</li> - Add the current vertex to the {@link Stack} at the end of dfs - Records Topological order (NOT same as Pre)
 * </ul>
 * @author santhosh
 *
 * @param <T> type of vertices
 */
public class DepthFirstOrder<T> {
	
	private Queue<T> pre;
	
	private Queue<T> post;
	
	private Stack<T> reversePost;
	
	private Set<T> marked;
	
	public DepthFirstOrder(Digraph<T> digraph) {
		pre = new LinkedList<>();
		post = new LinkedList<>();
		reversePost = new Stack<>();
		marked = new HashSet<>();
		for(T v : digraph.getVertices()) {
			if(!marked.contains(v)) {
				dfs(digraph, v);
			}
		}
	}

	private void dfs(Digraph<T> digraph, T v) {
		pre.add(v);
		marked.add(v);
		for(T w : digraph.adjacent(v)) {
			if(!marked.contains(w)) {
				dfs(digraph, w);
			}
		}
		post.add(v);
		reversePost.push(v);
	}
	
	public Iterable<T> pre() {
		return pre;
	}
	
	public Iterable<T> post() {
		return post;
	}
	
	public Iterable<T> reversePost() {
		return reversePost;
	}

}
