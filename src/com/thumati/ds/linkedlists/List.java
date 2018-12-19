package com.thumati.ds.linkedlists;

public interface List<T extends Comparable<T>> {
	public void insertAtBegin(T data);
	
	public void insertAtEnd(T data);
	
	public void removeAtBegin();
	
	public void removeAtEnd();
	
	public void remove(T data);
	
	public void traverseLinkedList();
	
	public boolean isEmpty();
	
	public int size();
	
	public Node<T> getMiddleNode();
	
	public void reverse();
}
