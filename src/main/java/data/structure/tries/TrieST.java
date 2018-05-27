package data.structure.tries;

import java.util.LinkedList;
import java.util.Queue;

/**
 * R-way <b>trie</b> based implementation of symbol table, where the key is concrete
 * String type and value can be generic. 
 * 
 * @author santhosh
 *
 * @param <V> - Type of value
 *
 */
public class TrieST<V> {
	
	//Max number of characters we will consider - radix
	private static final int R = 256;
	
	private static class Node {
		
		private Object value;
		
		private Node[] next = new Node[R];
		
	}
	
	private Node root;
	
	/**
	 * Gets the value mapped to the String key from Trie.
	 * @param key - The key
	 * @return value associated with the key
	 */
	@SuppressWarnings("unchecked")
	public V get(String key) {
		Node x = get(root, key, 0);
		return x != null? (V) x.value : null;
	}
	
	private Node get(Node x, String key, int d) {
		if(x == null) {
			return null;
		}
		if(d == key.length()) {
			return x;
		}
		char c = key.charAt(d);
		return get(x.next[c], key, d+1);
	}

	/**
	 * Inserts a key, value pair into the Trie ST
	 * @param key - String key
	 * @param value - value associated with the key
	 */
	public void put(String key, V value) {
		root = put(root, key, value, 0);
	}

	private Node put(Node x, String key, V value, int d) {
		if(x == null) {
			x = new Node();
		}
		if(d == key.length()) {
			x.value = value;
			return x;
		}
		char c = key.charAt(d);
		x.next[c] = put(x.next[c], key, value, d+1);
		return x;
	}
	
	/**
	 * Returns all the keys present in the ST. Equivalent of calling <code>keysWithPrefix("")</code>
	 * 
	 * @return all the keys
	 * 
	 */
	public Iterable<String> keys() {
		return keysWithPrefix("");
	}
	
	/**
	 * Returns all the keys, which starts with the <code>prefix</code>.
	 * @param prefix - The prefix string
	 * @return all the keys starting with the prefix
	 */
	public Iterable<String> keysWithPrefix(String prefix) {
		Queue<String> q = new LinkedList<>();
		collect(get(root, prefix, 0), prefix, q);
		return q;
	}
	
	/**
	 * Method starts with the {@link Node} representing the prefix and it tries to find out all
	 * the {@link Node} which has value associated with them into the {@link Queue}, along the path.
	 */
	private void collect(Node x, String prefix, Queue<String> q) {
		if(x == null) {
			return;
		}
		if(x.value != null) {
			q.add(prefix);
		}
		for(char c = 0; c < R; c++) {
			collect(x.next[c], prefix + c, q);
		}
	}

	/**
	 * Returns all the keys which match the passed pattern, having <code>'.'</code> character as
	 * wildcard. For example <code>'s.a'</code> pattern will match <code>'sea' and 'sia'</code>
	 * @param pattern - the pattern string
	 * @return all the keys matching the pattern
	 */
	public Iterable<String> keysThatMatch(String pattern) {
		Queue<String> q = new LinkedList<>();
		collect(root, "", pattern, q);
		return q;
	}

	private void collect(Node x, String prefix, String pattern, Queue<String> q) {
		int d = prefix.length();
		if(x == null) {
			return;
		}
		if(d == pattern.length() && x.value != null) {
			q.add(prefix);
		}
		if(d == pattern.length()) {
			return;
		}
		
		char next = pattern.charAt(d);
		for(char c = 0; c<R; c++) {
			if(next == '.' || next == c) {
				collect(x.next[c], prefix+c, pattern, q);
			}
		}
		
	}
	
	/**
	 * Returns the longest key, which is the prefix of the passed string parameter
	 * @param s - string parameter, for which the longest key prefix to be checked
	 * @return longest key prefix, if one exists.
	 */
	public String longestPrefixKeyOf(String s) {
		int length = search(root, s, 0, 0);
		return s.substring(0, length);
	}

	private int search(Node x, String s, int d, int length) {
		if(x == null) {
			return length;
		}
		if(x.value != null) {
			length = d;
		}
		if(d == s.length()) {
			return length;
		}
		char c = s.charAt(d);
		return search(x.next[c], s, d+1, length);
	}
	
	/**
	 * Deletes a particular key (if it exists) in the Trie
	 * @param key - key to be deleted.
	 */
	public void delete(String key) {
		root = delete(root, key, 0);
	}

	private Node delete(Node x, String key, int d) {
		if(x == null) {
			return null;
		}
		if(d == key.length()) {
			x.value = null;
		} else {
			char c = key.charAt(d);
			x.next[c] = delete(x.next[c], key, d+1);
		}
		
		if(x.value != null) {
			return x;
		}
		for(char c=0; c<R; c++) {
			if(x.next[c] != null) {
				return x;
			}
		}
		return null;
	}
}
