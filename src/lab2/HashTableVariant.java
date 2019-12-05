package lab2;

class HashTable {
    private int maxSize, currentSize;
    private int[] keys;
    private int[] offset;

    public HashTable(int capacity) {
        currentSize = 0;
        maxSize = capacity;
        keys = new int[maxSize];
        offset = new int[maxSize];
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
        throw new UnsupportedOperationException("The method HashTableVariant.insert has not been implmented yet");
    }
    
    public void delete(int key){
        throw new UnsupportedOperationException("The method HashTableVariant.delete has not been implmented yet");
    }

    public void search(int key){
        throw new UnsupportedOperationException("The method HashTableVariant.delete has not been implmented yet");
    }
}