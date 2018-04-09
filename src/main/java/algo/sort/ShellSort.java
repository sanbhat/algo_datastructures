package algo.sort;

import utils.Utility;

/**
 * <b>Shell sort</b> is an efficient sorting algorithm, which internally uses
 * <b>Insertion sort</b> technique to sort elements. The main difference between
 * Shell and Insertion sort is that, in Shell sort, instead of moving adjacent items, items
 * which are far apart are swapped, making it more efficient.
 * <p>
 * Shell sort creates <code>h</code>-sorted sequence, which are <code>h</code> subsequences within the main array, sorted in
 * their own. Speed of the sorting algorithm also depends on which formula we use to choose the sequence (h interleaved elements).
 * Different sequence formulas are present in <a href="<a https://en.wikipedia.org/wiki/Shellsort#Gap_sequences">Shellsort</a> wiki.
 * <p>
 * The sequence we will be using here is <code>h = 3h+1</code> which produces <code>1, 4, 13, 40, 121, 364, 1093, ...</code>, as 
 * referred in "Algorithms 4th edition" book.
 * 
 * @author santhosh
 *
 */
public class ShellSort {

	public void sort(int[] arr) {
		int n = arr.length;
		int h = 1;
		while(h <= n) {
			h = (3 * h) + 1;
		}
		while(h >= 1) {
			for(int i=h; i<n; i++) {
				for(int j=i; j>=h && arr[j] < arr[j-1]; j-=h) {
					Utility.swap(arr, j, j-1);
				}
			}
			h = h/3;
		}
	}
	
}
