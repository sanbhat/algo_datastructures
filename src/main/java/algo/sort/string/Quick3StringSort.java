package algo.sort.string;

import utils.Utility;

public class Quick3StringSort {
	
	public static void sort(String[] arr) {
		sort(arr, 0, arr.length-1, 0);
	}
	
	private static int charAt(String s, int d) {
		return d < s.length() ? s.charAt(d) : -1; 
	}
	
	private static void sort(String[] arr, int lo, int hi, int d) {
		if(hi <= lo) {
			return;
		}
		
		//partition the array into 3 partitions
		int lt = lo, gt = hi;
		int v = charAt(arr[lo], d);
		int i = lo+1;
		
		while(i <= gt) {
			int t = charAt(arr[i],d);
			if(t < v) Utility.swap(arr, lt++, i++);
			else if(t > v) Utility.swap(arr, i, gt--);
			else i++;
		}
		
		//after partition, arr[lo, lt-1] < v && arr[lt, gt] == v &&  arr[gt+1, hi] > v
		
		sort(arr, lo, lt-1, d); //sort the array recursively on the same character index
		if(v >= 0) sort(arr, lt, gt, d+1); // for strings which have same LSD character, compare the next character
		sort(arr, gt+1, hi, d); //sort the array recursively on the same character index
	}
	
	public static void main(String[] args) {
		String[] arr = {"edu.princeton.cs",
						"com.apple",
						"edu.princeton.cs",
						"com.cnn",
						"com.google",
						"edu.uva.cs",
						"edu.princeton.cs",
						"edu.princeton.cs.www",
						"edu.uva.cs",
						"edu.uva.cs",
						"edu.uva.cs",
						"com.adobe",
						"edu.princeton.ee"};
		Quick3StringSort.sort(arr);
		for(String s : arr) {
			System.out.println(s);
		}
	}

}
