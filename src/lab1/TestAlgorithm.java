package lab1;

import profiling.ArraysGenerator;
import profiling.TimeMeasure;

public class TestAlgorithm {

	public static void main(String[] args) {

		TimeMeasure timer = new TimeMeasure();
		ArraysGenerator arrayGenerator = new ArraysGenerator();
		int[] arr = arrayGenerator.randomArray(10000);

		// Test insertionSort and measure execution time
		timer.start();
		InsertionSort.sort(arr);
		timer.stop();
		System.out.println(timer.toString());
	}
}
