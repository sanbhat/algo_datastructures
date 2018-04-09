package data.structure.list;

import java.util.ListIterator;

import org.junit.Test;

public class ListTest {
	
	@Test
	public void testVector() {
System.out.println("******************** Vector *********************");
		
		Vector<String> v = new Vector<>();
		v.add("a");
		v.add("b");
		v.add("c");
		v.add("d");
		
		System.out.println(v.removeAtIndex(1));
		System.out.println(v.removeAtIndex(1));
		
		v.add("e");
		v.add("f");
		v.add("g");
		v.remove("a");
		v.remove("d");
		
		v.add("h");
		v.add("i");
		v.add("j");
		v.add("k");
		v.add("l");
		v.add("m");
		v.add("n");
		v.add("o");
		
		//insert at index
		v.insert(0, "x");
		v.insert(5, "y");
		v.insert(10, "z");
		
		v.add("p");
		v.add("q");
		
		System.out.println(v);
	}
	
	@Test
	public void testDoublyLinkedList() {
		System.out.println(" ***************** Doubly Linked List *******************");
		
		DoublyLinkedList<Integer> dll = new DoublyLinkedList<>();
		dll.add(1);
		dll.add(3);
		dll.addAfter(3, 7);
		dll.addAfter(3, 5);
		dll.remove();
		dll.add(7);
		
		ListIterator<Integer> li = dll.iterator();
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

	@Test
	public void testSinglyLinkedList() {
		System.out.println("****************** Sigly Linked List *************************");
		SinglyLinkedList<Integer> sll = new SinglyLinkedList<>();
		
		sll.add(2);
		sll.addToFirst(1);
		sll.addToLast(3);
		
		sll.remove();
		sll.removeLast();
		sll.add(4);
		
		sll.removeFirst();
		
		sll.addAfter(4, 5);
		sll.addAfter(5, 6);
		
		System.out.println(sll);
		
		sll.reverse();
		
		System.out.println(sll);
	}
}
