package com.thumati.ds.queues;

public class Queues<T extends Comparable<T>> {
	// It is a space/memory friendly
	private SingleLinkedList<T> list;

	public Queues() {
		this.list = new SingleLinkedList<T>();
	}

	// O(1)
	public void enqueue(T data) {
		list.enqueue(data);
	}

	// O(1)
	public T dequeue() {
		return list.dequeue();
	}

	// O(1)
	public T peek() {
		return list.peek();
	}

	public int size() {
		return list.getSize();
	}

	public boolean isEmpty() {
		return list.isEmpty();
	}

	@Override
	public String toString() {
		return "Queues [list=" + list + "]";
	}
}
