package lab1;

public class bSort {

	/**
	 * Search for a integer in a given array.
	 * 
	 * @param arr  array to search
	 * @param low  left boundary
	 * @param high right boundary
	 * @param key  integer to find index of in array
	 * @return index of value in arr, if not found -1
	 */
	private static int binarySearch(int[] arr, int low, int high, int key) {
		int mid;

		if (low == high) {
			return low;
		}

		mid = low + ((high - low) / 2);

		if (key > arr[mid]) {
			return binarySearch(arr, mid + 1, high, key);
		} else if (key < arr[mid]) {
			return binarySearch(arr, low, mid, key);
		}

		return mid;
	}

	public static int[] sort(int[] input) {
		int n = input.length;
		for (int i = 1; i < n; ++i) {
			int key = input[i];
			int index = binarySearch(input, 0, i, key);

			for (int j = i - 1; j >= index; j--) {
				input[j + 1] = input[j];
			}

			input[index] = key;
		}

		return input;
	}
}
