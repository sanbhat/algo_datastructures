package data.structure.queue;

import java.util.Arrays;

/**
 * Max Heap implementation of the {@link Heap} data structure. 
 * 
 * @see Heap
 * @author santhosh
 *
 * @param <T>
 */
public class MaxHeap<T extends Comparable<T>> extends Heap<T> {
	
	
	public MaxHeap() {
		super(true);
	}
	
	public MaxHeap(int initialSize) {
		super(initialSize, true);
	}

	public T delMax() {
		return del();
	}
	
	public T getMax() {
		return get();
	}
	
	@Override
	public String toString() {
		return "MaxHeap " + Arrays.toString(heap());
	}

}
