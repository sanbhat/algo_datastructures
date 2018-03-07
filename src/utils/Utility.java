package utils;

public class Utility {

	/**
	 * Swaps the items in the array <code>arr</code> between
	 * index <code>a</code> and <code>b</code>
	 * 
	 * @param arr - Array in which the swap operation should be performed
	 * @param a - index of the element to be swapped with element at <code>b</code>
	 * @param b - index of the element to be swapped with element at <code>a</code>
	 */
	public static void swap(int[] arr, int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
	
	/**
	 * Checks whether the passed array of integers are sorted or not.
	 * @param arr - The array that needs to be checked.
	 * @param ascendingOrder - If <code>true</code> then, the sorting order to be checked 
	 * will be <b>Ascending</b>, else <b>Descending</b>.
	 * @return <code>true</code> if the array is sorted
	 * @throws RuntimeException if the array is not sorted
	 */
	public static <T extends Comparable<T>> boolean isSorted(int[] arr, boolean ascendingOrder) {
		int n = arr.length;
		String order = ascendingOrder ? "ascending" : "descending";
		if(ascendingOrder) {
			for(int i=0, j=i+1; i<n && j<n; i++, j++) {
				if(arr[i] >  arr[j]) {
					throw new RuntimeException("Array is not sorted in "+order+" order");
				}
			}
			return true;
		} else {
			for(int i=0, j=i+1; i<n && j<n; i++, j++) {
				if(arr[i] < arr[j]) {
					throw new RuntimeException("Array is not sorted in "+order+" order");
				}
			}
			return true;
		}
	}
	
	/**
	 * Swaps the items in the array <code>arr</code> between
	 * index <code>a</code> and <code>b</code>
	 * 
	 * @param arr - Array in which the swap operation should be performed
	 * @param a - index of the element to be swapped with element at <code>b</code>
	 * @param b - index of the element to be swapped with element at <code>a</code>
	 */
	public static void swap(Object[] arr, int a, int b) {
		Object temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
	
	
	/**
	 * Checks whether the passed array of {@link Comparable} objects are sorted or not.
	 * @param arr - The array that needs to be checked.
	 * @param ascendingOrder - If <code>true</code> then, the sorting order to be checked 
	 * will be <b>Ascending</b>, else <b>Descending</b>.
	 * @return <code>true</code> if the array is sorted, <code>false</code> otherwise.
	 */
	public static <T extends Comparable<T>> boolean isSorted(T[] arr, boolean ascendingOrder) {
		int n = arr.length;
		if(ascendingOrder) {
			for(int i=0, j=i+1; i<n && j<n; i++, j++) {
				if(isGreater(arr[i], arr[j])) {
					return false;
				}
			}
			return true;
		} else {
			for(int i=0, j=i+1; i<n && j<n; i++, j++) {
				if(isLess(arr[i],arr[j])) {
					return false;
				}
			}
			return true;
		}
	}
	
	/**
	 * Checks whether <code>a &lt; b</code> or not. 
	 * @param a - First argument
	 * @param b - Second argument
	 * @return <code>true</code> if first argument is less than second argument.
	 */
	public static <T extends Comparable<T>> boolean isLess(T a, T b) {
		return a.compareTo(b) < 0;
	}
	
	/**
	 * Checks whether <code>a &gt; b</code> or not. 
	 * @param a - First argument
	 * @param b - Second argument
	 * @return <code>true</code> if first argument is greater than second argument.
	 */
	public static <T extends Comparable<T>> boolean isGreater(T a, T b) {
		return a.compareTo(b) > 0;
	}
}
