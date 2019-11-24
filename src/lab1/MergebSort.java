package lab1;

import java.util.*;

import profiling.ArraysGenerator;

public class MergebSort {
	public static void main(String[] args){
//		int[] input = { 1239, 2350, 19530 };
//		int[] input2 = { 34176, 61218, 65344, 100000};
//		System.out.println(Arrays.toString(merge(input, input2)));

		int[] arr = new ArraysGenerator().randomArray(21);
		System.out.println(Arrays.toString(arr));
		int[] sorted2 = sort(arr, 4);
		System.out.println(Arrays.toString(sorted2));
	}
	
	public static int[] sort(int[] input, int k) {
		int[][] subArrays = createSubarrays(input, k);
		int[][] merged = mergeAll(subArrays);
		return merged[0];
	}
	
	private static int[] merge(int[] input1, int[] input2) {
		int[] sorted = new int[input1.length + input2.length];
		int i = 0, j = 0, k = 0;

		while (i < input1.length && j < input2.length) {
			sorted[k++] = input1[i] <= input2[j] ? input1[i++] : input2[j++];
		}

		while (i < input1.length) {
			sorted[k++] = input1[i++];
		}

		while (j < input2.length) {
			sorted[k++] = input2[j++];
		}

		return sorted;
	}
	
	private static int[][] mergeAll(int[][] input) {
		int len = input.length;
		if (len == 1)
			return input;
		else if (len == 2) {
			if(input[0] == null) {
				return input;
			}
			else if(input[1] == null) {
				return input;
			}
			return new int[][] { merge(input[0], input[1]) };
		}
		int pointer = 0, index = 0;
		int arrays = (int) Math.ceil((double) len / 2);
		int[][] merged = new int[arrays][];
		while (pointer + 2 < len) {
			int[] in1 = input[pointer], in2 = input[pointer + 1];
			int[] tmp = merge(in1, in2);
			merged[index] = tmp;
			pointer += 2;
			index += 1;
		}
		
		// Prevent last element in merged array to be null or empty
		if (len % 2 != 0) {
			merged[arrays - 1] = input[len - 1];
		}
		return mergeAll(merged);
	}

	// källa för delar av koden https://stackoverflow.com/questions/19237371/split-array-into-pieces-of-x-length
	private static int[][] createSubarrays(int[] input, int k) {
		int len = input.length;
		int counter = 0;
		
		// skapa en extra array om antalet sublistor inte går jämt ut
		int arrays = len % k == 0 ? len/k : len/k + 1;
		int[][] newArray = new int[arrays][k];
		
		//Delar upp så många delar den kan i k stora subarrays som läggs in i
		// en array av arrays
		for (int i = 0; i <= len - k; i += k) {
		    newArray[counter++] = bSort.sort(Arrays.copyOfRange(input, i, i + k));
		}
		
		//Om vi har rest så lägger vi till den i en mindre subarray och lägger in
		// i array-arrayen
		if (len % k != 0) {
//			System.out.println(counter);
		    newArray[counter] = bSort.sort(Arrays.copyOfRange(input, len - len % k, len - 1));
		}
		
		return newArray;
	}
}
