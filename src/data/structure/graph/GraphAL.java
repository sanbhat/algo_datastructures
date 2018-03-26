package data.structure.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import data.structure.queue.Stack;

/**
 * This is a graph data structure implementation based on Adjacency list methodology. 
 * <p>
 * This is a generic graph (graph which can have any type of vertices), and have no limit on 
 * number of vertices.
 * 
 * @author santhosh
 *
 */
public class GraphAL<T> {

	
	private Map<T, LinkedList<T>> adj;
	
	public GraphAL() {
		adj = new HashMap<>();
	}
	
	public void addEdge(T from, T to) {
		if(!adj.containsKey(from)) {
			adj.put(from, new LinkedList<>());
		} 
		adj.get(from).add(to);
	}
	
	public void traverseInBfs(T start) {
		Set<T> visited = new HashSet<>(); 
		
		Queue<T> queue = new LinkedList<>();
		
		visited.add(start);
		queue.add(start);
		
		while(!queue.isEmpty()) {
			T v = queue.poll();
			System.out.print(v + " ");
			
			LinkedList<T> connectedVertices = adj.get(v);
			if(connectedVertices != null) {
				for(T c : connectedVertices) {
					if(!visited.contains(c)) {
						visited.add(c);
						queue.add(c);
					}
				}
			}
		}
	}
	
	public void traverseInDfs(T start) {
		
		Set<T> visited = new HashSet<>();
		
		//Stack from our example!
		Stack<T> stack = new Stack<>();
		
		stack.push(start);
		visited.add(start);
		
		while(stack.size() != 0) {
			T v = stack.pop();
			System.out.print(v + " ");
			
			LinkedList<T> connectedVertices = adj.get(v);
			if(connectedVertices != null) {
				for(T c : connectedVertices) {
					if(!visited.contains(c)) {
						visited.add(c);
						stack.push(c);
					}
				}
			}
			
		}
	}
	
	public void traverseInDfsRecursion(T start) {
		Set<T> visited = new HashSet<>();
		dfs(start, visited);
	}
	
	private void dfs(T vertice, Set<T> visited) {
		if(!visited.contains(vertice)) {
			System.out.print(vertice + " ");
			visited.add(vertice);
		
			LinkedList<T> adjacentVertices = adj.get(vertice);
			for(T v : adjacentVertices) {
				dfs(v, visited);
			}
		}
	}
	
}
