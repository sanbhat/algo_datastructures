package algo.sort;

import java.util.Arrays;

import utils.Utility;

/**
 * <b>Heap sort</b> is another efficient sorting algorithm, based on the <b>Priority Queue</b> or
 * <b>Max (Min) Heap</b> data structure. A heap is a complete binary tree, where each node is arranged
 * such that, it is always greater than equal to its children. The root node of the tree will always be the 
 * item with highest value.
 * <p>
 * Heap sort is a comparison based, in-place sorting algorithm with average case complexity of <code>O ( n long n )</code>
 * like Quick sort, but maintains the same worst case complexity too (unlike Quick sort, which has <code>O (n ^ 2 )</code>. 
 * <p>
 * In heap sort, first the bottom most "parent" nodes (nodes with children) are processed and checked to see if they
 * satisfy the "heap" rule. Then the control is moved up the tree and same is checked. This process is called "heapifying".
 * <p>
 * Once the heapifying process is over, then the root element (element at index 0) is replaced with the last element, and
 * the cut down tree (removing the root element) is heapified. After each iteration, root is removed again and appended at
 * the end of the array. The final result of this process is sorted output array!
 * 
 * @author santhosh
 *
 */
public class HeapSort {
	
	public void sort(int [] arr) {
		
		int n = arr.length;
		
		//start with the bottom most parent and heapify them recursively.
		for(int i= n/2-1; i>=0; i--) {
			heapify(arr, n, i);
		}
		
		//start with root element (0th index item) and replace it with last, once done, heapify the remaining
		for(int i=n-1; i >= 0; i--) {
			Utility.swap(arr, 0, i);
			heapify(arr, i, 0);
		}
	}
	
	
	private void heapify(int[] arr, int n, int i) {
		int largest = i; //always assume the current parent is largest
		int l = 2 * i + 1; // left child
		int r = 2 * i + 2; // right child
		
		//if left child is greater than parent, then largest will become left child
		if(l < n && arr[l] > arr[largest]) {
			largest = l;
		}
		//if right child is greater than parent, then largest will become right child
		if(r < n && arr[r] > arr[largest]) {
			largest = r;
		}
		//if either left or right child are greater than parent, then swap them and start heapifying from the
		//new position of the parent
		if(i != largest) {
			Utility.swap(arr, largest, i);
			heapify(arr, n, largest);
		}
	}


	public static void main(String[] args) {
		int[] arr = {99, 1, 10, -98, 101, 15, 7, 55, -48, 75, 0, -11, -12, 88, 9, -1};
		HeapSort heapSort = new HeapSort();
		heapSort.sort(arr);
		Utility.isSorted(arr, true);
		System.out.println(Arrays.toString(arr));
	}

}
