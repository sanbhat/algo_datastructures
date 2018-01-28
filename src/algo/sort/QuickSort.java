package algo.sort;

import java.util.Arrays;

public class QuickSort {

	public static void main(String[] args) {
		int[] arr = {3, 1, 5, 2, 4, 7, 0};
		quickSort(arr, 0, arr.length-1);
		System.out.println(Arrays.toString(arr));
	}
	
	private static void quickSort(int[] arr, int low, int high) {
		int pivot = arr[low + (high-low)/2];
		int i= low, j = high;
		while (i <= j) {
			while(arr[i] < pivot) {
				i++;
			}
			while(arr[j] > pivot) {
				j--;
			}
			
			if(i <= j) {
				swap(arr, i, j);
				i++;
				j--;
			}
		}
		if(i < high) {
			quickSort(arr, i, high);
		}
		if(j > low) {
			quickSort(arr, low, j);
		}
	}
	
	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

}
