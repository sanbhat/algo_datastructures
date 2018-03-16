package main;

import data.structure.list.Vector;

public class Main {

	public static void main(String[] args) {
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
	}

}
