package data.structure.heap;

import java.util.HashMap;
import java.util.Map;

import utils.Utility;

/**
 * {@code IndexMinHeap} is an unique Min Heap implementation, where min heap order is maintained as 
 * per the {@code K} (key) object, but the return values of the heap methods are {@code I} (index) objects
 * corresponding to the mapped <b>key</b>.
 * <p>
 * This data structure is very useful, if we are using a &lt;{@code Index,Key}&gt; pair and we need to 
 * maintain the min heap order based on {@code Key}. When <code>delMin()</code> method is called,
 * the minimum value from the heap will be deleted, and the mapped {@code Index} of that value is returned.
 * 
 * @author santhosh
 *
 * @param <I> - Type of index
 * @param <K> - Type of key (this key is used for heap ordering)
 */
public class IndexMinHeap<I, K extends Comparable<K>> extends Heap<K> {

	private I[] indexArr;
	
	private Map<I, Integer> indexToKeyIndexMap;
	
	@SuppressWarnings("unchecked")
	public IndexMinHeap(int size) {
		super(size, false);
		this.indexArr = (I[]) new Object[size];
		this.indexToKeyIndexMap = new HashMap<>();
	}
	
	@Override
	public void insert(K item) {
		throw new UnsupportedOperationException("Use insert(I, K) method to insert a Index, Key pair");
	}

	public void insert(I key, K value) {
		indexArr[size() + 1] = key;
		indexToKeyIndexMap.put(key, size() + 1);
		super.insert(value);
	}
	
	public void change(I key, K newValue) {
		int index = indexToKeyIndexMap.get(key);
		getArr()[index] = newValue;
		heapifyBottomUp();
	}
	
	public I delMin() {
		indexToKeyIndexMap.put(indexArr[size()], 0);
		indexToKeyIndexMap.remove(indexArr[0]);
		I topKey = indexArr[0];
		indexArr[0] = indexArr[size()];
		indexArr[size()] = null;
		super.del();
		return topKey;
	}
	
	public I getMin() {
		return indexArr[0];
	}

	public boolean containsIndex(I index) {
		return this.indexToKeyIndexMap.keySet().contains(index);
	}

	@Override
	protected void swap(K[] arr, int i, int j) {
		indexToKeyIndexMap.put(indexArr[i], j);
		indexToKeyIndexMap.put(indexArr[j], i);
		super.swap(arr, i, j);
		Utility.swap(indexArr, i, j); //swap the respective position of key
	}


	@Override
	public String toString() {
		String s =  "IndexMinHeap [";  
		for(int i=0; i<=size(); i++) {
			s += indexArr[i] + " = " + getArr()[i]  + ", ";
		}
		s += "]\n";
		return s;
	}
	
	

}
