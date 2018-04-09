package data.structure.graph.undirected;

import java.util.LinkedList;
import java.util.Queue;

import data.structure.heap.MinHeap;

/**
 * <b>Kruskal's MST</b> algorithm is, one of the simplest graph MST algorithms to understand and implement, 
 * If right data structures are used ( {@link UnionFind} ).
 * <p>
 * The algorithm first uses {@link MinHeap} to arrange all the edges of the graph in the ascending order of their weight. Then it takes
 * one edge at a time and adds it to the MST, provided the new egde doesn't form a cycle with previously added edges to MST.
 * 
 * @author santhosh
 *
 * @param <T> - Type of vertices
 */
public class KruskalMST<T> {

	private Queue<Edge<T>> mst;
	
	private MinHeap<Edge<T>> minPq;
	
	private UnionFind<T> uf;
	
	public KruskalMST() {
	}
	
	public Iterable<Edge<T>> buildMst(EdgeWeightedGraph<T> graph) {
		minPq = new MinHeap<>(graph.edges());
		mst = new LinkedList<>();
		uf = new UnionFind<>();
		
		while(!minPq.isEmpty() && mst.size() < graph.getV() -1) {
			Edge<T> e = minPq.delMin();
			T v = e.either();
			T w = e.other(v);
			if(!uf.find(v, w)) {
				mst.add(e);
				uf.union(v, w);
			}
		}
		
		return mst;
	}
	

	
	
}
