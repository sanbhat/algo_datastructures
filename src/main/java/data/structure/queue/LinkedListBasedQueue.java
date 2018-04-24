package data.structure.queue;

import java.util.Iterator;

/**
 * Linked list based implementation of <b>Queue</b>
 * 
 * @author santhosh
 *
 * @param <T> type of elements
 */
public class LinkedListBasedQueue<T> implements IQueue<T> {
	
	private class Node<N> {
		
		Node(N item) {
			this.item = item;
		}
		
		N item;
		
		Node<N> next;
	}
	
	private int size;
	
	private Node<T> head;
	
	private Node<T> tail;
	
	public LinkedListBasedQueue() {}
	
	public void enQueue(T item) {
		Node<T> newNode = new Node<>(item);
		if(head == null) {
			head = newNode;
			tail = head;
		} else {
			tail.next = newNode;
			tail = newNode;
		}
		size++;
	}
	
	public T deQueue() {
		if(size == 0) {
			throw new IllegalStateException("Queue is empty!");
		}
		Node<T> temp = head;
		head = head.next;
		size--;
		return temp.item;
	}
	
	public int size() {
		return size;
	}
	
	public Iterator<T> iterator() {
		return new QueueIterator(head);
	}
	
	public String toString() {
		return asString();
	}
	
	private class QueueIterator implements Iterator<T> {
		
		private Node<T> current;
		
		QueueIterator(Node<T> head) {
			this.current = head;
		}

		@Override
		public boolean hasNext() {
			return current != null;
		}

		@Override
		public T next() {
			Node<T> t = current;
			current = current.next;
			return t.item;
		}
		
	}

}
