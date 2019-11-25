package lab1;

import java.util.Arrays;

import profiling.ArraysGenerator;
import profiling.TimeMeasure;

public class TestAlgorithm {

	public static void main(String[] args) {
		final int tests = 50;
		final int subArrayLength = 5;
		final int[] dataLengths = {100,1000,10000,50000, 100000};
		
		testMergeAlgorithms(tests, dataLengths, subArrayLength);
		//testSortAlgorithms(tests, dataLengths);
		
		System.out.println("Finished");
	}
	
	public static void testMergeAlgorithms(int tests, int[] dataLengths, int subArrayLength) {
		TimeMeasure timer = new TimeMeasure();
		ArraysGenerator arrayGenerator = new ArraysGenerator();
		
		for (int dataLength : dataLengths) {
			double[] execMergeInsertionSort = new double[tests];
			double[] execMergeBSort = new double[tests];
			double[] execMerge = new double[tests];

			for (int i = 0; i < tests; i++) {
				final int[] arr = arrayGenerator.randomArray(dataLength);
//				final int[] arr = arrayGenerator.randomKSorted(dataLength, 10);
//				final int[] arr = arrayGenerator.randomSorted(dataLength);
//				final int[] arr = arrayGenerator.randomReversed(dataLength);
				int[] arrCopy;
				
				arrCopy = Arrays.copyOf(arr, arr.length);
				timer.reset();
				
				// Test insertionSort and measure execution time
				timer.start();
				MergeInsSort.sort(arrCopy, subArrayLength);
				timer.stop();
				execMergeInsertionSort[i] = timer.getMilliSeconds();
				
				timer.reset();
				arrCopy = Arrays.copyOf(arr, arr.length);

				// Test bSort and measure execution time
				timer.start();
				MergebSort.sort(arrCopy, subArrayLength);
				timer.stop();
				execMergeBSort[i] = timer.getMilliSeconds();
				
				timer.reset();
				arrCopy = Arrays.copyOf(arr, arr.length);

				// Test regular merge sort and measure execution time
				timer.start();
				MergeSort.sort(arrCopy);
				timer.stop();
				execMerge[i] = timer.getMilliSeconds();
			}

			System.out.println("New Test");
			System.out.println("n:" + dataLength +  ", k:" + subArrayLength);
			System.out.println("Merge insertionSort: " + roundTwoDecimals(average(execMergeInsertionSort)) + " ms");
			System.out.println("Merge bSort:         " + roundTwoDecimals(average(execMergeBSort)) + " ms");
			System.out.println("Merge regular:       " + roundTwoDecimals(average(execMerge)) + " ms");
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
//				final int[] arr = arrayGenerator.randomKSorted(dataLength, 10);
//				final int[] arr = arrayGenerator.randomSorted(dataLength);
//				final int[] arr = arrayGenerator.randomReversed(dataLength);
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
		return (double)Math.round(value * 10000d) / 10000d;
	}
	
	private static double average(double[] values) {
		double sum = 0;
		for (double value : values) {
			sum += value;
		}
		return sum/values.length;
	}
}
