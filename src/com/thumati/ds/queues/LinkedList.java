package com.thumati.ds.queues;

public interface LinkedList<T extends Comparable<T>> {
	public void enqueue(T data);
	public T dequeue();
	public T peek();
	public int getSize();
	public boolean isEmpty();
}
