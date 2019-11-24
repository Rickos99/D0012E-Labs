package lab1;

import java.util.Arrays;

import profiling.ArraysGenerator;
import profiling.TimeMeasure;

public class TestAlgorithm {

	public static void main(String[] args) {
//		testMergeAlgorithms();
		testSortAlgorithms();
	}
	
	public static void testMergeAlgorithms() {
		
	}

	public static void testSortAlgorithms() {
		TimeMeasure timer = new TimeMeasure();
		ArraysGenerator arrayGenerator = new ArraysGenerator();
		
		final int tests = 100;
		final int dataLength = 80000;
		
		double[] execInsertionSort = new double[tests];
		double[] execBSort = new double[tests];

		for (int i = 0; i < tests; i++) {
			final int[] arr = arrayGenerator.randomArray(dataLength);
			int[] arrCopy;
			
			arrCopy = Arrays.copyOf(arr, arr.length);
			timer.reset();
			
			// Test insertionSort and measure execution time
			timer.start();
			InsertionSort.sort(arrCopy);
			timer.stop();
			execInsertionSort[i] = timer.getMilliSeconds();
			
			timer.reset();
			arrCopy = Arrays.copyOf(arr, arr.length);

			// Test bSort and measure execution time
			timer.start();
			bSort.sort(arrCopy);
			timer.stop();
			execBSort[i] = timer.getMilliSeconds();
		}

		System.out.println("insertionSort: " + roundTwoDecimals(average(execInsertionSort)) + " ms");
		System.out.println("bSort: " + roundTwoDecimals(average(execBSort)) + " ms");
	}
	
	private static double roundTwoDecimals(double value) {
		return (double)Math.round(value * 100d) / 100d;
	}
	
	private static double average(double[] values) {
		double sum = 0;
		for (double value : values) {
			sum += value;
		}
		return sum/values.length;
	}
}
