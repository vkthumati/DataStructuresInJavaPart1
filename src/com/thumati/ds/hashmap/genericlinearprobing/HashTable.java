package com.thumati.ds.hashmap.genericlinearprobing;

@SuppressWarnings("unchecked")
public class HashTable<K, V> {
	private K[] keys;
	private V[] values;
	private int noOfItems;
	private int capacity;//It is the maximum no of items that can be inserted in the table:noOfItems<=capacity
	
	public HashTable() {
		this.keys = (K[])new Object[Constants.TABLE_SIZE];
		this.values = (V[]) new Object[Constants.TABLE_SIZE];
		this.capacity = Constants.TABLE_SIZE;
		this.noOfItems=0;
	}
	// have to define a different constructor because when we resize the table we use it !!!
	public HashTable(int initialCapacity) {
		this.keys = (K[])new Object[initialCapacity];
		this.values = (V[]) new Object[initialCapacity];
		this.capacity=initialCapacity;
		this.noOfItems=0;
	}
	
	//O(1)
	public int size() {
		return noOfItems;
	}
	
	//O(1)
	public boolean isEmpty() {
		return noOfItems==0;
	}
	
	public void put(K key, V value) {
		if(key==null || value==null) return;
		
		// load balance is 0.75: so when the table is 75% full we resize it --> double its size
		// why? when it is nearly empty --> we waste a lot of memory for no reason
		// when it is nearly full --> there will be lots of collisions --> O(1) will reduce to O(N) or something like that
		if(noOfItems >= capacity * 0.75) { //O(1) -> O(N)
			System.out.println("Doubling the size of the HashTable .....");
			resize(2*capacity);
		}
		
		int index = hashFunction(key);
		
		// maybe there is a collision and there is already an item inserted to that given index, so we have to
		// find an empty slot --> hence the condition != null
		while(keys[index]!=null) {
			// update section: we update the value when the keys are equal
			if(key.equals(keys[index])) {
				values[index]=value;
				return;
			}
		}
		// we have managed to found the array index where we can insert the value --> so update accordingly !!!
		keys[index]=key;
		values[index]=value;
		++noOfItems;
	}
	
	//O(N) conclusion:we have to make sure we minimize the number of resize operations
	private void resize(int newCapacity) {
		HashTable<K, V> newHashTable = new HashTable<K, V>(newCapacity);
		
		for(int i=0; i<capacity; ++i) {
			if(keys[i]!=null)
				newHashTable.put(keys[i], values[i]);
		}
		
		this.keys = newHashTable.keys;
		this.values = newHashTable.values;
		this.capacity=newCapacity;
	}

	public V get(K key) {
		if(key==null) return null;
		
		// we have to calculate an array index from the key !!!
		int index = hashFunction(key);
		
		// we have to consider the items right after each other because the item could have been shifted down
		// because of the linear probing
		while(keys[index]!=null) {
			if(key.equals(keys[index]))
				return values[index];
			// have to check the next slot or array bucket
			index = (index+1) % capacity;
		}
		
		// search miss: no value with the given key
		return null;
	}
	
	private int hashFunction(K key) {
		return Math.abs(key.hashCode()) % capacity;
		//return 1;
	}
	
	public void remove(K key) {
		if(key==null) return;
		
		int index = hashFunction(key); 
		
		// first we have to find the item we want to get rid of
		while(!key.equals(keys[index])) {
			index = (index+1)%capacity;
		}
		
		// we delete the item: the key + the value
		keys[index]=null;
		values[index]=null;
		
		// we have to reconstruct the table starting from the item deleted: there is a "hole" in the table,
		// the get() method will not work properly otherwise
		index = (index+1) % capacity;
		
		while( keys[index] != null ) {
			
			K tempKey = keys[index];
			V tempValue = values[index];
			
			keys[index] = null;
			values[index] = null;

			// we have to decrement the size, because with the put() method it will be increased again
			// so it will be fine !!!
			noOfItems--;
			put(tempKey, tempValue);
			
			index = (index+1) % capacity;
		}
		
		noOfItems--;
		
		if( noOfItems <= capacity/3 )
			resize(capacity/2);
	}
}
