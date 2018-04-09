package data.structure.heap;

import java.util.Arrays;
import java.util.Collection;

import utils.Utility;

/**
 * <b>Heap</b> or <b>Priority Queue</b> is a data structure which keeps the data in "Heap Order".
 * Depending on the type of Heap (Min or Max), it will allow the user to get the max or min element among the currently available inserted elements in
 * the structure,  with an access time of <code>O (1) </code>.
 * <p>
 * When a new item is inserted, then <code>heapify(..)</code> method is called on all the non-leaf nodes of the heap.
 * <p>
 * When the max/min item is deleted (from first position), then <code>heapify(..)</code> method is called again on the root node.
 * 
 * @author santhosh
 *
 * @param <T>
 */
public abstract class Heap<T extends Comparable<T>> {
	
	private T[] arr;
	
	private int index;
	
	private boolean isMaxHeap;
	
	@SuppressWarnings("unchecked")
	public Heap(Collection<T> items, boolean isMaxHeap) {
		if(items == null) {
			throw new IllegalArgumentException("Items are null!");
		}
		this.arr = (T[]) new Comparable[items.size()];
		this.index = -1;
		this.isMaxHeap = isMaxHeap;
		for(T item : items) {
			insert(item);
		}
	}
	
	@SuppressWarnings("unchecked")
	public Heap(int initialSize, boolean isMaxHeap) {
		this.arr = (T[])new Comparable[initialSize];
		this.index = -1;
		this.isMaxHeap = isMaxHeap;
	}
	

	public int size(){ 
		return index;
	}
	
	public void insert(T item) {
		if(index == arr.length-1) {
			throw new RuntimeException("Heap is full!");
		}
		arr[++index] = item;
		heapifyBottomUp();
	}
	
	protected T del() {
		if(index == -1) {
			throw new RuntimeException("Heap is empty!");
		}
		T item = (T)arr[0];
		arr[0] = arr[index];
		arr[index] = null;
		heapifyTopDown();
		index--;
		return item;
	}
	
	protected void heapifyBottomUp() {
		for(int i = index/2; i>=0; i--) 
			heapify(i);
	}
	
	protected void heapifyTopDown() {
		heapify(0);
	}
	
	protected T get() {
		return (T)arr[0];
	}
	
	protected T[] heap() {
		return Arrays.copyOf(arr, arr.length);
	}
	
	public boolean isEmpty() {
		return size() == -1;
	}
	
	@Override
	public String toString() {
		return "Heap " + Arrays.toString(arr);
	}

	protected void heapify(int i) {
		int root = i;
		int l = 2 * i + 1;
		int r = 2 * i + 2;
		
		if(l < arr.length && arr[l] != null && shouldMoveUp(arr[l], arr[root])) {
			root = l;
		}
		
		if(r < arr.length && arr[r] != null && shouldMoveUp(arr[r], arr[root])) {
			root = r;
		}
		
		if(i !=  root) {
			swap(arr, i, root);
			heapify(root);
		}
	}
	
	protected void swap(T[] arr, int i, int j) {
		Utility.swap(arr, i, j);
	}
	
	private boolean shouldMoveUp(T child, T parent) {
		if(isMaxHeap) {
			return Utility.isGreater(child, parent);
		} else {
			return Utility.isLess(child, parent);
		}
	}

	protected T[] getArr() {
		return arr;
	}


}
