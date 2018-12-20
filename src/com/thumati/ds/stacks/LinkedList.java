package com.thumati.ds.stacks;

public interface LinkedList<T extends Comparable<T>> {
	public void push(T data);
	public T pop();
	public T peek();
	public int getSize();
	public boolean isEmpty();
}
