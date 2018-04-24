package data.structure.queue;

import java.util.Iterator;

/**
 * Array backed implementation of <b>Queue</b> data structure, which maintains the FIFO order.
 * 
 * @author santhosh
 *
 * @param <T> type of elements
 */
public class ArrayBasedQueue<T> implements IQueue<T> {
	
	private Object[] arr;
	
	private int size;
	
	
	public ArrayBasedQueue(int size) {
		arr = new Object[size];
		size = 0;
	}
	
	public void enQueue(T item) {
		arr[size++] = item;
	}
	
	@SuppressWarnings("unchecked")
	public T deQueue() {
		if(size == 0) {
			throw new IllegalStateException("Queue is empty!");
		}
		T item = (T) arr[0];
		System.arraycopy(arr, 1, arr, 0, size-1);
		size--;
		return item;
	}
	
	public int size() {
		return size;
	}
	
	public Iterator<T> iterator() {
		return new QueueIterator();
	}
	
	public String toString() {
		return asString();
	}
	
	private class QueueIterator implements Iterator<T> {

		int current = 0;
		
		@Override
		public boolean hasNext() {
			return arr[current] != null;
		}

		@SuppressWarnings("unchecked")
		@Override
		public T next() {
			return (T) arr[current++];
		}
		
	}

}
