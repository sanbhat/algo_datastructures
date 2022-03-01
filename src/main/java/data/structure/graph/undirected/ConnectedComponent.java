package data.structure.graph.undirected;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Connected Component algorithm helps us find the following
 * <li> Whether 2 vertices in a graph are connected or not (and thus belong to same component).
 * <li> Get the number of different components present in the graph.
 * <li> List the vertices belonging to each component.
 * 
 * @author santhosh
 * 
 * @param <T> - Type of vertex
 *
 */
public class ConnectedComponent<T> {

	private Set<T> marked;
	
	private Map<T, Integer> id;
	
	private int count;
	
	public ConnectedComponent(GraphAL<T> graph) {
		marked = new HashSet<>();
		id = new HashMap<>();
		
		for(T v : graph.getVertices()) {
			if(!marked.contains(v)) {
				dfs(graph, v);
				count++;
			}
		}
		
	}

	private void dfs(GraphAL<T> graph, T v) {
		marked.add(v);
		id.put(v, count);
		for(T w : graph.adjacent(v)) {
			if(!marked.contains(w)) {
				dfs(graph, w);
			}
		}
	}
	
	public boolean isConnected(T v, T w) {
		return id.get(v) != null && id.get(w) != null && id.get(v).equals(id.get(w));
	}
	
	public int getId(T v) {
		return id.get(v);
	}
	
	public int count() {
		return count;
	}
}
