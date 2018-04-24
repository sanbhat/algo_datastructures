package data.structure.tree;

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

	private class Node {
		
		private K key;
		private V value;
		
		private int n;
		
		private Node left;
		private Node right;
		
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
	
	private Node root;
	
	/**
	 * Size of this BST. Equivalent of finding {@link BinarySearchTree#size(root)}
	 * @return total number of nodes in this tree
	 */
	public int size() {
		return size(root);
	}
	
	private int size(Node x) {
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
		Node x = get(root, key);
		return x == null ? null : x.value;
	}
	
	private Node get(Node x, K key) {
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
	
	private Node put(Node x, K key, V value) {
		if(x == null) {
			return new Node(key, value, 1);
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
		Node min = min(root);
		return min == null ? null : min.key;
	}
	
	private Node min(Node x) {
		if(x == null) {
			return null;
		}
		Node left = x.left;
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
		Node max = max(root);
		return max == null ? null : max.key;
	}
	
	private Node max(Node x) {
		if(x == null) {
			return null;
		}
		Node right = x.right;
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
		Node f = floor(root, key);
		return f == null ? null : f.key;
	}
	
	private Node floor(Node x, K key) {
		if(x == null) {
			return null;
		}
		int c = key.compareTo(x.key);
		if(c == 0) {
			return x;
		} else if(c < 0) {
			return floor(x.left, key);
		} else {
			Node t = floor(x.right, key);
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
		Node c = ceiling(root, key);
		return c == null ? null : c.key;
	}
	
	private Node ceiling(Node x, K key) {
		if(x == null) {
			return null;
		}
		int c = key.compareTo(x.key);
		if(c == 0) {
			return x;
		} else if(c > 0) {
			return ceiling(x.right, key);		
		} else {
			Node t = ceiling(x.left, key);
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
		Node s = select(root, k);
		return s == null ? null : s.key;
	}
	
	private Node select(Node x, int k) {
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

	private int rank(K key, Node x) {
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
	
	private Node deleteMin(Node x) {
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
	
	private Node deleteMax(Node x) {
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
	
	private Node delete(Node x, K key) {
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
				//3. The node is not a leaf node. To delete x (non-left), find the next replacement for it, which is the 
				//min element from the right subtree of x. Now copy x to oldX and replace x with the min element of x's right subtree.
				//This process involves, first assigning x with minOfRight and then deleting minOfRight. Now set the left subtree of x
				//reading from oldX. Now oldX becomes eligible for GC.
				Node oldX = x;
				x = min(oldX.right);
				x.right = deleteMin(oldX.right);
				x.left = oldX.left;
			}
		}
		x.n = size(x.left) + size(x.right) + 1;
		return x;
	}
	
}
