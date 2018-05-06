package data.structure.tree;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.Iterator;

import org.junit.Test;

public class TreeTest {

	/**
	 * Tree looks like below
	 *            50
	 *          /   \
	 * 		   /     \
	 * 		  30      70
	 * 		 /	\	 /  \
	 * 		10	40  60   90
	 * 
	 */
	@Test
	public void testBst() {
		
		BinarySearchTree<Integer, Integer> bst = new BinarySearchTree<>();
		bst.put(50, 50);
		bst.put(30, 30);
		bst.put(40, 40);
		bst.put(10, 10);
		bst.put(70, 70);
		bst.put(60, 60);
		bst.put(90, 90);
		
		assertEquals(Integer.valueOf(30), bst.get(30));
		assertEquals(Integer.valueOf(90), bst.get(90));
		assertEquals(Integer.valueOf(50), bst.get(50));
		
		assertEquals(Integer.valueOf(10), bst.floor(10));
		assertEquals(Integer.valueOf(60), bst.floor(61));
		
		assertEquals(Integer.valueOf(70), bst.ceiling(61));
		assertEquals(Integer.valueOf(40), bst.ceiling(40));
		
		assertEquals(Integer.valueOf(10), bst.min());
		
		assertEquals(Integer.valueOf(90), bst.max());
		
		assertEquals(3, bst.rank(50));
		assertEquals(Integer.valueOf(50), bst.select(3));
		
		System.out.println("Inorder Iterative - " + bst.inorderI());
		System.out.println("Inorder Recursive - " + bst.inorderR());
		System.out.println("Inorder using iterator - ");
		for(Iterator<Integer> i = bst.inorderItr(); i.hasNext(); ) {
			System.out.print(i.next() + (i.hasNext() ? " " : "\n"));
		}
		
		System.out.println("Preorder Iterative - " + bst.preorderI());
		System.out.println("Preorder Recursive - " + bst.preorderR());
		System.out.println("Preorder using iterator - ");
		for(Iterator<Integer> i = bst.preorderItr(); i.hasNext(); ) {
			System.out.print(i.next() + (i.hasNext() ? " " : "\n"));
		}
		
		System.out.println("Postorder Iterative - " + bst.postorderI());
		System.out.println("Postorder Recursive - " + bst.postorderR());
		System.out.println("Postorder using iterator - ");
		for(Iterator<Integer> i = bst.postorderItr(); i.hasNext(); ) {
			System.out.print(i.next() + (i.hasNext() ? " " : "\n"));
		}
		
		bst.deleteMin();
		System.out.println("Deleted min");
		assertEquals(Integer.valueOf(30), bst.min());
		bst.deleteMax();
		System.out.println("Deleted max");
		assertEquals(Integer.valueOf(70), bst.max());
		
		bst.delete(50);
		assertNull(bst.get(50));
		System.out.println("Deleted 50");
		
		System.out.println("All keys - " + bst.keys());
		System.out.println("Keys in range (35-75) - "+bst.keys(35, 75));
		
	}
}
