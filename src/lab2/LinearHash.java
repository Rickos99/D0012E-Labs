package lab2;

import profiling.TestCaseForHashTable;

class LinearHash {
	private int maxSize;
	private int[] keys;

	protected TestCaseForHashTable test;
	
	public LinearHash(int capacity) {
		maxSize = capacity;
		keys = new int[maxSize];

		test = new TestCaseForHashTable(maxSize, "LinearHash");
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
		int tmp = hash(key);
		int i = 0;
		do {
			int home = linearProbe(key, i);
			test.numberOfProbes++;
			if(keys[home] == 0) {
				keys[home] = key;
				test.numberOfInsertions++;
				test.endInsertion();
				return;
			}
			i++;
			test.aCollisionChain++;
    		test.numberOfCollisions++;
		}while(i + tmp < maxSize);
		test.numberOfOverflows++;
		test.endInsertion();
    }
    
    @Override
    public String toString() {
    	String res = "Content in HashTable\n";
    	for (int i = 0; i < keys.length; i++) {
			int key = keys[i];
			res += "[" + i +"] : " + key + "\n";
		}
    	return res;
    }
}
