package lab2;

class HashTableVariant {
    private int maxSize, currentSize;
    private int[] keys;

    public HashTableVariant(int capacity) {
        currentSize = 0;
        maxSize = capacity;
        keys = new int[maxSize];
    }

    private int hash(int key) {
		return key % maxSize;
    }

    private int linearProbeUp(int key, int offset){
        return (hash(key) + offset) % keys.length;
    }

    private int linearProbeDown(int key, int offset){
        return linearProbeUp(key, -offset);
    }

    public void insert(int key) {
		int i = 0;
		int home;
		do {
			home = linearProbeDown(key, i); 
			if(keys[home] == 0) {
				keys[home] = key;
				currentSize++;
				return;
			}
			if(keys[home] == key) {
				return;
			}
			i++;
		}while(home - i >= 0);
		
		i=0;
		
		do {
			home = linearProbeUp(key, i); 
			if(keys[home] == 0) {
				keys[home] = key;
				currentSize++;
				return;
			}
			if(keys[home] == key) {
				return;
			}
			i++;
		}while(i + home < maxSize);
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