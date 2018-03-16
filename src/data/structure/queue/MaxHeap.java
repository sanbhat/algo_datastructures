package data.structure.queue;

import java.util.Arrays;
import java.util.Random;

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

	public static void main(String[] args) {
		MaxHeap<Integer> maxHeap = new MaxHeap<>();
		Random random = new Random();
		for(int i=0; i<10; i++) {
			maxHeap.insert(random.nextInt(100));
		}
		
		System.out.println(maxHeap);
		
		for(int i=0; i<10; i++) {
			System.out.println(maxHeap.getMax() + " " +maxHeap.delMax());
		}
	}
}
