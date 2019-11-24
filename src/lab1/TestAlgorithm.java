package lab1;

import java.util.Arrays;
import java.util.Iterator;

import profiling.ArraysGenerator;
import profiling.TimeMeasure;

public class TestAlgorithm {

	public static void main(String[] args) {
		final int tests = 10;
		final int subArrayLength = 5;
		final int[] dataLengths = {10,100,1000,10000,50000, 100000};
		
		testMergeAlgorithms(tests, dataLengths, subArrayLength);
		testSortAlgorithms(tests, dataLengths);
	}
	
	public static void testMergeAlgorithms(int tests, int[] dataLengths, int subArrayLength) {
		TimeMeasure timer = new TimeMeasure();
		ArraysGenerator arrayGenerator = new ArraysGenerator();
		
		for (int dataLength : dataLengths) {
			double[] execInsertionSort = new double[tests];
			double[] execBSort = new double[tests];

			for (int i = 0; i < tests; i++) {
				final int[] arr = arrayGenerator.randomArray(dataLength);
				int[] arrCopy;
				
				arrCopy = Arrays.copyOf(arr, arr.length);
				timer.reset();
				
				// Test insertionSort and measure execution time
				timer.start();
				MergeSort.sort(arrCopy, subArrayLength);
				timer.stop();
				execInsertionSort[i] = timer.getMilliSeconds();
				
				timer.reset();
				arrCopy = Arrays.copyOf(arr, arr.length);

				// Test bSort and measure execution time
				timer.start();
				MergebSort.sort(arrCopy, subArrayLength);
				timer.stop();
				execBSort[i] = timer.getMilliSeconds();
			}

			System.out.println("New Test");
			System.out.println("n:" + dataLength +  ", k:" + subArrayLength);
			System.out.println("Merge insertionSort: " + roundTwoDecimals(average(execInsertionSort)) + " ms");
			System.out.println("Merge bSort:         " + roundTwoDecimals(average(execBSort)) + " ms");
			System.out.println("");
		}
	}

	public static void testSortAlgorithms(int tests, int[] dataLengths) {
		TimeMeasure timer = new TimeMeasure();
		ArraysGenerator arrayGenerator = new ArraysGenerator();
		
		for (int dataLength : dataLengths) {
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

			System.out.println("New Test");
			System.out.println("n:" + dataLength);
			System.out.println("insertionSort: " + roundTwoDecimals(average(execInsertionSort)) + " ms");
			System.out.println("bSort:         " + roundTwoDecimals(average(execBSort)) + " ms");
			System.out.println("");
		}
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
