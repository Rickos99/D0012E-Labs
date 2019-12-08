package profiling;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
	
	public int[] randomReversed(int elements) {
		int[] arr = randomSorted(elements);
		for(int i=0; i<arr.length/2; i++){
			  int temp = arr[i];
			  arr[i] = arr[arr.length -i -1];
			  arr[arr.length -i -1] = temp;
			}
		return arr;
	}
	
	public int[] randomUnique(int elements) {
		List<Integer> list = new ArrayList<>(11);
		int[] arr = new int[elements];
		
		for (int i = 0; i <= elements; i++){
		    list.add(i);
		}
		for (int i = 0; i < elements; i++) {
			arr[i] = list.remove((int)(Math.random() * list.size()));
		}
		
		return arr;
	}
}
