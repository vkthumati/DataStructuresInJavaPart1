package com.thumati.ds.stacks;

public class SingleLinkedList<T extends Comparable<T>> implements LinkedList<T>{
	private Node<T> root;
	private int size;
	
	@Override
	public void push(T data) {
		Node<T> newNode = new Node<T>(data);
		++size;
		if(isEmpty()) {
			root = newNode;
			return;
		}
		newNode.setNext(root);
		root = newNode;
	}

	@Override
	public T pop() {
		T data = null;
		if(!isEmpty()) {
			--size;
			Node<T> poppedNode = root;
			root = root.getNext();
			poppedNode.setNext(null);
			data = poppedNode.getData();
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
