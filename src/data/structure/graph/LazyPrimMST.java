package data.structure.graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

import data.structure.queue.MinHeap;

/**
 * This is a Lazy implementation of Prim's algorithm of finding the <b>Minimum Spanning Tree</b> using <b>Minimum Priority Queue</b>.
 * The algorithm works in the following way </br>
 * <ul>
 * <li> First it starts with a vertex, passed as <code>start</code> argument to the method <code>buildMst(...)</code>
 * <li> The first vetex will be visited, that is, it will be <code>marked</code> as visited
 * <li> All the adjacent vertices of the first vertex will be iterated and if they are not already <b>marked</b> as visited, then, they
 * will be placed to the <code>minHeap</code>.
 * <li> Next <code>Edge</code> with minimum weight will be retrieved from the <code>minHeap</code> until the heap becomes empty and following
 * operations will be performed on each vertices part of that {@link Edge}
 * <ul>
 * <li> Check if both the vertices are <b>marked</b>. If yes, then move on to the next edge in the minHeap.
 * <li> Else, add the edge to the <code>mst</code>
 * <li> Extract both the vertices of the edge, check if they are <b>marked</b>, if not, then visit them.
 * </ul>
 * </ul>
 * 
 * The implementation is called <b>Lazy</b> because, the program doesn't remove ineligible edges from the minHeap. An edge becomes ineligible, if
 * both the vertices it is connecting will be part of the MST, by means of another edge which has lower weight than it.
 * 
 * @author santhosh
 *
 * @param <T>
 */
public class LazyPrimMST<T> {

	private Set<T> marked;
	
	private Queue<Edge<T>> mst;
	
	private MinHeap<Edge<T>> minHeap;
	
	public LazyPrimMST() {
		marked = new HashSet<>();
		mst = new LinkedList<>();
		minHeap = new MinHeap<>();
	}
	
	public Iterable<Edge<T>> buildMst(EdgeWeightedGraph<T> graph, T start) {
		visit(graph, start);
		
		while(!minHeap.isEmpty()) {
			Edge<T> e = minHeap.delMin();
			T v = e.either();
			T w = e.other(v);
			if(marked.contains(v) && marked.contains(w)) {
				continue;
			}
			mst.add(e);
			if(!marked.contains(v)) {
				visit(graph, v);
			}
			if(!marked.contains(w)) {
				visit(graph, w);
			}
		}
		
		return mst;
	}
	
	private void visit(EdgeWeightedGraph<T> graph, T v) {
		marked.add(v);
		for(Edge<T> e : graph.adj(v)) {
			if(!marked.contains(e.other(v))) {
				minHeap.insert(e);
			}
		}
	}
}
