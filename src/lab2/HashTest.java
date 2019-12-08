package lab2;

import java.util.Arrays;

import profiling.ArraysGenerator;

class HashTest {
	
	public static void main(String[] args) {
		for (int i = 0; i < 20; i++) {			
			new HashTest().testRandomInput(10);
			//new HashTest().testSameInput(10);
		}
	}
	
	private void testSameInput(int capacity) {
		LinearHash linearHash = new LinearHash(capacity);
		HashTableVariant hashTableVariant = new HashTableVariant(capacity);
		
		final int[] inputs = {1,11,21,31,41,51,2,5};
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
	
	private void testRandomInput(int capacity) {
		ArraysGenerator arraysGenerator = new ArraysGenerator();
		LinearHash linearHash = new LinearHash(capacity);
		HashTableVariant hashTableVariant = new HashTableVariant(capacity);
		
		final int[] inputs = arraysGenerator.randomArray(capacity + 1);
		System.out.println("Values: " + Arrays.toString(inputs));
		System.out.println("Number of values: " + inputs.length);
		for (int input : inputs) {
			linearHash.insert(input);
			System.out.println("Search for " + input + " found at " + linearHash.search(input));
			hashTableVariant.insert(input);
		}
		System.out.println("Removed key " + inputs[3] + " from address " + linearHash.delete(inputs[3]));
		System.out.println(linearHash.toString());
		System.out.println(hashTableVariant.toString());
		System.out.println("---------------------------------------");
	}
}
