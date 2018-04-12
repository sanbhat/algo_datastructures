package data.structure.graph.directed;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Kosaraju's algorithm finds the SCC in the directed graph in 3 simple steps
 * <ul>
 * 	<li>Create the graph's transpose / reverse - call it <code>GR</code>
 *  <li>Then find the <code>reversePost()</code> of <code>GR</code> using {@link DepthFirstOrder}
 *  <li>Iterate through the <b>reversePost</b> order and do DFS.The vertices discovered through a single DFS call stack belong to a SCC. Continue the DFS to get more SCC's
 * until we process all the vertices in the reverse order 
 * </ul>
 * 
 * @author santhosh
 *
 * @param <T>
 */
public class KosarajuSCC<T> {
	
	private Set<T> marked;
	private Map<T, Integer> id;
	private int count;
	
	
	public KosarajuSCC(Digraph<T> digraph) {
		marked = new HashSet<>();
		id = new HashMap<>();
		
		DepthFirstOrder<T> dfo = new DepthFirstOrder<>(digraph.reverse());
		for(T v : dfo.reversePost()) {
			if(!marked.contains(v)) {
				dfs(digraph, v);
				this.count++;
			}
		}
	}

	private void dfs(Digraph<T> digraph, T v) {
		marked.add(v);
		id.put(v, this.count);
		for(T w : digraph.adjacent(v)) {
			if(!marked.contains(w)) {
				dfs(digraph, w);
			}
		}
	}
	
	public boolean isStronglyConnected(T v, T w) {
		return id.get(v) != null && id.get(v).equals(id.get(w));
	}
	
	public int getId(T v) {
		return id.get(v);
	}

	public int count() {
		return this.count;
	}
	
	//id --> List of vertices
	public Map<Integer, List<T>> reverseId() {
		return id.entrySet().stream().collect(Collectors.groupingBy(Map.Entry::getValue,
				Collectors.mapping(Map.Entry::getKey, Collectors.toList())));
	}
}
