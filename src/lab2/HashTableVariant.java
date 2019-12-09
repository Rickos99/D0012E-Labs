package lab2;

import profiling.TestCaseForHashTable;;

class HashTableVariant {
    private int maxSize;
    private int[] keys;
    
    protected TestCaseForHashTable test;
    
    /**
     * Each element in primary array has a two value array for storing the number of keys 
     * with a address greater and lower than the home address.
     * <p>i.e the array structure is as follows:</br>
     * 	<code>[..., [l<sub>down</sub>, l<sub>up</sub>], ...]</code>
     * </p>
     */
    private int[][] keyCounter;
    
    public HashTableVariant(int capacity) {
        maxSize = capacity;
        keys = new int[maxSize];
        keyCounter = new int[maxSize][2];
        
        test = new TestCaseForHashTable(maxSize, "HashVariant");
    }

    private int hash(int key) {
    	test.numberOfHashes++;
		return key % maxSize;
    }

    private int linearProbe(int key, int offset){
        return (hash(key) + offset) % keys.length;
    }

    public void insert(int key) {
    	test.beginInsertion();
		int home = hash(key);
		test.numberOfProbes++;
		if(keys[home] == 0) {
			keys[home] = key;
			test.numberOfInsertions++;
			test.endInsertion();
			return;
		}
		
		if(keyCounter[home][0] <= keyCounter[home][1]) {
			insertDown(key, home);
		} else {
			insertUp(key, home);
		}
		test.endInsertion();
    }
    
    private void insertUp(int key, int home) {
    	int address, i = 0;
    	do {
    		test.numberOfProbes++;
			address = linearProbe(key, i);
			if(keys[address] == 0) {
				keys[address] = key;
				keyCounter[home][1] = keyCounter[home][1] + 1;
				test.numberOfInsertions++;
				return;
			}
			i++;
			test.aCollisionChain++;
    		test.numberOfCollisions++;
		}while( address + 1 < maxSize);
    	registerTableOverflow(key);
    }
    
    private void insertDown(int key, int home) {
    	int address, i = 0;
    	do {
			test.numberOfProbes++;
			address = linearProbe(key, i);
			if(keys[address] == 0) {
				keys[address] = key;
				keyCounter[home][0] = keyCounter[home][0] + 1;
				test.numberOfInsertions++;
				return;
			}
			i--;
			test.aCollisionChain++;
			test.numberOfCollisions++;
		}while( address - 1 >= 0);
    	registerTableOverflow(key);
    }
    private void registerTableOverflow(int key) {
    	test.numberOfOverflows++;
    }
    
    @Override
    public String toString() {
    	String res = "Content in HashTableVariant\n";
    	for (int i = 0; i < keys.length; i++) {
			int key = keys[i];
			res += "[" + i +"] : " + key + "\n";
		}
    	return res;
    }
}