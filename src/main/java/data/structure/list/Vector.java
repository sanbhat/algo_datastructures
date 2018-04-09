package data.structure.list;

import java.util.Arrays;

/**
 * Vector or ArrayList, is an auto resizing array based data structure, which is backed by an
 * actual array. This class is generic , which means the data structure can hold elements of any type. 
 * 
 * @author santhosh
 *
 */
public class Vector<T> {

	private Object[] array;
	
	private int size;
	
	private int currentIndex;
	
	public Vector() {
		this(10);
	}

	public Vector(int n) {
		this.currentIndex = 0;
		this.array = new Object[n];
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public void add(T item) {
		ensureCapacity();
		size++;
		array[currentIndex++] = item;
	}

	private void ensureCapacity() {
		if(size >= 0.75 * array.length) {
			expandArray();
		}
	}
	
	public void insert(int index, T item) {
		if(index < 0 && index >= size) {
			throw new IndexOutOfBoundsException("Index "+index+ " is invalid!");
		}
		ensureCapacity();
		System.arraycopy(array, index, array, index+1, size-index+1);
		array[index] = item;
		size++;
		currentIndex++;
	}
	
	public void prepend(T item) {
		insert(0, item);
	}
	
	public T pop() {
		return removeAtIndex(size-1);
	}
	
	public T remove(T item) {
		if(item != null) {
			for(int i = 0; i<size; i++) {
				if(item.equals(array[i])) {
					return removeAtIndex(i);
				}
			}
		} else {
			for(int i = 0; i<size; i++) {
				if(item == array[i]) {
					return removeAtIndex(i);
				}
			}
		}
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public T removeAtIndex(int index) {
		if(index < 0 || index >= currentIndex) {
			throw new IndexOutOfBoundsException("Index "+index+" is not between 0 and "+ (currentIndex-1));
		}
		T toBeRemoved = (T) array[index];
		System.arraycopy(array, index+1, array, index, size);
		size--;
		currentIndex--;
		return toBeRemoved;
	}

	private void expandArray() {
		int newSize =  size + (size >> 1);
		Object[] newTempArr = new Object[newSize];
		System.arraycopy(array, 0, newTempArr, 0, size);
		array = newTempArr;
	}
	
	public String toString() {
		return "Vector " + Arrays.toString(this.array);
	}
}
