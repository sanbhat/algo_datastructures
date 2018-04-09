package data.structure.graph.undirected;

import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstPaths<T> extends SearchPaths<T> {
	
	public BreadthFirstPaths(GraphAL<T> graph, T start) {
		super(start);
		bfs(graph, s);
	}

	private void bfs(GraphAL<T> graph, T start) {
		Queue<T> queue = new LinkedList<>();
		queue.add(start);
		marked.add(start);
		
		while(!queue.isEmpty()) {
			T v = queue.poll();
			for(T w : graph.adjacent(v)) {
				if(!marked.contains(w)) {
					marked.add(w);
					edgeTo.put(w, v);
					queue.add(w);
				}
			}
		}
	}
	
}
