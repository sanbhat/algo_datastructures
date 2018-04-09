package algo.sort;

import java.util.Arrays;

import org.junit.Test;

import utils.Utility;

public class SortTest {

	@Test
	public void testBubbleSort() {
		int[] arr = {5,4,3,2,1, 10, 99, 87, 6, 78, -1, -12, 100, 65, 120};
		BubbleSort bubbleSort = new BubbleSort();
		bubbleSort.sort(arr);
		Utility.isSorted(arr, true);
		System.out.println(Arrays.toString(arr));
	}
	
	@Test
	public void testSelectionSort() {
		Integer[] arr = { 2, 103, 22, -13, 5, -55, 10, 7, 4, 99, 3, -1, 0 };
		SelectionSort<Integer> selectionSort = new SelectionSort<>();
		selectionSort.sort(arr);
		Utility.isSorted(arr, true);
		System.out.println(Arrays.toString(arr));
	}
	
	@Test
	public void testInsertionSort() {
		int[] arr = {5 ,4, 3, 2, 1};
		InsertionSort sort = new InsertionSort();
		sort.sort1(arr);
		Utility.isSorted(arr, true);
		System.out.println(Arrays.toString(arr));
		
		arr =new int[] {5, 4, 1 , 3, 2};
		sort.sort2(arr);
		Utility.isSorted(arr, true);
		System.out.println(Arrays.toString(arr));
	}
	
	@Test
	public void testShellSort() {
		int[] arr = {99, 1, 10, -98, 101, 15, 7, 55, -48, 75, 0, -11, -12, 88, 9, 6, 3, 2, 101, 1002, -999, 1110, 28, 17, 43, 35, 87};
		ShellSort sort = new ShellSort();
		sort.sort(arr);
		Utility.isSorted(arr, true);
		System.out.println(Arrays.toString(arr));
	}
	
	@Test
	public void testMergeSort() {
		int[] arr = {1, 99, 17, 65, 767, 3, -22, -87, 6, 101, 12, 5, 152, 80, -33, 100, 2, 75, -10, 7, 999, -2, -4 };
		MergeSort sort = new MergeSort();
		sort.sort(arr);
		Utility.isSorted(arr, true);
		System.out.println(Arrays.toString(arr));
	}
	
	@Test
	public void testQuickSort() {
		Integer[] arr = {99, 1, 10, -98, 101, 15, 7, 55, -48, 75, 0, -11, -12, 88, 9, 6, 3, 2, 101, 1002, -999, 1110, 28, 17, 43, 35, 87};
		QuickSort<Integer> quickSort = new QuickSort<>();
		quickSort.sort(arr);
		Utility.isSorted(arr, true);
		System.out.println(Arrays.toString(arr));
	}
	
	@Test
	public void testHeapSort() {
		int[] arr = {99, 1, 10, -98, 101, 15, 7, 55, -48, 75, 0, -11, -12, 88, 9, -1};
		HeapSort heapSort = new HeapSort();
		heapSort.sort(arr);
		Utility.isSorted(arr, true);
		System.out.println(Arrays.toString(arr));
	}
}
