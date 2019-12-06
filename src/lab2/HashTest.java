package lab2;

import java.util.Arrays;

import profiling.ArraysGenerator;

class HashTest {
	
	public static void main(String[] args) {
		for (int i = 0; i < 20; i++) {			
			new HashTest().testRandomInput(10);
		}
	}
	
	private void testRandomInput(int capacity) {
		ArraysGenerator arraysGenerator = new ArraysGenerator();
		LinearHash linearHash = new LinearHash(capacity);
		HashTableVariant hashTableVariant = new HashTableVariant(capacity);
		
		final int[] inputs = arraysGenerator.randomArray(capacity + 1);
		System.out.println("Values: " + Arrays.toString(inputs));
		System.out.println("Number of values: " + inputs.length);
		for (int input : inputs) {
			linearHash.insert(input);
			hashTableVariant.insert(input);
		}
		System.out.println(linearHash.toString());
		System.out.println(hashTableVariant.toString());
		System.out.println("---------------------------------------");
	}
}
