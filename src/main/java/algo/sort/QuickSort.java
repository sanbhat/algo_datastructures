package algo.sort;

import utils.Utility;

/**
 * <b>QuickSort</b> is one of the most fastest sorting algorithms and works very well on
 * wide variety of input arrays. The speciality of this algorithm is that, it sorts in-place or 
 * with the use of small auxiliary stack and its time complexity for average case is <code>O ( n log n)</code>.
 * <p>
 * <b>QuickSort</b> too is divide and conquer based algorithm (like <b>Merge Sort</b>) and it is 
 * complementary of Merge sort, which divides the array into sub-arrays and then
 * sorts them independently. Here when the sub-arrays are sorted, its like the whole array is in order.
 * 
 * @author santhosh
 *
 * @param <T>
 */
public class QuickSort<T extends Comparable<T>> {

	public void sort(T[] arr) {
		quickSort(arr, 0, arr.length-1);
	}

	private void quickSort(T[] arr, int low, int high) {
		if(high <= low) return;
		int pivot = partition(arr, low, high);
		quickSort(arr, low, pivot-1);
		quickSort(arr, pivot+1, high);
	}

	private int partition(T[] arr, int low, int high) {
		int i = low, j=high+1;
		T pivot = arr[low];
		while(true) {
			while(Utility.isLess(arr[++i], pivot))
				if(i == high)
					break;
			while(Utility.isGreater(arr[--j], pivot))
				if(j == low)
					break;
			if(i >= j) {
				break;
			}
			Utility.swap(arr, i, j);
		}
		Utility.swap(arr, low, j);
		return j;
	}
	
}
