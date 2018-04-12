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
		TopologicalSort<Integer> ts = new TopologicalSort<>(digraph);
		System.out.println("Topological - " + ts.order());
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
	public void testTopologicalSort() {
		Digraph<String> digraph = new Digraph<>(12);
		
		digraph.addEdge("Algo", "TCS");
		digraph.addEdge("Algo", "DB");
		digraph.addEdge("Algo", "Sci Comp");
		
		digraph.addEdge("Intro to CS", "AP");
		digraph.addEdge("Intro to CS", "Algo");
		
		digraph.addEdge("AP", "Sci Comp");
		
		digraph.addEdge("Sci Comp", "CB");
		
		digraph.addEdge("TCS", "CB");
		digraph.addEdge("TCS", "AI");
		
		digraph.addEdge("LA", "TCS");
		
		digraph.addEdge("Calculus", "LA");
		
		digraph.addEdge("AI", "NN");
		digraph.addEdge("AI", "Robotics");
		digraph.addEdge("AI", "ML");
		
		digraph.addEdge("ML", "NN");
		
		TopologicalSort<String> ts = new TopologicalSort<>(digraph);
		System.out.println(ts.order());
	}
	
	@Test
	public void testKosarajuSCC() {
		Digraph<Integer> digraph = new Digraph<>(13);
		digraph.addEdge(4, 2);
		digraph.addEdge(2, 3);
		digraph.addEdge(3, 2);
		digraph.addEdge(6, 0);
		digraph.addEdge(0, 1);
		digraph.addEdge(2,0);
		digraph.addEdge(11, 12);
		digraph.addEdge(12, 9);
		digraph.addEdge(9, 10);
		digraph.addEdge(9, 11);
		digraph.addEdge(8, 9);
		digraph.addEdge(10, 12);
		digraph.addEdge(11, 4);
		digraph.addEdge(4, 3);
		digraph.addEdge(3, 5);
		digraph.addEdge(7, 8);
		digraph.addEdge(8, 7);
		digraph.addEdge(5, 4);
		digraph.addEdge(0, 5);
		digraph.addEdge(6, 4);
		digraph.addEdge(6, 9);
		digraph.addEdge(7, 6);
		
		KosarajuSCC<Integer> kosarajuScc = new KosarajuSCC<>(digraph);
		for(int i=0; i< kosarajuScc.count(); i++) {
			System.out.println("SCC - "+ (i+1));
			System.out.println(kosarajuScc.reverseId().get(i));
		}
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
