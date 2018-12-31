package com.thumati.ds.hashmap.linearprobing;

public class HashTable {
	private HashItem[] hashTable;
	
	public HashTable() {
		this.hashTable = new HashItem[Constants.TABLE_SIZE];
	}
	
	public void put(int key, int value) {
		int generatedIndex = hashFunction(key);
		System.out.println("put() method called with value : "+value+" - generatedIndex:"+generatedIndex);
		while(hashTable[generatedIndex]!=null) {
			generatedIndex = (generatedIndex+1)%Constants.TABLE_SIZE;
			System.out.println("Collision -> nextIndex:"+generatedIndex);
		}
		System.out.println("Inserted finally with index:"+generatedIndex);
		hashTable[generatedIndex]=new HashItem(key, value);
	}
	
	public int get(int key) {
		int generatedIndex = hashFunction(key);
		HashItem hashItem = hashTable[generatedIndex];
		while(hashItem!=null && key!=hashItem.getKey()) {
			generatedIndex = (generatedIndex+1)%Constants.TABLE_SIZE;
			hashItem = hashTable[generatedIndex];
			System.out.println("Hopping to the next index : "+generatedIndex);
		}
		return hashItem!=null?hashItem.getValue():-1;
	}
	
	private int hashFunction(int key) {
		return key % Constants.TABLE_SIZE;
		//return 1;
	}
}
