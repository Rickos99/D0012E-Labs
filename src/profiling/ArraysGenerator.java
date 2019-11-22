package profiling;

import java.util.Arrays;

public class ArraysGenerator {

	final int numberSize = 100000;

	public void print(int[] arr) {
		System.out.println(Arrays.toString(arr));
	}

	public int[] randomArray(int elements) {
		int[] arr = new int[elements];
		for (int i = 0; i < elements; i++) {
			arr[i] = (int) (Math.random() * numberSize);
		}
		return arr;
	}

	public int[] randomKSorted(int elements, int sortedParts) {
		int[] resultArr = new int[elements];
		int elementsInEachPart = Math.round(elements / sortedParts);
		int index = 0;

		for (int i = 0; i < sortedParts; i++) {
			int[] arr = this.randomSorted(elementsInEachPart);
			for (int value : arr) {
				resultArr[index++] = value;
			}
		}

		// Fill empty spots in result array with random numbers
		while (index < elements) {
			resultArr[index++] = (int) (Math.random() * numberSize);
		}
		return resultArr;
	}
	
	public int[] randomSorted(int elements) {
		int[] arr = randomArray(elements);
		Arrays.sort(arr);
		return arr;
	}
}
