package com.thumati.ds.stacks;

//It is not a space/memory friendly
public class Stacks<T extends Comparable<T>> {
	//It is a space/memory friendly
	private SingleLinkedList<T> list;
	
	public Stacks() {
		this.list = new SingleLinkedList<T>();
	}
	
	//O(1)
	public void push(T data) {
		list.push(data);
	}
	
	//O(1)
	public T pop() {
		return list.pop();
	}
	
	//O(1)
	public T peek() {
		return list.peek();
	}
	
	public int size(){
		return list.getSize();
	}
	
	public boolean isEmpty() {
		return list.isEmpty();
	}

	@Override
	public String toString() {
		return "Stacks [list=" + list + "]";
	}
}
