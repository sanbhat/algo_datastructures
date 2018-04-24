package data.structure.tree;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;

public class TreeTest {

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
		
		bst.deleteMin();
		assertEquals(Integer.valueOf(30), bst.min());
		bst.deleteMax();
		assertEquals(Integer.valueOf(70), bst.max());
		
		bst.delete(50);
		assertNull(bst.get(50));
		
		
		
	}
}
