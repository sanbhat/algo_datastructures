package data.structure.heap;

import java.util.Arrays;
import java.util.Collection;

/**
 * Min Heap implementation of {@link Heap} data structure
 * 
 * @see Heap
 * @author santhosh
 *
 * @param <T>
 */
public class MinHeap<T extends Comparable<T>> extends Heap<T> {

	public MinHeap() {
		super(10, false);
	}
	
	public MinHeap(Collection<T> items) {
		super(items, false);
	}
	
	public MinHeap(int initialSize) {
		super(initialSize, false);
	}

	public T delMin() {
		return del();
	}
	
	public T getMin() {
		return get();
	}

	@Override
	public String toString() {
		return "MinHeap "+Arrays.toString(heap());
	}
	
}
