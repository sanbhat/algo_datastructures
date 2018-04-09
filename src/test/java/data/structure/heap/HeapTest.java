package data.structure.heap;

import java.util.Random;
import java.util.stream.IntStream;

import org.junit.Test;

public class HeapTest {
	
	@Test
	public void testIndexMinHeap() {
		System.out.println("**************** Index Min Heap ***************");
		IndexMinHeap<String, Integer> indexMinHeap = new IndexMinHeap<>(10);
		IntStream.of(99, 44, 22, 10, 8, 9, 4, 3, 2, 1).forEach((next) -> {
			String key = next+"";
			indexMinHeap.insert(key, next);
		});
		
		System.out.println(indexMinHeap);
		
		indexMinHeap.change("44", 0);
		
		System.out.println(indexMinHeap);
		
		for(int i=0; i<10; i++) {
			System.out.println("--------------------------------------------------");
			System.out.println(indexMinHeap.getMin() + " " +indexMinHeap.delMin());
			System.out.println(indexMinHeap);
			System.out.println("--------------------------------------------------");
		}
	}
	
	@Test
	public void testMaxHeap() {
		Random random = new Random();
		System.out.println("****************** Max Heap *****************");
		MaxHeap<Integer> maxHeap = new MaxHeap<>();
		for(int i=0; i<10; i++) {
			maxHeap.insert(random.nextInt(100));
		}
		
		System.out.println(maxHeap);
		
		for(int i=0; i<10; i++) {
			System.out.println(maxHeap.getMax() + " " +maxHeap.delMax());
		}
	}

	@Test
	public void testMinHeap() {
		System.out.println("****************** Max Heap *****************");
		Random random = new Random();
		MinHeap<Integer> minHeap = new MinHeap<>();
		for(int i=0; i<10; i++) {
			minHeap.insert(random.nextInt(100));
		}
		System.out.println(minHeap);
		for(int i=0; i<10; i++) {
			System.out.println(minHeap.getMin() + " " +minHeap.delMin() + " , Current Size - " + minHeap.size());
		}
	}

}
