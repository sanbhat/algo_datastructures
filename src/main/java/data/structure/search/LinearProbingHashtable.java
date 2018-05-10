package data.structure.search;

import java.util.Iterator;

public class LinearProbingHashtable<K, V> {

	public static class Entry<K, V> {
		
		K key;
		
		V value;
		
		private Entry(K key, V value) {
			this.key = key;
			this.value = value;
		}
		
		@Override
		public String toString() {
			return "Entry ["+this.key+", "+this.value+"]";
		}
	}
	
	private volatile int modCount;
	
	private Entry<K, V>[] arr;
	
	//size of the array
	private int m;
	
	//number of key-value pairs
	private int n;
	
	public LinearProbingHashtable() {
		this(16);
	}
	
	@SuppressWarnings("unchecked")
	public LinearProbingHashtable(int initialCapacity) {
		this.m = initialCapacity;
		this.arr = new Entry[m];
	}
	
	/**
	 * check <a href='https://stackoverflow.com/questions/9380670/why-does-java-use-hash-0x7fffffff-tab-length-to-decide-the-index-of-a-key'>this Q&A</a>
	 * to find out, why Bitwise & of hashCode() and 0x7fffffff is used.
	 * @param key - key to be hashed as index
	 * @return index within the array
	 */
	private int hash(K key) {
		return (key.hashCode() & 0x7fffffff) % m;
	}
	
	public void put(K key, V value) {
		if(key == null || value == null) {
			throw new NullPointerException("Key or value cannot be null");
		}
		if(n >= m/2) {
			resize(m*2);
		}
		int index = hash(key);
		for(int i=index; arr[i] != null; i = (i+1) % m) {
			if(key.equals(arr[i].key)) {
				arr[i].value = value;
				return;
			}
		}
		arr[index] = new Entry<>(key, value);
		modCount++;
		n++;
	}
	
	public V get(K key) {
		if(key == null) {
			throw new NullPointerException("Key cannot be null");
		}
		int index = hash(key);
		for(int i=index; arr[i] != null; i = (i+1) % m) {
			if(key.equals(arr[i].key)) {
				return arr[i].value;
			}
		}
		return null;
	}
	
	public boolean contains(K key) {
		boolean result = false;
		if(key != null) {
			int index = hash(key);
			for(int i=index; arr[i] != null; i = (i+1) % m) {
				if(key.equals(arr[i].key)) {
					result = true;
					break;
				}
			}
		}
		return result;
	}
	
	public V delete(K key) {
		V result = null;
		if(contains(key)) {
			int index = hash(key);
			while(!key.equals(arr[index].key)) {
				index = (index+1) % m;
			}
			result = arr[index].value;
			arr[index] = null;
			index = (index+1) % m;

			while(arr[index] != null) {
				K keyRedo = arr[index].key;
				V valRedo = arr[index].value;

				arr[index] = null;
				n--;
				put(keyRedo, valRedo);
				index = (index+1) % m;
			}
			n--;
			modCount++;
			//if n:m ratio becomes too small, shrink the overall array by 1/2 to save some memory!
			if(n > 0 && n == m/8 ) {
				resize(m/2);
			}
		}
		return result;
	}
	
	public Iterator<Entry<K, V>> entryIterator() {
		return new EntryItr();
	}
	
	public Iterator<K> keyIterator() {
		return new KeyItr();
	}
	
	public Iterator<V> valueIterator() {
		return new ValItr();
	}
	
	private void resize(int size) {
		LinearProbingHashtable<K, V> temp = new LinearProbingHashtable<>(size);
		for(int i=0; i<m; i++) {
			if(arr[i] != null) {
				temp.put(arr[i].key, arr[i].value);
			}
		}
		this.arr = temp.arr;
		this.m = temp.m;
	}
	
	
	
	@Override
	public String toString() {
		String s = "[";
		for(Iterator<Entry<K, V>> i = entryIterator(); i.hasNext();) {
			Entry<K, V> e = i.next();
			s += "{ "+e.key + " = " + e.value + " }";
		}
		s += "]";
		return s;
	}



	abstract class BaseEntryItr {
		
		int count;
		int i;
		int n;
		int m;
		int recentModCount;
		
		public BaseEntryItr() {
			i = 0;
			this.n = LinearProbingHashtable.this.n;
			this.m = LinearProbingHashtable.this.m;
			recentModCount = modCount;
		}

		public boolean hasNext() {
			return count < n;
		}

		Entry<K, V> nextEntry() {
			while(arr[i] == null) {
				i = (i+1) % m;
			}
			count++;
			return arr[i++];
		}
		
	}
	
	
	private class KeyItr extends BaseEntryItr implements Iterator<K> {

		@Override
		public K next() {
			return nextEntry().key;
		}
		
	}
	
	private class ValItr extends BaseEntryItr implements Iterator<V> {

		@Override
		public V next() {
			return nextEntry().value;
		}
		
	}
	
	private class EntryItr extends BaseEntryItr implements Iterator<Entry<K, V>> {

		@Override
		public Entry<K, V> next() {
			return nextEntry();
		}
		
	}
	
}
