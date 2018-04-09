package data.structure.graph.directed;

import org.junit.Test;

public class DirectedGraphTest {

	@Test
	public void testDijkstrasSP() {
		System.out.println("************************ Dijkstra's Shortest Path ************************************");
		
		EdgeWeightedDigraph<Integer> directedGraph = new EdgeWeightedDigraph<>(5);
		directedGraph.addEdge(new DirectedEdge<Integer>(0, 1, 3));
		directedGraph.addEdge(new DirectedEdge<Integer>(0, 2, 2));
		directedGraph.addEdge(new DirectedEdge<Integer>(1, 2, 5));
		directedGraph.addEdge(new DirectedEdge<Integer>(1, 3, 3));
		directedGraph.addEdge(new DirectedEdge<Integer>(2, 4, 20));
		directedGraph.addEdge(new DirectedEdge<Integer>(3, 4, 4));
		
		DijkstraSP<Integer> dijkstraSP = new DijkstraSP<>();
		dijkstraSP.findShortestPath(directedGraph, 0);
		System.out.println(dijkstraSP.distanceTo(4));
		System.out.println(dijkstraSP.pathTo(4));
		
	}
}
