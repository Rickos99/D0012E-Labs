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
		test.numberOfProbes++;
        return (hash(key) + offset) % keys.length;
    }
    
	public void insert(int key) {
		test.beginInsertion();
		int tmp = hash(key);
		int i = 0;
		do {
			int home = linearProbe(key, i); 
			if(keys[home] == 0) {
				keys[home] = key;
				test.numberOfInsertions++;
				test.endInsertion();
				return;
			}
			if(keys[home] == key) {
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
    
//	public int delete(int key){
//    	int address = search(key);
//    	if(address == -1) {
//    		return -1;
//    	}
//    	keys[address] = 0;
//    	return address;
//    }
//
//    public int search(int key){
//        int i = hash(key);
//        while(keys[i] != 0) {
//        	if(keys[i] == key) {
//        		return i;
//        	}
//        	i = (i + 1)%maxSize;
//        }
//        return -1;
//    }
    
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
