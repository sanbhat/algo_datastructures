package data.structure.graph.undirected;

public class DepthFirstPaths<T> extends SearchPaths<T> {
	
	public DepthFirstPaths(GraphAL<T> graph, T start) {
		super(start);
		dfs(graph, s);
	}

	private void dfs(GraphAL<T> graph, T v) {
		marked.add(v);
		for(T w : graph.adjacent(v)) {
			if(!marked.contains(w)) {
				edgeTo.put(w, v);
				dfs(graph, w);
			}
		}
	}
	
}
