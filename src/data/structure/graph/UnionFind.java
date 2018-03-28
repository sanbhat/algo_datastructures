package data.structure.graph;

import java.util.HashMap;
import java.util.Map;

/**
 * <b>UnionFind</b> is a data structure which helps to establish a connection between two components which are disjoint (<code>union()</code>)
 * thus by making it part of a subset. It also gives API's to check if, two components are connected to each other by direct or indirect means
 * (<code>find()</code>)
 * <p>
 * The implementation of union here is based on <b>Weighted Quick Union</b> approach, where if components from two disjoint subsets connect to
 * each other then, the root of the subset with larger size will become the root of the subset with smaller size (For this purpose, we need to
 * track the size of each disjoint subsets using <code>size</code> {@link Map})
 * <p> 
 * The implementation also uses <b>Path compression</b> approach to make the process of finding the root of a particular component, as efficient
 * as possible.
 * 
 * @author santhosh
 *
 * @param <T> - Type of components (The components must have valid <code>equals()</code> implementation
 */
public class UnionFind<T> {
	
	//Map which holds a Component and its root. Initially, all the Components will have themselves as the root!
	private Map<T, T> unions;
	
	//Map which holds the root of the disjoint subsets and its size. Initially we will have as many subsets as the components, having size of each
	//component as 1. As the union happens, the subsets becomes large along with their size.
	private Map<T, Integer> size;
	
	public UnionFind() {
		unions = new HashMap<>();
		size = new HashMap<>();
	}
	
	private T root(T i) {
		while(unions.get(i) != null && !unions.get(i).equals(i)) {
			i = unions.get(unions.get(i));
		}
		return i;
	}

	/**
	 * Check whether component <code>i</code> and component <b>j</b> are connected or not
	 * @param i - Component i
	 * @param j - Component j
	 * @return <code>true</code> if they are connected, <code>false</code> otherwise.
	 */
	public boolean find(T i, T j) {
		return root(i) == root(j);
	}
	
	/**
	 * Connects a component <code>i</code> with component <code>j</code> by performing union operation
	 * @param i - Component i
	 * @param j - Component j
	 */
	public void union(T i, T j) {
		init(i);
		init(j);
		if(!find(i, j)) {
			T root_i = root(i);
			T root_j = root(j);

			if(size.get(root_i) < size.get(root_j)) {
				unions.put(root_i, root_j);
				size.put(root_j, size.get(root_j) + size.get(root_i));
			} else {
				unions.put(root_j, root_i);
				size.put(root_i, size.get(root_i) + size.get(root_j));
			}
		}
	}

	private void init(T i) {
		if(!unions.containsKey(i)) {
			unions.put(i, i);
		}
		if(!size.containsKey(i)) {
			size.put(i, 1);
		}
	}

}
