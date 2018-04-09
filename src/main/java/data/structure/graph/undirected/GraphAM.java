package data.structure.graph.undirected;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;


public class GraphAM<V> {
	
	private Map<V, Integer> vertices;
	private List<V> verticesLookup;
	
	
	private int[][] adj;
	
	private int index;
	
	public GraphAM(int numVertices) {
		adj = new int[numVertices][numVertices];
		index = 0;
		vertices = new HashMap<>();
		verticesLookup = new ArrayList<>();
	}
	
	public void addEdge(V from, V to) {
		addVertex(from);
		addVertex(to);
		
		int fromIndex = vertices.get(from);
		int toIndex = vertices.get(to);
		adj[fromIndex][toIndex] = 1;
	}

	private void addVertex(V v) {
		if(!vertices.containsKey(v)) {
			vertices.put(v, index);
			verticesLookup.add(index, v);
			index++;
		}
	}
	
	public void traverseInBfs(V start) {
		Queue<V> queue = new LinkedList<>();
		boolean[] visited = new boolean[vertices.size()]; 
		
		queue.add(start);
		int index = vertices.get(start);
		visited[index] = true;
		
		while(!queue.isEmpty()) {
			V v = queue.poll();
			System.out.print(v + " ");
			
			List<V> adjacentVertices = getAdjacentVertices(v);
			for(V a : adjacentVertices) {
				int adjInd = vertices.get(a);
				if(!visited[adjInd]) {
					queue.add(a);
					visited[adjInd] = true;
				}
			}
			
		}
		
	}
	
	public void traverseInDfs(V start) {
		boolean[] visited = new boolean[vertices.size()];
		dfs(start, visited);
	}

	private void dfs(V v, boolean[] visited) {
		System.out.print(v + " ");
		int index = vertices.get(v);
		visited[index] = true;
		
		List<V> adjacentVertices = getAdjacentVertices(v);
		for(V a : adjacentVertices) {
			int aIndex = vertices.get(a);
			if(!visited[aIndex]) {
				dfs(a, visited);
			}
		}
	}

	private List<V> getAdjacentVertices(V v) {
		int index = vertices.get(v);
		List<V> result = new ArrayList<>();
		for(int i=0; i<adj[index].length; i++) {
			if(adj[index][i] == 1) {
				result.add(verticesLookup.get(i));
			}
		}
		return result;
	}
	
}
