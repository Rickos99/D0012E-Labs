package lab1;

import java.util.*;

public class MergeSort {
	public static void main(String[] args){
		int[] input = {2, 1, 4, 3, 7, 6, 4, 2, 3, 4, 3};
		int k = 2;
		sort(input, k);
	}
	public static int[] sort(int[] input, int k) {

		int len = input.length;
		System.out.println(len);
		int counter = 0;
		int[][] newArray = new int[len/k + 1][k];
		
		//Delar upp så många delar den kan i k stora subarrays som läggs in i
		// en array av arrays
		for (int i = 0; i <= len - k; i += k) {
		    newArray[counter++] = Arrays.copyOfRange(input, i, i + k);
		}
		
		//Om vi har rest så lägger vi till den i en mindre subarray och lägger in
		// i array-arrayen
		if (len % k != 0)
			System.out.println(counter);
		    newArray[counter] = Arrays.copyOfRange(input, len - len % k, len - 1);
		
//		for(int j = 0; j <= len/k ; j++) {
//			System.out.println("j = " + j);
//			for(int l = 0; l < k; l++) {
//				System.out.println(newArray[j][l]);
//			}
//			
//		}
		
		
		return input;
	}
// källa för delar av koden https://stackoverflow.com/questions/19237371/split-array-into-pieces-of-x-length
}
