package data.structure;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * * Stack is a Last In First Out (LIFO) data structure, which keeps the last
 * inserted item in the head position, so that it can be returned when a call is made
 * to retrieve an element from the stack.
 * <p> There are several implementations of the stack. This one is "Doubly LinkedList" based implementation.
 * 
 * @author santhosh
 *
 * @param <T> - Type of elements
 */
public class StackDLL<T> implements Iterable<T>{
	
	private class Node {
		
		T item;
		
		Node(T item) {
			this.item = item;
		}
		
		Node prev;
		Node next;
	}
	
	private Node top;
	
	private int size;
	
	public void push(T item) {
		Node newNode = new Node(item);
		if(top == null) {
			top = newNode;
		} else {
			newNode.next = top;
			top.prev = newNode;
			top = newNode;
		}
		size++;
	}
	
	public T peek() {
		if(top == null) {
			return null;
		} else {
			return top.item;
		}
	}
	
	public T pop() {
		if(top == null) {
			throw new NoSuchElementException("Stack is empty!");
		}
		Node newTop = top.next;
		top.next = null;
		if(newTop != null) {
			newTop.prev = null;
		}
		T item = top.item;
		top = newTop;
		size--;
		return item;
	}
	
	public int size() {
		return size;
	}

	@Override
	public Iterator<T> iterator() {
		return new StackDLLItr();
	}
	
	
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for(Iterator<T> i = iterator(); i.hasNext(); ) {
			sb.append(i.next()).append(" | ");
		}
		if(sb.indexOf("|") != -1) {
			sb.deleteCharAt(sb.lastIndexOf("|"));
		}
		return sb.toString();
	}



	private class StackDLLItr implements Iterator<T> {
		
		private Node current;
		
		private StackDLLItr() {
			this.current = top;
		}

		@Override
		public boolean hasNext() {
			return current != null;
		}

		@Override
		public T next() {
			if(current == null) {
				throw new NoSuchElementException("No more items to iterate");
			}
			
			T item = current.item;
			current = current.next;
			return item;
		}
		
	}
	
	public static void main(String[] args) {
		StackDLL<Character> stack = new StackDLL<>();
		stack.push('A');
		stack.push('B');
		stack.push('C');
		stack.push('D');
		
		System.out.println(stack.peek());
		
		stack.pop();
		stack.pop();
		
		stack.push('E');
		stack.push('F');
		
		System.out.println(stack.size());
		
		stack.pop();
		stack.pop();
		stack.pop();
		stack.pop();

		
		stack.push('A');
		stack.push('B');
		stack.push('C');
		stack.push('D');
		stack.push('E');
		stack.push('F');
		stack.push('H');
		stack.push('I');
		stack.push('J');
		stack.push('K');
		stack.push('L');
		stack.push('M');
	}

}
