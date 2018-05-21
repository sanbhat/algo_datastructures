package algo.sort.string;

import utils.Utility;

public class MSDSort {

	private static final int R = 256; // radix - total number of distinct characters
	private static final int M = 0; //threshold for sub-arrays, after which we will use insertion sort
	
	private static String[] aux;
	
	public static void sort(String[] arr) {
		aux = new String[arr.length];
		sort(arr, 0, arr.length-1, 0);
	}
	
	private static int charAt(String s, int d) {
		return d < s.length() ? s.charAt(d) : -1;
	}
	
	private static void sort(String[] arr, int lo, int hi, int d) {
		if(hi <= lo + M) {
			Insertion.sort(arr, lo, hi, d);
			return;
		}
		
		int[] count = new int[R+2];
		
		for(int i=lo; i<=hi; i++) {
			count[charAt(arr[i],d) + 2] ++;
		}
		
		for(int r=0; r<R+1; r++) {
			count[r+1] += count[r];
		}
		
		for(int i=lo; i<=hi; i++) {
			aux[count[charAt(arr[i],d) +1]++] = arr[i];  
		}
		
		for(int i=lo; i<=hi; i++) {
			arr[i] = aux[i -lo];
		}
		
		for(int r=0; r<R; r++) {
			sort(arr, lo + count[r], lo + count[r+1] - 1,  d+1);
		}
		
	}
	
	static class Insertion {
		
		static void sort(String[] arr, int lo, int hi, int d) {
			for (int i = lo; i <= hi; i++) {
				for (int j = i; j > lo && less(arr[j], arr[j-1], d); j--) {
					Utility.swap(arr, j, j-1);
				}
			}
		}
		
		private static boolean less(String v, String w, int d) { 
			return v.substring(d).compareTo(w.substring(d)) < 0; 
		}
	}
	
	public static void main(String[] args) {
		String[] arr = {"she"
				,"sells"
				,"seashells"
				,"by"
				,"the"
				,"seashore"
				,"the"
				,"shells"
				,"she"
				,"sells"
				,"are"
				,"surely"
				,"seashells"};
		MSDSort.sort(arr);
		for(String s : arr) {
			System.out.println(s);
		}
	}
}
