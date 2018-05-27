package data.structure.tries;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TriesTest {

	@Test
	public void rWayTrieTest() {
		TrieST<Integer> trie = new TrieST<>();
		
		trie.put("she", 0);
		trie.put("sells", 1);
		trie.put("sea", 2);
		trie.put("shells", 3);
		trie.put("by", 4);
		trie.put("the", 5);
		trie.put("sea", 6);
		trie.put("shore", 7);
		
		assertEquals(Integer.valueOf(6), trie.get("sea"));
		
		assertEquals("[she, shells, shore]", trie.keysWithPrefix("sh").toString());
		assertEquals("[sea]", trie.keysThatMatch("s.a").toString());
	}
}
