package data.structure.list;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Singly LinkedList is a LinkedList data structure with one link per node, pointing to
 * the next node in the sequence. 
 * <p><code>Node</code> structure her will have "data" and a single link pointing to next node
 * in the sequence. Because of this simple structure, it is an easy to understand data structure.
 * <p> With a single forward link, it is very easy to traverse forward, add elements, delete elements
 * , But, bit difficult to traverse in reverse order, delete previous element etc.
 * 
 * 
 * @author santhosh
 *
 * @param <T> - Type of data which the list will hold
 */
public class SinglyLinkedList<T> implements Iterable<T> {
	
	private class Node {
		
		Node(T data) {
			this.data = data;
		}
		
		private T data;
		private Node next;
	}
	
	private Node head;
	
	private Node tail;
	
	private int modCount;
	
	public SinglyLinkedList() {
		head = tail = null;
	}
	
	public void add(T item) {
		addToLast(item);
	}
	
	public T remove() {
		return removeLast();
	}
	
	public T remove(T item) {
		if(head == null) {
			throw new NoSuchElementException("LinkedList is empty!");
		}
		Node current = head;
		Node prev = head;
		while(!current.data.equals(item)) {
			prev = current;
			current = current.next;
		}
		T r = current.data;
		prev.next = current.next;
		return r;
	}
	
	public void addAfter(T item, T newItem) {
		if(head == null) {
			throw new NoSuchElementException("LinkedList is empty!");
		}
		Node current = head;
		while(!current.data.equals(item)) {
			current = current.next;
		}
		Node newNode = new Node(newItem);
		Node next = current.next;
		current.next = newNode;
		newNode.next = next;
	}
	
	public T removeLast() {
		//no elements
		if(tail == null) {
			throw new NoSuchElementException("LinkedList is empty!");
		}
		
		modCount++;
		
		//single elements
		if(head == tail) {
			T r = head.data;
			head = null;
			tail = null;
			return r;
		}
		
		//at least 2 elements
		Node prev = head;
		Node next = prev.next;
		while(next.next != null) {
			prev = prev.next;
			next = prev.next;
		}
		
		T r = next.data;
		prev.next = null;
		tail = prev;
		return r;
	}
	
	public T removeFirst() {
		if(head == null) {
			throw new NoSuchElementException("LinkedList is empty!");
		}
		
		modCount++;
		
		T r = head.data;
		head = head.next;
		return r;
	}
	
	public void addToFirst(T item) {
		Node newNode = new Node(item);
		
		if(head == null) {
			head = newNode;
			tail = newNode;
		} else {
			newNode.next = head;
			head = newNode;
		}
		
		modCount++;
	}
	
	public void addToLast(T item) {
		Node newNode = new Node(item);
		
		if(tail == null) {
			head = newNode;
			tail = newNode;
		} else {
			tail.next = newNode;
			tail = newNode;
		}
		
		modCount++;
	}
	
	public void reverse() {
		Node prev = null;
		Node current = null;
		
		while(head != null) {
			prev = current;
			current = head;
			head = head.next;
			current.next = prev;
		}
		
		head = current;
	}
	
	
	@Override
	public String toString() {
		String result = "";
		for(Iterator<T> i = iterator(); i.hasNext();) {
			result += i.next() + "->";
		}
		return result;
	}


	private class SinglyLinkedListItr implements Iterator<T> {
		
		private Node current;
		
		SinglyLinkedListItr(Node head) {
			this.current = head;
		}

		@Override
		public boolean hasNext() {
			return current != null;
		}

		@Override
		public T next() {
			T data = current.data;
			current = current.next;
			return data;
		}
		
	}




	@Override
	public Iterator<T> iterator() {
		return new SinglyLinkedListItr(head);
	}
	
	
}
