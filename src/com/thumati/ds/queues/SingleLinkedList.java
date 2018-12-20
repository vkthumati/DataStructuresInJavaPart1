package com.thumati.ds.queues;

public class SingleLinkedList<T extends Comparable<T>> implements LinkedList<T>{
	private Node<T> root;
	private Node<T> tail;
	private int size;
	
	@Override
	public void enqueue(T data) {
		Node<T> newNode = new Node<T>(data);
		++size;
		if(isEmpty()) {
			root = newNode;
			tail = newNode;
			return;
		}
		tail.setNext(newNode);
		tail = newNode;
	}

	@Override
	public T dequeue() {
		T data = null;
		if(!isEmpty()) {
			--size;
			Node<T> dequeuedNode = root;
			root = root.getNext();
			dequeuedNode.setNext(null);
			data = dequeuedNode.getData();
		}
		return data;
	}

	@Override
	public T peek() {
		return !isEmpty()?root.getData():null;
	}

	@Override
	public int getSize() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return root==null;
	}

	@Override
	public String toString() {
		return "SingleLinkedList [root=" + root + ", size=" + size + "]";
	}
}
