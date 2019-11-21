package lab1;

import java.util.Arrays;

import profiling.ArraysGenerator;

public class bSort {

	/**
	 * Search for a integer in a given array.
	 * (<a href="https://www.geeksforgeeks.org/binary-search/">Source</a>)
	 * 
	 * @param arr array to search
	 * @param l   left boundary
	 * @param r   right boundary
	 * @param x   integer to find index of in array
	 * @return index of value in arr, if not found -1
	 */
	private static int binarySearch(int[] arr, int l, int r, int x) {
		if (r >= l) {
			int mid = l + (r - l) / 2;

			// If the element is present at the
			// middle itself
			if (arr[mid] == x)
				return mid;

			// If element is smaller than mid, then
			// it can only be present in left subarray
			if (arr[mid] > x)
				return binarySearch(arr, l, mid - 1, x);

			// Else the element can only be present
			// in right subarray
			return binarySearch(arr, mid + 1, r, x);
		}

		// We reach here when element is not present
		// in array
		return -1;
	}

	public static void main(String[] args) {
//		int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 67, 89, 90, 91, 92, 99, 100 };
//		System.out.println(binarySearch(arr, 0, arr.length, 67));
		int[] arr = new ArraysGenerator().randomArray(5);
		System.out.println(Arrays.toString(sort(arr)));
	}

	public static int[] sort(int[] input) {
		int n = input.length;
		for (int i = 0; i < n; ++i) {
			int key = input[i];
			int index = binarySearch(input, 0, i, key);
			
//			for (int j = i; j > index; j--) {
//				input[j + 1] = input[j];
//			}
//			input[index] = key;
//			Shift all elements in array
//			Current state: not working!
		}

		return input;
	}
}
