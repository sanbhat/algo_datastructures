package data.structure.tries;

import data.structure.search.BinarySearchTree;

/**
 * TernarySearchTrie - is a special implementation of Trie, which tries to save space by
 * maintaining only 3 links at each node. The insert/search operations are performed like
 * {@link BinarySearchTree} with similar performance characteristics.
 * 
 * @author santhosh
 *
 * @param <V> type of value
 */
public class TernarySearchTrie<V> {

	private static class Node<V> {
		
		char c;
		
		Node<V> left, middle, right;
		
		V value;
		
	}
	
	private Node<V> root;
	
	public V get(String key) {
		Node<V> x = get(root, key, 0);
		return x != null ? x.value : null;
	}
	
	private Node<V> get(Node<V> x, String key, int d) {
		if(x == null) {
			return null;
		}
		char c = key.charAt(d);
		if(c < x.c) {
			return get(x.left, key, d);
		}
		else if(c > x.c) {
			return get(x.right, key, d);
		}
		else if(d < key.length() - 1) {
			return get(x.middle, key, d+1);
		}
		return x;
	}
	
	public void put(String key, V value) {
		root = put(root, key, value, 0);
	}
	
	private Node<V> put(Node<V> x, String key, V value, int d) {
		char c = key.charAt(d);
		if(x == null) {
			x = new Node<>();
			x.c = c;
		}
		if(c < x.c) {
			x.left = put(x.left, key, value, d);
		} else if(c > x.c) {
			x.right = put(x.right, key, value, d);
		} else if(d < key.length() - 1) {
			x.middle = put(x.middle, key, value, d+1);
		}
		x.value = value;
		return x;
	}
}
