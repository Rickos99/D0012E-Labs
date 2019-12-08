package lab2;

import java.util.Arrays;
import profiling.ArraysGenerator;
import profiling.TimeMeasure;

class HashTest {
	
	private ArraysGenerator arraysGenerator = new ArraysGenerator();;

	public static void main(String[] args) {
		HashTest test = new HashTest();

		//test.testTableOutput();
		test.testRandomInput();
		
		System.exit(0);
	}

	private void testTableOutput(){
		int capacity = 10;
		HashTableVariant hashTableVariant = new HashTableVariant(capacity);
		LinearHash linearHash = new LinearHash(capacity);
		
		final int[] inputs = arraysGenerator.randomArray(capacity + 1);
		System.out.println("Values: " + Arrays.toString(inputs));
		System.out.println("Number of values: " + inputs.length);
		for (int input : inputs) {
			linearHash.insert(input);
			hashTableVariant.insert(input);
		}
		System.out.println(linearHash.toString());
		System.out.println(hashTableVariant.toString());
	}
	
	private void testRandomInput() {
		TimeMeasure timer = new TimeMeasure();
		timer.start();

		final int[] capacities = {10, 100, 1000, 10000, 100000, 1000000};
		final int tests = 50;

		for (int capacity : capacities) {
			long linearHash_longestCollisionChain = 0;
    		long linearHash_numberOfInsertions = 0;
    		long linearHash_numberOfCollisions = 0;
    		long linearHash_numberOfOverflows = 0;
    		long linearHash_aCollisionChain = 0;
    		long linearHash_numberOfProbes = 0;
			long linearHash_numberOfHashes = 0;
			double linearHash_runningTime = 0d;
			double linearHash_loadFactor = 0d;

			long hashTableVariant_longestCollisionChain = 0;
    		long hashTableVariant_numberOfInsertions = 0;
    		long hashTableVariant_numberOfCollisions = 0;
    		long hashTableVariant_numberOfOverflows = 0;
    		long hashTableVariant_aCollisionChain = 0;
    		long hashTableVariant_numberOfProbes = 0;
			long hashTableVariant_numberOfHashes = 0;
			double hashTableVariant_runningTime = 0d;
			double hashTableVariant_loadFactor = 0d;

			
			int inputLength = 0;
			for (int i = 0; i < tests; i++) {
				System.out.print("Testing capacity " + capacity + " : Test " + i + " of " + tests +"\r");
				final int[] inputs = arraysGenerator.randomUnique(capacity + (int)(capacity/10d));
				inputLength = inputs.length;
				HashTableVariant hashTableVariant = new HashTableVariant(capacity);
				LinearHash linearHash = new LinearHash(capacity);

				for (int input : inputs) {
					linearHash.insert(input);
					hashTableVariant.insert(input);
				}

				linearHash_longestCollisionChain += linearHash.test.longestCollisionChain;
				linearHash_numberOfInsertions += linearHash.test.numberOfInsertions;
				linearHash_numberOfCollisions += linearHash.test.numberOfCollisions;
				linearHash_numberOfOverflows += linearHash.test.numberOfOverflows;
				linearHash_aCollisionChain += linearHash.test.aCollisionChain;
				linearHash_numberOfProbes += linearHash.test.numberOfProbes;
				linearHash_numberOfHashes += linearHash.test.numberOfHashes;
				linearHash_runningTime += linearHash.test.timer.getMilliSeconds();
				linearHash_loadFactor += linearHash.test.getLoadFactor();

				hashTableVariant_longestCollisionChain += hashTableVariant.test.longestCollisionChain;
				hashTableVariant_numberOfInsertions += hashTableVariant.test.numberOfInsertions;
				hashTableVariant_numberOfCollisions += hashTableVariant.test.numberOfCollisions;
				hashTableVariant_numberOfOverflows += hashTableVariant.test.numberOfOverflows;
				hashTableVariant_aCollisionChain += hashTableVariant.test.aCollisionChain;
				hashTableVariant_numberOfProbes += hashTableVariant.test.numberOfProbes;
				hashTableVariant_numberOfHashes += hashTableVariant.test.numberOfHashes;
				hashTableVariant_runningTime += hashTableVariant.test.timer.getMilliSeconds();
				hashTableVariant_loadFactor += hashTableVariant.test.getLoadFactor();

			}

			linearHash_longestCollisionChain = (int)(linearHash_longestCollisionChain/(tests*1d));
			linearHash_numberOfInsertions  = (int)(linearHash_numberOfInsertions/(tests*1d));
			linearHash_numberOfCollisions = (int)(linearHash_numberOfCollisions/(tests*1d));
			linearHash_numberOfOverflows = (int)(linearHash_numberOfOverflows/(tests*1d));
			linearHash_aCollisionChain = (int)(linearHash_aCollisionChain/(tests*1d));
			linearHash_numberOfProbes = (int)(linearHash_numberOfProbes/(tests*1d));
			linearHash_numberOfHashes = (int)(linearHash_numberOfHashes/(tests*1d));
			linearHash_runningTime = linearHash_runningTime/(tests*1d);
			linearHash_loadFactor = linearHash_loadFactor/(tests*1d);

			hashTableVariant_longestCollisionChain = (int)(hashTableVariant_longestCollisionChain/(tests*1d));
			hashTableVariant_numberOfInsertions = (int)(hashTableVariant_numberOfInsertions/(tests*1d));
			hashTableVariant_numberOfCollisions = (int)(hashTableVariant_numberOfCollisions/(tests*1d));
			hashTableVariant_numberOfOverflows = (int)(hashTableVariant_numberOfOverflows/(tests*1d));
			hashTableVariant_aCollisionChain = (int)(hashTableVariant_aCollisionChain/(tests*1d));
			hashTableVariant_numberOfProbes = (int)(hashTableVariant_numberOfProbes/(tests*1d));
			hashTableVariant_numberOfHashes = (int)(hashTableVariant_numberOfHashes/(tests*1d));
			hashTableVariant_runningTime = hashTableVariant_runningTime/(tests*1d);
			hashTableVariant_loadFactor = hashTableVariant_loadFactor/(tests*1d);

			System.out.println("--------------------- General info -------------------------");
			System.out.println("Capacity:....................... " + capacity);
			System.out.println("No. input values:............... " + inputLength);
			
			System.out.println("----------------- Test result: LinearHash ------------------");
    		System.out.println("Running time:................... " + linearHash_runningTime + "ms");
    		System.out.println("Longest collision-chain:........ " + linearHash_longestCollisionChain);
    		System.out.println("Number of collisions:........... " + linearHash_numberOfCollisions);
    		System.out.println("Number of overflows:............ " + linearHash_numberOfOverflows);
    		System.out.println("Number of probes:............... " + linearHash_numberOfProbes);
    		System.out.println("Number of hashed:............... " + linearHash_numberOfHashes);
    		System.out.println("Number of insertions:........... " + linearHash_numberOfInsertions);
			System.out.println("Load factor:.................... " + linearHash_loadFactor);
			
			System.out.println("----------------- Test result: HashVariant -----------------");
    		System.out.println("Running time:................... " + hashTableVariant_runningTime + "ms");
    		System.out.println("Longest collision-chain:........ " + hashTableVariant_longestCollisionChain);
    		System.out.println("Number of collisions:........... " + hashTableVariant_numberOfCollisions);
    		System.out.println("Number of overflows:............ " + hashTableVariant_numberOfOverflows);
    		System.out.println("Number of probes:............... " + hashTableVariant_numberOfProbes);
    		System.out.println("Number of hashed:............... " + hashTableVariant_numberOfHashes);
    		System.out.println("Number of insertions:........... " + hashTableVariant_numberOfInsertions);
			System.out.println("Load factor:.................... " + hashTableVariant_loadFactor);
			System.out.println("------------------------------------------------------------");
			System.out.println("\n\n");
		}
		timer.stop();
		double hours = roundDecimals(timer.getMilliSeconds() / (3.6* Math.pow(10, 6)));
		System.out.println("Finished in " + hours + "h");
	}

	private double roundDecimals(double value) {
		return (double)Math.round(value * 100d) / 100d;
  	}
}
