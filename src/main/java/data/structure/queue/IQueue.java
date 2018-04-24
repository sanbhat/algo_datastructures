package data.structure.queue;

import java.util.Iterator;

public interface IQueue<T> {

	public int size();
	
	public void enQueue(T item);
	
	public T deQueue();
	
	public Iterator<T> iterator();
	
	default String asString() {
		String s = "";
		for(Iterator<T> i = iterator(); i.hasNext();) {
			s += i.next() + " ";
		}
		return s.trim();
	}
}
