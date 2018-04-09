package data.structure.queue;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * * Stack is a Last In First Out (LIFO) data structure, which keeps the last
 * inserted item in the head position, so that it can be returned when a call is made
 * to retrieve an element from the stack.
 * <p> There are several implementations of the stack. This one is "Singly LinkedList" based implementation.
 * 
 * @author santhosh
 * 
 * @param <T> Type of the elements
 *
 */
public class StackSLL<T> implements Iterable<T> {

	private class Node {
		
		Node(T data) {
			this.data = data;
		}
		
		private T data;
		private Node next;
	}
	
	private Node top;
	
	private int size;
	
	public void push(T item) {
		Node newNode = new Node(item);
		if(top == null) {
			top =  newNode;
		} else {
			newNode.next = top;
			top = newNode;
		}
		size++;
	}
	
	public T peek() {
		if(top == null) {
			return null;
		} else{
			return top.data;
		}
	}
	
	public T pop() {
		if(top == null) {
			throw new NoSuchElementException("Stack is empty!");
		} 
		T item = top.data;
		Node prevTop = top;
		top = top.next;
		prevTop.next = null;
		size--;
		return item;
	}
	
	@Override
	public Iterator<T> iterator() {
		return new StackSLLItr();
	}
	
	public int size() {
		return size;
	}
 	
	@Override
	public String toString() {
		String s = "";
		for(Iterator<T> i = iterator(); i.hasNext(); ) {
			s += i.next() + " -> ";
		}
		return s;
	}

	private class StackSLLItr implements Iterator<T> {
		
		private Node current;
		
		public StackSLLItr() {
			this.current = top;
		}

		@Override
		public boolean hasNext() {
			return current != null;
		}

		@Override
		public T next() {
			if(current == null) {
				throw new NoSuchElementException("There is no element!");
			}
			T item = current.data;
			current = current.next;
			return item;
		}

	}
	
}
