package data.structure.graph;

public class GraphTest {
	
	public static void main(String[] args) {

		System.out.println("*********************** Graph using Adjacency List ********************");

		GraphAL<Integer> graphAL = new GraphAL<>();

		graphAL.addEdge(0, 1);
		graphAL.addEdge(0, 2);
		graphAL.addEdge(1, 2);
		graphAL.addEdge(2, 0);
		graphAL.addEdge(2, 3);
		graphAL.addEdge(3, 3);

		System.out.println("Following is Breadth First Traversal "+
				"(starting from vertex 2)");

		graphAL.traverseInBfs(2);

		System.out.println("\nFollowing is Depth First Traversal "+
				"(starting from vertex 2)");

		graphAL = new GraphAL<>();

		graphAL.addEdge(0, 1);
		graphAL.addEdge(0, 2);
		graphAL.addEdge(1, 2);
		graphAL.addEdge(2, 0);
		graphAL.addEdge(2, 3);
		graphAL.addEdge(3, 3);

		graphAL.traverseInDfs(2);
		System.out.println();
		graphAL.traverseInDfsRecursion(2);

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

		System.out.println("\nFollowing is Depth First Traversal "+
				"(starting from vertex 2)");

		graphAm = new GraphAM<>(4);

		graphAm.addEdge(0, 1);
		graphAm.addEdge(0, 2);
		graphAm.addEdge(1, 2);
		graphAm.addEdge(2, 0);
		graphAm.addEdge(2, 3);
		graphAm.addEdge(3, 3);

		graphAm.traverseInDfs(2);
		System.out.println();

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
		
		System.out.println("**************** Undirected Weighted Graph - Kruskal's MST **************************");

		KruskalMST<Integer> kruskalMST = new KruskalMST<>();
		mst = kruskalMST.buildMst(ewGraph);
		
		for(Edge<Integer> e : mst) {
			System.out.println(e);
		}
		
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