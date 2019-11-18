package profiling;

import java.util.Arrays;

public class ArraysGenerator {
	public void print(int[] arr) {
		System.out.println(Arrays.toString(arr));
	}

	public int[] randomArray(int elements) {
		int[] arr = new int[elements];
		for (int i = 0; i < elements; i++) {
			arr[i] = (int) (Math.random() * 100000);
		}
		return arr;
	}
}
