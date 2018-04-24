package data.structure.queue;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Stack is a Last In First Out (LIFO) data structure, which keeps the last
 * inserted item in the head position, so that it can be returned when a call is made
 * to retrieve an element from the stack.
 * <p> There are several implementations of the stack. This one is "array" based implementation.
 * 
 * @author santhosh
 *
 * @param <T> Type of elements
 */
public class Stack<T> implements Iterable<T> {
	
	private class StackElement<S> {
		S element;
		
		S min;
		
		StackElement(S element, S min) {
			this.element = element;
			this.min = min;
		}
		
		public String toString() {
			return "Item - " + this.element + " Min - " + this.min;
		}
	}
	
	private StackElement<T>[] array;
	
	private int top;
	
	private int size;
	
	private T min;
	
	private Comparator<T> comparator;
	
	public Stack() {
		this(10);
	}

	public Stack(int n) {
		this(n, null);
	}
	
	@SuppressWarnings("unchecked")
	public Stack(int n, Comparator<T> c) {
		array = new StackElement[n];
		top = -1;
		comparator = c;
	}
	
	public void push(T item) {
		if(top == array.length -1) {
			ensureCapacity();
		}
		if(min == null || compare(item, min) < 0) {
			min = item;
		}
		array[++top] = new StackElement<>(item, min);
		size++;
	}
	
	public T peek() {
		if(top == -1) {
			return null;
		}
		return array[top].element;
	}
	
	public T pop() {
		if(top == -1) {
			throw new NoSuchElementException("stack is empty!");
		}
		
		T r = array[top].element;
		array[top] = null;
		top--;
		if(top != -1) {
			min = array[top].min;
		} else {
			min = null;
		}
		size--;
		return r;
	}
	
	public T min() {
		return min;
	}
	
	public int size() {
		return size;
	}

	private void ensureCapacity() {
		int existingCapacity = array.length;
		int newCapacity = existingCapacity + (existingCapacity >> 1);
		array = Arrays.copyOf(array, newCapacity);
	}
	
	private int compare(T t1, T t2) {
		return comparator == null ? 0 : comparator.compare(t1, t2);
	}
	
	@Override
	public Iterator<T> iterator() {
		return new StackItr(top);
	}
	
	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();
		s.append("[");
		boolean hasElements = false;
		for(Iterator<T> i = iterator(); i.hasNext();) {
			s.append(i.next()).append(", ");
			hasElements = true;
		}
		if(hasElements)
			s.delete(s.lastIndexOf(", "), s.lastIndexOf(", ") + 2);
		s.append("]");
		return s.toString();
	}



	private class StackItr implements Iterator<T> {

		private int current;
		
		StackItr(int top) {
			this.current = top;
		}
		
		@Override
		public boolean hasNext() {
			return current > -1;
		}

		@Override
		public T next() {
			return array[current--].element;
		}
		
	}
	
}
