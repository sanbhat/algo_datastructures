package data.structure.graph;

import java.util.HashMap;
import java.util.Map;

import data.structure.heap.IndexMinHeap;
import data.structure.queue.Stack;

/**
 * <b>Dijkstra's SP</b> algorithm is one of the most efficient Shortest path algorithms with the complexity of 
 * <code>O (E log V)</code>, with the usage of {@link IndexMinHeap} data structure.
 * <p>
 * <li>The algorithm starts from <code>source</code> and calculates the distance to each of its adjacent vertices.
 * <li>Next it considers the vertex adjacent to source, which has the minimum distance (weight).
 * <li>Likewise, it will keep updating the distance from <code>source</code> to other vertices, as and when it finds
 * a path with lesser weight than, what has been already recorded (path relaxation)
 * <li>The result of this operation is a map, which will have the total distance of all the path leading from source 
 * to other vertices, which is the minimum.
 * 
 * @author santhosh
 *
 * @param <T> - Type of vertex
 */
public class DijkstraSP<T> {
	
	private Map<T, DirectedEdge<T>> edgeTo;
	
	private Map<T, Integer> distTo;
	
	private IndexMinHeap<T, Integer> indexMinPq;
	
	public DijkstraSP() {
		
	}
	
	public void findShortestPath(EdgeWeightedDigraph<T> graph, T source) {
		edgeTo = new HashMap<>();
		distTo = new HashMap<>();
		indexMinPq = new IndexMinHeap<>(graph.getV());
		
		for(T vertex : graph.vertices()) {
			distTo.put(vertex, Integer.MAX_VALUE); 
		}
		distTo.put(source, 0);
		indexMinPq.insert(source, 0);
		while(!indexMinPq.isEmpty()) {
			T nextVertex = indexMinPq.delMin();
			relax(nextVertex, graph);
		}
	}

	private void relax(T from, EdgeWeightedDigraph<T> graph) {
		if(graph.adjacent(from) != null) {
			for(DirectedEdge<T> e : graph.adjacent(from)) {
				T to = e.to();
				int updatedWeight = distTo.get(from) + e.weight();
				if(distTo.get(to) > updatedWeight) {

					distTo.put(to, updatedWeight);
					edgeTo.put(to, e);

					if(indexMinPq.containsIndex(to)) {
						indexMinPq.change(to, updatedWeight);
					} else {
						indexMinPq.insert(to, updatedWeight);
					}
				}
			}
		}
	}
	
	public boolean hasPath(T to) {
		return distTo.get(to) != Integer.MAX_VALUE;
	}
	
	public int distanceTo(T to) {
		return distTo.get(to);
	}
	
	public Stack<DirectedEdge<T>> pathTo(T to) {
		Stack<DirectedEdge<T>> path = null;
		if(hasPath(to)) {
			path = new Stack<>();
			for(DirectedEdge<T> e = edgeTo.get(to); e != null; e = edgeTo.get(e.from())) {
				path.push(e);
			}
		}
		return path;
	}

}
