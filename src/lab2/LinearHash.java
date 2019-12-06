package lab2;


class LinearHash {
	private int currentSize, maxSize;
	private int[] keys;
	private int[] offset;
	
	public LinearHash(int capacity) {
		currentSize = 0;
		maxSize = capacity;
		keys = new int[maxSize];
		offset = new int[maxSize];
	}
	private int hash(int key) {
		return key % maxSize;
    }

    private int linearProbe(int key, int offset){
        return (hash(key) + offset) % keys.length;
    }
    
	public void insert(int key) {
		int tmp = hash(key);
		int i = 0;
		int home;
		do {
			home = linearProbe(key, i); 
			if(keys[home] == 0) {
				keys[home] = key;
				offset[home] = i;
				currentSize++;
				return;
			}
			if(keys[home] == key) {
				offset[home] = i;
				return;
			}
			i = i + 1;
		}while(i + tmp != maxSize);
		System.out.println("ERROR: Hash Table overflow, key " + key);
    }
    
    public void delete(int key){
        throw new UnsupportedOperationException("The method LinearHash.delete has not been implmented yet");
    }

    public int search(int key){
        int i = hash(key);
        while(keys[i] != null) {
        	
        	if(keys[i] == key) {
        		return i;
        	}
        	i = (i + 1)%maxSize;
        }
        return null;
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
