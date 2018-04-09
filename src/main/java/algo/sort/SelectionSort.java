package algo.sort;

import utils.Utility;

/**
 * In <b>Selection Sort</b> we start with first element of the array and replace it with
 * the smallest element in the array. If the smallest element is the first element, then first element
 * is replaced with itself.
 * <p>
 * Then, we move to the second element and we will replace it with the next smallest element in the array and so on...
 * 
 * @author santhosh
 *
 */
public class SelectionSort<T extends Comparable<T>> {

	public void sort(T[] arr) {
		int N = arr.length;
		
		for(int i=0; i<N; i++) {
			int min = i;
			for(int j=i+1; j<N; j++) {
				if(Utility.isLess(arr[j], arr[min])) {
					min = j;
				}
			}
			Utility.swap(arr, i, min);
		}
	}
	
}
