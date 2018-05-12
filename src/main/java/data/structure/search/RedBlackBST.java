package data.structure.search;

/**
 * Red Black BST is an enhanced BST data structure, which guarantees the
 * time complexity of {@code O(log n)} by making sure the tree is always
 * balanced, no matter in which order the keys are added.
 * <p>
 * The Red Black BST, maintains the height of the tree at max {@code log n}
 * by doing <b>Rotate</b> and <b>Flip Color</b> operations to achieve the desired
 * time complexity. 
 * 
 *  
 * @author santhosh
 *
 */
public class RedBlackBST<K extends Comparable<K>, V> {
	
	public enum Color {
		RED, BLACK
	}
	
	private static class Node<K extends Comparable<K>, V> {
		
		private K key;
		private V value;
		
		private int n;
		
		private Color color;
		
		private Node<K, V> left;
		private Node<K, V> right;
		
		Node(K key, V value, int n, Color color) {
			this.key = key;
			this.value = value;
			this.n = n;
			this.color = color;
		}
		
	}
	
	private int size(Node<K, V> x) {
		return x != null ? x.n : 0;
	}
	
	/**
	 * Checks if the {@link Node}'s color is <b>RED</b>
	 * @param h - Node to be checked 
	 * @return - <code>true</code> if node's color is RED, <code>false</code> otherwise.
	 */
	private boolean isRed(Node<K, V> h) {
		return h != null && h.color != null && Color.RED == h.color;
	}
	
	/**
	 * Rotates the {@link Node} pointed by <code>h</code> to the left. Meaning, the element on the <b>right</b>
	 * side of <code>h</code> will become <code>h</code>'s parent. <code>h</code>'s right will be new parent's left.
	 * and new parent's left will be <code>h</code> .
	 *  
	 * @param h - The root of the subtree, which needs to be left rotated
	 * @return The new root of subtree, after left rotation.
	 */
	private Node<K, V> rotateLeft(Node<K, V> h) {
		Node<K, V> x = h.right;
		h.right = x.left;
		x.left = h;
		x.color = h.color;
		h.color = Color.RED;
		x.n = h.n;
		h.n = 1 + size(h.left) + size(h.right);
		return x;
	}
	
	/**
	 * Rotates the {@link Node} pointed by <code>h</code> to the right. Meaning,
	 * <code>h</code>'s <b>left</b> will be the new parent of <code>h</code>. New parent's
	 * right will be <code>h</code>'s left. And <code>h</code> will be new parent's right.
	 * 
	 * @param h - The root of the subtree, which needs to be right rotated.
	 * @return The new root of the subtree, after right rotation.
	 */
	private Node<K, V> rotateRight(Node<K, V> h) {
		Node<K, V> x = h.left;
		h.left = x.right;
		x.right = h;
		x.color = h.color;
		h.color = Color.RED;
		x.n = h.n;
		h.n = 1 + size(h.left) + size(h.right);
		return x;
	}
	
	/**
	 * Flips the color of the children of {@link Node} with root <code>h</code>. The children's color
	 * will change to <b>BLACK</b> from <b>RED</b> and <code>h</code>'s color will change to <b>RED</b>.
	 * @param h The root node of a subtree, whose color to be changed.
	 */
	private void flipColors(Node<K, V> h) {
		h.color = Color.RED;
		h.left.color = Color.BLACK;
		h.right.color = Color.BLACK;
	}
	
	private Node<K, V> root;
	
	public void put(K key, V value) {
		root = put(root, key, value);
		root.color = Color.BLACK;
	}

	private Node<K, V> put(Node<K, V> h, K key, V value) {
		if(h == null) {
			return new Node<>(key, value, 1, Color.RED);
		}
		
		int c = key.compareTo(h.key);
		if(c < 0) {
			h.left = put(h.left, key, value);
		} else if(c > 0) {
			h.right = put(h.right, key, value);
		} else {
			h.value = value;
		}
		
		if(isRed(h.right) && !isRed(h.left)) rotateLeft(h);
		if(isRed(h.left) && isRed(h.left.left)) rotateRight(h);
		if(isRed(h.left) && isRed(h.right)) flipColors(h);
		
		h.n = 1 + size(h.left) + size(h.right);
		
		return h;
	}
	
	public V get(K key) {
		Node<K, V> x = get(root, key);
		return x != null ? x.value : null;
	}
	
	private Node<K, V> get(Node<K, V> x, K key) {
		if(x == null) {
			return null;
		}
		int c = key.compareTo(x.key);
		if(c < 0) {
			return get(x.left, key);
		} else if (c > 0) {
			return get(x.right, key);
		} else {
			return x;
		}
	}
	
}
