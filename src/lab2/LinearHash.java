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
	public void insert(int key) {
		int tmp = hash(key);
		int i = 0;
		int home;
		do {
			home = (tmp + i)%maxSize;
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
		
	}
}
