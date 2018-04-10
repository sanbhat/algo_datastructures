package data.structure.graph.directed;

import org.junit.Test;

public class DirectedGraphTest {
	
	/**
	 * 				1
	 * 			   / \
	 * 			  2   6
	 *           / \
	 *          3   5
	 *         /
	 *        4 
	 * 
	 * Pre 							- [1, 2, 3, 4, 5, 6]
	 * Post 						- [4, 3, 5, 2, 6, 1]
     * Reverse Post (Topological) 	- [1, 6, 2, 5, 3, 4]
	 *        
	 */
	@Test
	public void testDepthFirstOder() {
		Digraph<Integer> digraph = new Digraph<>(4);
		digraph.addEdge(1, 2);
		digraph.addEdge(2, 3);
		digraph.addEdge(3, 4);
		digraph.addEdge(2, 5);
		digraph.addEdge(1, 6);
		
		DepthFirstOrder<Integer> dfsOrder = new DepthFirstOrder<>(digraph);
		System.out.println("Pre - "+dfsOrder.pre());
		System.out.println("Post - "+dfsOrder.post());
		System.out.println("Reverse Post - "+dfsOrder.reversePost());
	}

	@Test
	public void testDirectedCycleDetection() {
		Digraph<Integer> digraph = new Digraph<>(4);
		digraph.addEdge(1, 2);
		digraph.addEdge(2, 3);
		digraph.addEdge(1, 4);
		digraph.addEdge(4, 2);
		
		DirectedCycleDetection<Integer> dcd = new DirectedCycleDetection<>(digraph);
		System.out.println(dcd.hasCycle());
		System.out.println(dcd.getCycle());
		
		digraph = new Digraph<>(4);
		digraph.addEdge(1, 2);
		digraph.addEdge(2, 3);
		digraph.addEdge(3, 4);
		digraph.addEdge(4, 1);
		
		dcd = new DirectedCycleDetection<>(digraph);
		System.out.println(dcd.hasCycle());
		System.out.println(dcd.getCycle());
	}
	
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
