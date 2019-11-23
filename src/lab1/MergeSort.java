package lab1;

import java.util.*;

public class MergeSort {
	public static void main(String[] args){
		int[] input = {2, 4, 6};
		int[] input2= {1, 3, 5};
		int[] sorted = merge(input, input2);
		System.out.println(sorted.length);
		for (int i = 0; i < sorted.length; i++) {
			System.out.println(sorted[i]);
		}
		int k = 2;
	}
	public static int[] merge(int[] input1, int[] input2) {
		
		int[] sorted = new int[input1.length+input2.length];
		int i=0,j=0,k=0;
		
		while(i < input1.length && j < input2.length) {
			
			if (input1[i] <= input2[j]) {
				
				sorted[k] = input1[i];
				i++;
			}
			else {
				
				sorted[k] = input2[j];
				j++;
			}
			k++;
		}
		
		while(i < input1.length) {
			sorted[k] = input1[i];
			i++;
			k++;
		}
		while(k < input2.length) {
			sorted[k] = input2[j];
			j++;
			k++;
		}
		return sorted;
	}
	public static int[] sort(int[] input, int k) {

		int len = input.length;
		System.out.println(len);
		int counter = 0;
		int[][] newArray = new int[len/k + 1][k];
		
		//Delar upp så många delar den kan i k stora subarrays som läggs in i
		// en array av arrays
		for (int i = 0; i <= len - k; i += k) {
		    newArray[counter++] = InsertionSort.sort(Arrays.copyOfRange(input, i, i + k));
		}
		
		//Om vi har rest så lägger vi till den i en mindre subarray och lägger in
		// i array-arrayen
		if (len % k != 0)
			System.out.println(counter);
		    newArray[counter] = InsertionSort.sort(Arrays.copyOfRange(input, len - len % k, len - 1));
		
//		for(int j = 0; j <= len/k ; j++) {
//			System.out.println("j = " + j);
//			for(int l = 0; l < k; l++) {
//				System.out.println(newArray[j][l]);
//			}
//			
//		}
	}
// källa för delar av koden https://stackoverflow.com/questions/19237371/split-array-into-pieces-of-x-length
}
