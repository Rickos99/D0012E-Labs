package lab1;

import java.util.*;

public class MergeSort {
	public static void main(String[] args){
		int[] input = {2, 1, 4, 3, 7, 6, 4, 2, 3, 2, 3};
		int k = 2;
		sort(input, k);
	}
	public static int[] sort(int[] input, int k) {

		int len = input.length;
		int counter = 0;
		int[][] newArray = new int[len/k][k];
		for (int i = 0; i < len - k + 1; i += k)
		    newArray[counter++] = Arrays.copyOfRange(input, i, i + k);

		if (len % k != 0)
		    newArray[counter] = Arrays.copyOfRange(input, len - len % k, len);
		
		for(int j = 0; j < len/k; j++) {
			for(int l = 0; l < k; l++) {
				System.out.print(newArray[j][l]);
			}
			System.out.print(" ");
		}
		
		
		return input;
	}
}
