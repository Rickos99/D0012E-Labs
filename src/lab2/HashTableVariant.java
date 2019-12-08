package lab2;

class HashTableVariant {
    private int maxSize;
    private int[] keys;
    
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
    }

    private int hash(int key) {
		return key % maxSize;
    }

    private int linearProbe(int key, int offset){
        return (hash(key) + offset) % keys.length;
    }

    public void insert(int key) {
		int home = hash(key);
		if(keys[home] == 0) {
			keys[home] = key;
			return;
		} else if (keys[home] == key) {
			return;
		}
		
		if(keyCounter[home][0] <= keyCounter[home][1]) {
			insertDown(key, home);
		} else {
			insertUp(key, home);
		}
    }
    
    private void insertUp(int key, int home) {
    	int address, i = 0;
    	do {
			address = linearProbe(key, i); 
			if(keys[address] == 0) {
				keys[address] = key;
				keyCounter[home][1] = keyCounter[home][1] + 1;
				return;
			}
			if(keys[address] == key) {
				return;
			}
			i++;
		}while( address + 1 < maxSize);
    	displayTableOverflowMessage(key);
    }
    
    private void insertDown(int key, int home) {
    	int address, i = 0;
    	do {
			address = linearProbe(key, i); 
			if(keys[address] == 0) {
				keys[address] = key;
				keyCounter[home][0] = keyCounter[home][0] + 1;
				return;
			}
			if(keys[address] == key) {
				return;
			}
			i--;
		}while( address - 1 >= 0);
    	displayTableOverflowMessage(key);
    }
    private void displayTableOverflowMessage(int key) {
    	System.out.println("ERROR: Hash Table V2 overflow, key " + key);
    }
    
    public void delete(int key){
        throw new UnsupportedOperationException("The method HashTableVariant.delete has not been implmented yet");
    }

    public void search(int key){
        throw new UnsupportedOperationException("The method HashTableVariant.delete has not been implmented yet");
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