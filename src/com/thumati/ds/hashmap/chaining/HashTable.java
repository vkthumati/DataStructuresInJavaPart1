package com.thumati.ds.hashmap.chaining;

public class HashTable {
	private HashItem[] hashTable;
	
	public HashTable() {
		this.hashTable = new HashItem[Constants.TABLE_SIZE];
	}
	
	public void put(int key, int value) {
		int hashArrayIndex = hash(key);
		
		if(hashTable[hashArrayIndex]==null) {
			hashTable[hashArrayIndex] = new HashItem(key, value);
			System.out.println("No collision simple insertions ........... ");
		}else {
			System.out.println("Collision when inserting with key : "+key);
			HashItem hashItem = hashTable[hashArrayIndex];
			while(hashItem.getNextHashItem()!=null) {
				hashItem = hashItem.getNextHashItem();
				System.out.println("Considering the next item in the linked list : "+hashItem.getValue());
			}
			System.out.println("Finally we have found the place to insert ....");
			hashItem.setNextHashItem(new HashItem(key, value));
		}
	}
	
	
	public int get(int key) {
		int hashArrayIndex = hash(key);
		
		HashItem hashItem = hashTable[hashArrayIndex];
		while(hashItem!=null && key!=hashItem.getKey()) {
			hashItem = hashItem.getNextHashItem();
		}
		
		return hashItem!=null?hashItem.getValue():-1;
	}
	
	private int hash(int key) {
		return key % Constants.TABLE_SIZE;
		//return 1;
	}
}
