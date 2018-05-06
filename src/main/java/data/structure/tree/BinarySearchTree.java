package data.structure.tree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * Binary search tree is a Tree data structure, having following characteristics
 * <ul>
 * 	<li> All the node's keys on the left of a node x, are less than x.key
 *  <li> All the node's keys on the right of a node x, are greater than x.key
 * </ul>
 * 
 * @author santhosh
 *
 * @param <K> - Type of key
 * @param <V> - Type of value associated with the key
 */
public class BinarySearchTree<K extends Comparable<K>, V> {

	/**
	 * Class which represents the BST tree node. Its a private static inner class because,
	 * its use is restricted to {@link BinarySearchTree} class. It is static because, thats the
	 * best practice as explained in "Effective Java (Item 22)".
	 * 
	 * @author santhosh
	 *
	 * @param <K> type of key
	 * @param <V> type of value
	 */
	private static class Node<K extends Comparable<K>, V> {
		
		private K key;
		private V value;
		
		private int n;
		
		private Node<K, V> left;
		private Node<K, V> right;
		
		Node(K key, V value, int n) {
			this.key = key;
			this.value = value;
			this.n = n;
		}

		@Override
		public String toString() {
			return "[key=" + key + ", value=" + value + ", NumChindren=" + n + "]";
		}
		
	}
	
	private Node<K, V> root;
	
	/**
	 * Size of this BST. Equivalent of finding {@link BinarySearchTree#size(root)}
	 * @return total number of nodes in this tree
	 */
	public int size() {
		return size(root);
	}
	
	private int size(Node<K, V> x) {
		if(x == null) {
			return 0;
		}
		return x.n;
	}

	/**
	 * Gets a value associated with the passed key. {@code null} if the key is not present in this BST.
	 * @param key key for which the value should be retrieved.
	 * @return value associated with the given key
	 */
	public V get(K key) {
		Node<K, V> x = get(root, key);
		return x == null ? null : x.value;
	}
	
	private Node<K, V> get(Node<K, V> x, K key) {
		if(x == null) {
			return null;
		}
		int c = key.compareTo(x.key);
		if(c < 0) {
			return get(x.left, key);
		} else if(c > 0) {
			return get(x.right, key);
		}
		return x;
	}
	
	/**
	 * Puts a key into this BST, also associating a value with it. The key will be arranged as per the BST rules.
	 * @param key - key to be inserted
	 * @param value - value to be associated with the key
	 */
	public void put(K key, V value) {
		root = put(root, key, value);
	}
	
	private Node<K, V> put(Node<K, V> x, K key, V value) {
		if(x == null) {
			return new Node<>(key, value, 1);
		}
		int c = key.compareTo(x.key);
		if(c < 0) {
			x.left = put(x.left, key, value);
		} else if(c > 0) {
			x.right = put(x.right, key, value);
		} else {
			x.value = value;
		}
		x.n = size(x.left) + size(x.right) + 1;
		return x;
	}
	
	/**
	 * Returns the key with minimum value in this BST.
	 * @return key with minimum value
	 */
	public K min() {
		Node<K, V> min = min(root);
		return min == null ? null : min.key;
	}
	
	private Node<K, V> min(Node<K, V> x) {
		if(x == null) {
			return null;
		}
		Node<K, V> left = x.left;
		if(left == null) {
			return  x;
		}
		return min(left);
	}
	
	/**
	 * Returns key with maximum value in this BST
	 * @return key with maximum value.
	 */
	public K max() {
		Node<K, V> max = max(root);
		return max == null ? null : max.key;
	}
	
	private Node<K, V> max(Node<K, V> x) {
		if(x == null) {
			return null;
		}
		Node<K, V> right = x.right;
		if(right == null) {
			return x;
		}
		return max(right);
	}
	
	/**
	 * Returns the highest key less than the passed {@code key} parameter. 
	 * @param key for which floor value to be determined
	 * @return Highest key less than the passed key parameter
	 */
	public K floor(K key) {
		Node<K, V> f = floor(root, key);
		return f == null ? null : f.key;
	}
	
	private Node<K, V> floor(Node<K, V> x, K key) {
		if(x == null) {
			return null;
		}
		int c = key.compareTo(x.key);
		if(c == 0) {
			return x;
		} else if(c < 0) {
			return floor(x.left, key);
		} else {
			Node<K, V> t = floor(x.right, key);
			if(t != null) {
				return t;
			} else {
				return x;
			}
		}
	}
	
	/**
	 * Returns the lowest key greater than the passed {@code key} parameter
	 * @param key for which the ceiling value to be determined
	 * @return Lowest key greater than the passed key parameter
	 */
	public K ceiling(K key) {
		Node<K, V> c = ceiling(root, key);
		return c == null ? null : c.key;
	}
	
	private Node<K, V> ceiling(Node<K, V> x, K key) {
		if(x == null) {
			return null;
		}
		int c = key.compareTo(x.key);
		if(c == 0) {
			return x;
		} else if(c > 0) {
			return ceiling(x.right, key);		
		} else {
			Node<K, V> t = ceiling(x.left, key);
			if(t != null) {
				return t;
			} else {
				return x;
			}
		}
	}
	
	/**
	 * Select is the process of finding the key of a {@link Node} with the passed rank
	 * @param k - The rank of key in BST to be searched.
	 * @return Key with the rank value, matching param {@code k}
	 */
	public K select(int k) {
		Node<K, V> s = select(root, k);
		return s == null ? null : s.key;
	}
	
	private Node<K, V> select(Node<K, V> x, int k) {
		if(x == null) {
			return null;
		}
		int t = size(x.left);
		if(k < t) {
			return select(x.left, k);
		} else if(k > t) {
			return select(x.right, k - t - 1);
		}
		return x;
	}
	
	/**
	 * Rank of a particular {@code key} in a BST is the number of keys which are lesser than the passed key.
	 * @param key - Key for which the rank should be calculated
	 * @return rank of the key
	 */
	public int rank(K key) {
		return rank(key, root);
	}

	private int rank(K key, Node<K, V> x) {
		if(x == null) {
			return 0;
		}
		int c = key.compareTo(x.key);
		if(c < 0) {
			return rank(key, x.left);
		} else if(c > 0) {
			return 1 + size(x.left) + rank(key, x.right);
		}
		return size(x.left);
	}
	
	/**
	 * Deletes the {@link Node} with minimum {@code key} value from this BST.
	 */
	public void deleteMin() {
		root = deleteMin(root);
	}
	
	private Node<K, V> deleteMin(Node<K, V> x) {
		if(x == null) {
			return null;
		}
		if(x.left == null) {
			//that means, this node is the node with least key in the tree. 
			//Return the right node so that, the right node connects back to parent of x 
			//making x eligible for GC.
			return x.right;
		}
		//if x is not the least node, then search for the least node in the left subtree.
		//The deleteMin method returns the root of the updated tree (after deleting the min node)
		//assign it as the current node's left subtree
		x.left = deleteMin(x.left);
		x.n = size(x.left) + size(x.right) + 1;
		return x;
	}
	
	/**
	 * Deletes the {@link Node} with the maximum {@code key} value from this BST.
	 */
	public void deleteMax() {
		root = deleteMax(root);
	}
	
	private Node<K, V> deleteMax(Node<K, V> x) {
		if(x == null) {
			return null;
		}
		if(x.right == null) {
			return x.left;
		}
		x.right = deleteMax(x.right);
		x.n = size(x.left) + size(x.right) + 1;
		return x;
	}
	
	/**
	 * Tries to delete the {@link Node} object with {@code key} matching the parameter from this BST.
	 * 
	 * @param key - key of the {@link Node} to be deleted.
	 */
	public void delete(K key) {
		root = delete(root, key);
	}
	
	private Node<K, V> delete(Node<K, V> x, K key) {
		if(x == null) {
			return null;
		}
		int c = key.compareTo(x.key);
		//recursively call the delete function, depending on where the key is.
		if(c < 0) {
			x.left = delete(x.left, key);
		} else if(c > 0) {
			x.right = delete(x.right, key);
		} else {
			//we have found the node, which maps to the key. Now there are 3 situations
			//1. The Node's left subtree is null, then simply return the right subtree, and let the x get eligible for GC.
			if(x.left == null) {
				return x.right;
			} 
			//2. The Node's right subtree is null, then simply return the left subtree, and let the x get eligible for GC.
			else if(x.right == null) {
				return x.left;
			} else {
				//3. The node is not a leaf node. To delete x (non-leaf), find the next replacement for it, which is the 
				//min element from the right subtree of x. Now copy x to oldX and replace x with the min element of x's right subtree.
				//This process involves, first assigning x with minOfRight and then deleting minOfRight. Now set the left subtree of x
				//reading from oldX. Now oldX becomes eligible for GC.
				Node<K, V> oldX = x;
				x = min(oldX.right);
				x.right = deleteMin(oldX.right);
				x.left = oldX.left;
			}
		}
		x.n = size(x.left) + size(x.right) + 1;
		return x;
	}
	
	/**
	 * Returns all the keys present in the BST
	 * @return all the keys
	 */
	public Iterable<K> keys() {
		return keys(min(), max());
	}

	/**
	 * Returns all the keys whose values are in the range <code>min</code> and <code>max</code> (Both inclusive)
	 * @param min - Min key
	 * @param max - Max key
	 * @return keys in the range
	 */
	public Iterable<K> keys(K min, K max) {
		Queue<K> queue = new LinkedList<>();
		keys(root, queue, min, max);
		return queue;
	}
	
	private void keys(Node<K, V> x, Queue<K> queue, K min, K max) {
		if(x != null) {
			int cMin = min.compareTo(x.key);
			int cMax = max.compareTo(x.key);
			if(cMin < 0) {
				//min is less than root's key, hence search and add possible keys on the left subtree
				keys(x.left, queue, min, max);
			} 
			if(cMin <= 0 && cMax >= 0) {
				//the root's key falls in the range of min and max value. Hence add the root's key
				queue.add(x.key);
			}
			if(cMax > 0) {
				//max is more than root's key, hence search and add possible keys on the right subtree.
				keys(x.right, queue, min, max);
			}
		}
	}
	
	/**
	 * Collection of the elements of BST as traversed in "InOrder" - <b>iterative</b> method
	 * @return elements traversed in InOrder
	 */
	public Iterable<K> inorderI() {
		List<K> list = new ArrayList<>();
		Stack<Node<K, V>> stack = new Stack<>();
		Node<K, V> c = root;
		if(c == null) {
			return list;
		}
		
		while(c != null) {
			stack.push(c);
			c = c.left;
		}
		
		while(!stack.isEmpty()) {
			c = stack.pop();
			list.add(c.key);
			
			if(c.right != null) {
				c = c.right;
				
				while(c != null) {
					stack.push(c);
					c = c.left;
				}
			}
		}
		
		return list;
	}
	
	/**
	 * Collection of the elements of BST as traversed in "InOrder" - <b>recursive</b> method
	 * @return elements traversed in InOrder
	 */
	public Iterable<K> inorderR() {
		Queue<K> queue = new LinkedList<>();
		inorderR(root, queue);
		return queue;
	}
	
	private void inorderR(Node<K, V> x, Queue<K> queue) {
		if(x != null) {
			if(x.left != null) {
				inorderR(x.left, queue);
			}
			queue.add(x.key);
			if(x.right != null) {
				inorderR(x.right, queue);
			}
		}
	}

	/**
	 * InOrder traversal using Iterator approach
	 * @return - Iterator which gives the elements in InOrder
	 */
	public Iterator<K> inorderItr() {
		return new InorderItr<>(root);
	}
	
	
	/**
	 * Collection of the elements of BST as traversed in "PreOrder" - <b>recursive</b> method
	 * @return elements traversed in PreOrder
	 */
	public Iterable<K> preorderR() {
		Queue<K> queue = new LinkedList<>();
		preorderR(root, queue);
		return queue;
	}
	
	private void preorderR(Node<K, V> x, Queue<K> queue) {
		if(x != null) {
			queue.add(x.key);
			if(x.left != null) {
				preorderR(x.left, queue);
			}
			if(x.right != null) {
				preorderR(x.right, queue);
			}
		}
	}
	
	/**
	 * Collection of the elements of BST as traversed in "PreOrder" - <b>iterative</b> method
	 * @return elements traversed in PreOrder
	 */
	public Iterable<K> preorderI() {
		Stack<Node<K, V>> s = new Stack<>();
		List<K> list = new ArrayList<>();
		
		Node<K, V> x = root;
		
		s.push(x);
		
		while(!s.isEmpty()) {
			x = s.pop();
			list.add(x.key);
			
			if(x.right != null) {
				s.push(x.right);
			}
			if(x.left != null) {
				s.push(x.left);
			}
		}
		
		return list;
	}
	
	/**
	 * Preorder traversal using Iterator approach
	 * @return - Iterator which gives the elements in preorder
	 */
	public Iterator<K> preorderItr() {
		return new PreorderItr<>(root);
	}
	
	/**
	 * Collection of the elements of BST as traversed in "PostOrder" - <b>recursive</b> method
	 * @return elements traversed in PostOrder
	 */
	public Iterable<K> postorderR() {
		Queue<K> queue = new LinkedList<>();
		postorderR(root, queue);
		return queue;
	}
	
	private void postorderR(Node<K, V> x, Queue<K> queue) {
		if(x != null) {
			if(x.left != null) {
				postorderR(x.left, queue);
			}
			if(x.right != null) {
				postorderR(x.right, queue);
			}
			queue.add(x.key);
		}
	}
	
	/**
	 * Collection of the elements of BST as traversed in "PostOrder" - <b>iterative</b> method
	 * @return elements traversed in PostOrder
	 */
	public Iterable<K> postorderI() {
		Stack<K> s2 = new Stack<>();
		Stack<Node<K,V>> s1 = new Stack<>(); 
		List<K> result = new ArrayList<>();
		
		s1.push(root);
		
		while(!s1.isEmpty()) {
			Node<K, V> t  = s1.pop();
			if(t.left != null) {
				s1.push(t.left);
			}
			if(t.right != null) {
				s1.push(t.right);
			}
			s2.push(t.key);
		}
		
		while(!s2.isEmpty()) {
			result.add(s2.pop());
		}
		return result;
	}
	
	/**
	 * Postorder traversal using Iterator approach
	 * @return - Iterator which gives the elements in postorder
	 */
	public Iterator<K> postorderItr() {
		return new PostorderItr<>(root);
	}

	private static class InorderItr<K extends Comparable<K>, V> implements Iterator<K> {

		private Node<K, V> current = null;
		private Stack<Node<K, V>> s = null;
		
		private InorderItr(Node<K, V> root) {
			current = root;
			s = new Stack<>();
			while(current != null) {
				s.push(current);
				current = current.left;
			}
		}

		@Override
		public boolean hasNext() {
			return !s.isEmpty();
		}

		@Override
		public K next() {
			Node<K, V> r = s.pop();
			current = r;
			if(current.right != null) {
				current = current.right;
				while(current != null) {
					s.push(current);
					current = current.left;
				}
			}
			return r.key;
		}
		
	}
	
	private static class PreorderItr<K extends Comparable<K>, V> implements Iterator<K> {
		private Node<K, V> current;
		private Stack<Node<K, V>> s = null;
		
		private PreorderItr(Node<K, V> root) {
			current = root;
			s = new Stack<>();
			s.push(current);
		}

		@Override
		public boolean hasNext() {
			return!s.isEmpty();
		}

		@Override
		public K next() {
			Node<K, V> r = s.pop();
			current = r;
			if(current.right != null) {
				s.push(current.right);
			}
			if(current.left != null) {
				s.push(current.left);
			}
			return r.key;
		}
	}
	
	
	private static class PostorderItr<K extends Comparable<K>, V> implements Iterator<K> {
		
		private Stack<Node<K,V>> s;
		
		
		private PostorderItr(Node<K, V> root) {
			s = new Stack<>();
			findNextLeaf(root);
		}
		
		private void findNextLeaf(Node<K, V> x) {
			while(x != null) {
				s.push(x);
				if(x.left != null) {
					x = x.left;
				} else {
					x = x.right;
				}
			}
		}

		@Override
		public boolean hasNext() {
			return !s.isEmpty();
		}

		@Override
		public K next() {
			Node<K, V> res = s.pop();
			if(!s.isEmpty()) {
				Node<K, V> top = s.peek();
				if(res == top.left) {
					findNextLeaf(top.right);
				}
			}
			return res.key;
		}
		
	}
	
}
