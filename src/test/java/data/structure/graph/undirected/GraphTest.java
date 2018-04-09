package data.structure.graph.undirected;

import org.junit.Test;

public class GraphTest {
	
	@Test
	public void testBfs() {
		System.out.println("*********************** Graph using Adjacency List ********************");

		GraphAL<Integer> graphAL = new GraphAL<>(6);

		graphAL.addEdge(0, 2);
		graphAL.addEdge(2, 1);
		graphAL.addEdge(2, 3);
		graphAL.addEdge(3, 4);
		graphAL.addEdge(3, 5);

		System.out.println("Following is Breadth First Traversal "+
				"(starting from vertex 2 to 0)");

		BreadthFirstPaths<Integer> bfs = new BreadthFirstPaths<Integer>(graphAL, 2);
		for(Integer i : bfs.pathTo(0)) {
			System.out.print(i + " ");
		}
		System.out.println();
	}

	
	
	@Test
	public void testDfs() {
		GraphAL<Integer> graphAL = new GraphAL<>(6);

		graphAL.addEdge(0, 2);
		graphAL.addEdge(2, 1);
		graphAL.addEdge(2, 3);
		graphAL.addEdge(3, 4);
		graphAL.addEdge(3, 5);
		
		System.out.println("\nFollowing is Depth First Traversal "+
				"(starting from vertex 5 to 0)");

		DepthFirstPaths<Integer> dfs = new DepthFirstPaths<Integer>(graphAL, 5);
		for(Integer i : dfs.pathTo(0)) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
	
	@Test
	public void testCycleDetection() {
		GraphAL<Integer> graphAL = new GraphAL<>(4);
		graphAL.addEdge(1, 2);
		graphAL.addEdge(2, 3);
		graphAL.addEdge(3, 4);
		graphAL.addEdge(1, 4);
		
		CycleDetection<Integer> cycleDetection = new CycleDetection<>(graphAL);
		System.out.println(cycleDetection.hasCycle());
		
		graphAL.removeEdge(1, 4);
		cycleDetection = new CycleDetection<>(graphAL);
		System.out.println(cycleDetection.hasCycle());
	}
	
	@Test
	public void testBfsGraphAM() {
		System.out.println("*********************** Graph using Adjacency Matrix ********************");

		GraphAM<Integer> graphAm = new GraphAM<>(4);

		graphAm.addEdge(0, 1);
		graphAm.addEdge(0, 2);
		graphAm.addEdge(1, 2);
		graphAm.addEdge(2, 0);
		graphAm.addEdge(2, 3);
		graphAm.addEdge(3, 3);

		System.out.println("Following is Breadth First Traversal "+
				"(starting from vertex 2)");

		graphAm.traverseInBfs(2);
	}
	
	@Test
	public void testDfsGraphAM() {
		System.out.println("\nFollowing is Depth First Traversal "+
				"(starting from vertex 2)");

		GraphAM<Integer> graphAm = new GraphAM<>(4);

		graphAm.addEdge(0, 1);
		graphAm.addEdge(0, 2);
		graphAm.addEdge(1, 2);
		graphAm.addEdge(2, 0);
		graphAm.addEdge(2, 3);
		graphAm.addEdge(3, 3);

		graphAm.traverseInDfs(2);
		System.out.println();
	}
	
	@Test
	public void testPrimsMST() {
		System.out.println("**************** Undirected Weighted Graph - Prim's MST **************************");

		EdgeWeightedGraph<Integer> ewGraph = new EdgeWeightedGraph<>(5);
		ewGraph.addEdge(new Edge<Integer>(0, 1, 2));
		ewGraph.addEdge(new Edge<Integer>(0, 3, 6));
		ewGraph.addEdge(new Edge<Integer>(1, 2, 3));
		ewGraph.addEdge(new Edge<Integer>(1, 3, 8));
		ewGraph.addEdge(new Edge<Integer>(1, 4, 5));
		ewGraph.addEdge(new Edge<Integer>(2, 4, 7));
		ewGraph.addEdge(new Edge<Integer>(3, 4, 9));
		
		LazyPrimMST<Integer> primMST = new LazyPrimMST<>();
		Iterable<Edge<Integer>> mst = primMST.buildMst(ewGraph, 0);
		
		for(Edge<Integer> e : mst) {
			System.out.println(e);
		}
	}

	@Test
	public void testUnionFind() {
		System.out.println("*************** Union Find *********************");
		
		UnionFind<Integer> uf = new UnionFind<>();
		uf.union(0, 1);
		uf.union(1, 2);
		uf.union(2, 3);
		
		System.out.println("Is 0 and 3 connected? - " + uf.find(0, 3));
		
		uf.union(5, 6);
		uf.union(8, 9);
		uf.union(4, 5);
		uf.union(9, 4);
		
		System.out.println("Is 4 and 9 connected? - " + uf.find(4, 9));
		System.out.println("Is 8 and 4 connected? - " + uf.find(8, 4));
		System.out.println("Is 9 and 0 connected? - " + uf.find(0, 9));
		
		uf.union(1, 4);
		System.out.println("Is 9 and 0 connected? - " + uf.find(0, 9));
	}
	
	@Test
	public void testKruskalMST() {
		EdgeWeightedGraph<Integer> ewGraph = new EdgeWeightedGraph<>(5);
		ewGraph.addEdge(new Edge<Integer>(0, 1, 2));
		ewGraph.addEdge(new Edge<Integer>(0, 3, 6));
		ewGraph.addEdge(new Edge<Integer>(1, 2, 3));
		ewGraph.addEdge(new Edge<Integer>(1, 3, 8));
		ewGraph.addEdge(new Edge<Integer>(1, 4, 5));
		ewGraph.addEdge(new Edge<Integer>(2, 4, 7));
		ewGraph.addEdge(new Edge<Integer>(3, 4, 9));
		
		System.out.println("**************** Undirected Weighted Graph - Kruskal's MST **************************");

		KruskalMST<Integer> kruskalMST = new KruskalMST<>();
		Iterable<Edge<Integer>> mst = kruskalMST.buildMst(ewGraph);
		
		for(Edge<Integer> e : mst) {
			System.out.println(e);
		}
	}
	
}
