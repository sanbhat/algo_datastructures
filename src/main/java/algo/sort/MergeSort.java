package algo.sort;

/**
 * <b>Merge Sort</b> is a divide-and-conquer algorithm which divides the large input array
 * into smaller sub-arrays and sorts them independently. Finally it merges the sorted sub-arrays
 * into a large array by carefully comparing the elements within them
 * <p>
 * The only disadvantage of merge sort is that, it takes an extra space of size N (length of array),
 * called Auxiliary array, to do the final merge.
 * @author santhosh
 *
 */
public class MergeSort {
	
	//auxiliary array to assist the merge
	private int[] aux;
	
	public void sort(int[] arr) {
		this.aux = new int[arr.length];
		sort(arr, 0, arr.length-1);
	}
	
	private void sort(int[] a, int low, int high) {
		if(high <= low) return;
		int mid = low + (high - low) / 2;
		sort(a, low, mid);
		sort(a, mid+1, high);
		merge(a, low, mid, high);
	}
	
	private void merge(int[] a, int low, int mid, int high) {
		int i = low, j = mid + 1;
		for(int k=low;  k<=high; k++) {
			aux[k] = a[k];
		}
		
		for(int k=low; k<=high; k++) {
			//left side of the aux array is exhausted, copy from right
			if(i > mid) {
				a[k] = aux[j++];
			} 
			//right side of the aux array is exhausted, copy from left
			else if(j > high) {
				a[k] = aux[i++];
			} 
			//if element on the right is less than element on the left, copy the right one first
			else if(aux[j] < aux[i]) {
				a[k] = aux[j++];
			} 
			//else copy the left one first
			else {
				a[k] = aux[i++];
			}
		}
	}
	
}
