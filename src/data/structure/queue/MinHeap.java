package data.structure.queue;

import java.util.Arrays;
import java.util.Random;

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
		super(false);
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
	
	public static void main(String[] args) {
		MinHeap<Integer> maxHeap = new MinHeap<>();
		Random random = new Random();
		for(int i=0; i<10; i++) {
			maxHeap.insert(random.nextInt(100));
		}
		
		System.out.println(maxHeap);
		
		for(int i=0; i<10; i++) {
			System.out.println(maxHeap.getMin() + " " +maxHeap.delMin());
		}
	}
	
	
}
