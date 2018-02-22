package data.structure;

import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

/**
 * Doubly LinkedList is a LinkedList data structure, with double connection named <b>previous</b> and <b>next</b>.
 * It consists of a <code>Node</code> structure, which essentially holds tha "data", with link to the "next" node
 * and the "previous" node, within the Linked list sequence.
 * <p> Because of double link, it is very easy to traverse in each direction, add a new item,
 * delete an existing item and reverse the list.
 * 
 * @author santhosh
 *
 * @param <T> - Type of data which the linked list should hold
 */
public class DoublyLinkedList<T>  implements Iterable<T> {

	private class Node {
		
		private T data;
		
		private Node next;
		
		private Node prev;
		
		Node(T data) {
			this.data = data;
		}
	}
	
	private Node head;
	
	private Node tail;
	
	private int size;
	
	public void add(T item) {
		Node newNode = new Node(item);
		
		if(head == null) {
			head = newNode;
			tail = newNode;
		} else {
			tail.next = newNode;
			newNode.prev = tail;
			tail = newNode;
		}
		size++;
	}
	
	public void addAfter(T item, T toBeAdded ) {
		Node current = head;
		while(current != null && !item.equals(current.data)) {
			current = current.next;
		}
		
		if(current == null) {
			throw new NoSuchElementException("item not found in linkedlist!");
		}
		
		Node newNode = new Node(toBeAdded);
		
		Node oldNext = current.next;
		current.next = newNode;
		newNode.prev = current;
		
		if(oldNext != null) {
			newNode.next = oldNext;
			oldNext.prev = newNode;
		}
		
		if(tail == current) {
			tail = newNode;
		}
		size++;
	}
	
	public T remove() {
		
		if(tail == null) {
			throw new NoSuchElementException("linkedlist is empty!");
		}
		
		Node toBeRemoved = tail;
		tail = tail.prev;
		tail.next = null;
		toBeRemoved.prev = null;
		
		size--;
		
		return toBeRemoved.data;
	}
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	@Override
	public ListIterator<T> iterator() {
		return new DoublyLinkedListItr();
	}
	
	@Override
	public String toString() {
		String r = "";
		for(Iterator<T> itr = iterator(); itr.hasNext();) {
			r += itr.next() + "<=>";
		}
		return r;
	}


	private class DoublyLinkedListItr implements ListIterator<T> {
		
		private Node current;
		
		private Node lastReturned;
		
		private int index;
		
		DoublyLinkedListItr() {
			current = head;
			index = -1;
		}

		@Override
		public boolean hasNext() {
			return current != null;
		}

		@Override
		public T next() {
			if(current == null) {
				throw new NoSuchElementException();
			}
			lastReturned = current;
			current = current.next;
			index++;
			return lastReturned.data;
		}

		@Override
		public boolean hasPrevious() {
			return current != null && current.prev != null;
		}

		@Override
		public T previous() {
			if(current == null || current.prev == null) {
				throw new NoSuchElementException();
			}
			current = current.prev;
			lastReturned = current;
			index--;
			return current.data;
		}

		@Override
		public int nextIndex() {
			return index;
		}

		@Override
		public int previousIndex() {
			return index;
		}

		@Override
		public void remove() {
			Node prev = lastReturned.prev;
			Node next = lastReturned.next;
			prev.next = next;
			next.prev = prev;
			lastReturned = null;
			index--;
		}

		@Override
		public void set(T e) {
			lastReturned.data = e;
		}

		@Override
		public void add(T e) {
			if(lastReturned == null) {
				throw new IllegalArgumentException("Add can only be called after next() or previous() call");
			}
			
			index++;
			Node newNode = new Node(e);
			
			Node next = lastReturned.next;
			
			lastReturned.next = newNode;
			newNode.prev = lastReturned;
			newNode.next = next;
			next.prev = newNode;
		}
		
	}

	public static void main(String[] args) {
		DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
		list.add(1);
		list.add(3);
		list.addAfter(3, 7);
		list.addAfter(3, 5);
		list.remove();
		list.add(7);
		
		ListIterator<Integer> li = list.iterator();
		if(li.hasNext()) {
			System.out.println("Next- " + li.next() + " " + li.nextIndex());
		}
		if(li.hasNext()) {
			System.out.println("Next- " + li.next() + " " + li.nextIndex());
		}
		li.set(33);
		li.add(44);
		if(li.hasPrevious()) {
			System.out.println("Prev- " + li.previous() + " " + li.previousIndex());
		}
		if(li.hasPrevious()) {
			System.out.println("Prev- " + li.previous() + " " + li.previousIndex());
		}
		if(li.hasPrevious()) {
			System.out.println("Prev- " + li.previous() + " " + li.previousIndex());
		}
		if(li.hasPrevious()) {
			System.out.println("Prev- " + li.previous() + " " + li.previousIndex());
		}
		
		
	}
}
