package data.structure;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Array based stack implementation
 * 
 * @author santhosh
 *
 * @param <T> Type of elements
 */
@SuppressWarnings("unchecked")
public class Stack<T> implements Iterable<T> {
	
	private Object[] array;
	
	private int top;
	
	private int size;
	
	public Stack() {
		this(10);
	}

	public Stack(int n) {
		array = new Object[n];
		top = -1;
	}
	
	public void push(T item) {
		if(top == array.length -1) {
			ensureCapacity();
		}
		array[++top] = item;
		size++;
	}
	
	public T peek() {
		if(top == -1) {
			return null;
		}
		return (T) array[top];
	}
	
	public T pop() {
		if(top == -1) {
			throw new NoSuchElementException("stack is empty!");
		}
		
		T r = (T) array[top];
		array[top] = null;
		top--;
		size--;
		return r;
	}
	
	public int size() {
		return size;
	}

	private void ensureCapacity() {
		int existingCapacity = array.length;
		int newCapacity = existingCapacity + (existingCapacity >> 1);
		array = Arrays.copyOf(array, newCapacity);
	}
	
	@Override
	public Iterator<T> iterator() {
		return new StackItr(top);
	}
	
	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();
		s.append("[ ");
		boolean hasElements = false;
		for(Iterator<T> i = iterator(); i.hasNext();) {
			s.append(i.next()).append(", ");
			hasElements = true;
		}
		if(hasElements)
			s.deleteCharAt(s.lastIndexOf(", "));
		s.append(" ]");
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
			return (T)array[current--];
		}
		
	}
	
	public static void main(String[] args) {
		Stack<Character> stack = new Stack<>();
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
