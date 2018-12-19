package com.thumati.ds.linkedlists;

public class LinkedList<T extends Comparable<T>> implements List<T> {
	private Node<T> head;
	private Node<T> tail;
	private int size;
	
	public void insertAtBegin(T data) {
		Node<T> node = new Node<T>(data);
		if(isEmpty()) {
			this.head=node;
			this.tail=node;
			return;
		}
		node.setNext(this.head);
		this.head = node;
		++size;
	}
	
	public void insertAtEnd(T data) {
		Node<T> node = new Node<T>(data);
		if(isEmpty()) {
			this.head=node;
			this.tail=node;
			return;
		}
		this.tail.setNext(node);
		this.tail = node;
		++size;
	}
	
	public void insertAtEnd(T data, Node<T> node) {
		if(node.getNext()!=null) {
			insertAtEnd(data, node.getNext());
		}else {
			Node<T> newNode = new Node<T>(data);
			node.setNext(newNode);
			this.tail = newNode;
			++this.size;
		}
		
	}
	
	public void removeAtBegin() {
		if(isEmpty()) {
			return;
		}
		
		if(this.size==1) {
			this.head = null;
			this.tail = null;
			--this.size;
			return;
		}
		
		Node<T> nodeToRemove = this.head;
		this.head = this.head.getNext();
		nodeToRemove.setNext(null);
		--this.size;
	}
	
	public void removeAtEnd() {
		if(isEmpty()) {
			return;
		}
		
		if(size==1) {
			this.head = null;
			this.tail = null;
			--this.size;
			return;
		}
		
		Node<T> current = this.head;
		Node<T> pointer1 = current;
		Node<T> pointer2 = current;
		while(current!=null) {
			pointer1 = pointer2;
			pointer2 = current;
			current = current.getNext();
		}
		pointer1.setNext(null);
		this.tail = pointer1;
		--this.size;
	}
	
	public void remove(T data) {
		if(isEmpty()) {
			return;
		}
		
		if(this.size==1) {
			if(data.compareTo(this.head.getData())==0) {
				this.head = null;
				this.tail = null;
				--this.size;
			}
			return;
		}
		
		Node<T> current = this.head;
		Node<T> prev = current;
		while(current!=null) {
			if(data.compareTo(current.getData())==0) {
				prev.setNext(current.getNext());
				current.setNext(null);
			}else {
				prev = current;
				current = current.getNext();
			}
		}
		--this.size;
	}
	
	
	public void removeNode(T data) {
		if(this.head == null) return;
		
		--this.size;
		
		if(this.head.getData().compareTo(data)==0) {
			this.head = this.head.getNext();
			this.tail = this.tail.getNext();
		}else {
			removeNode(data, head, head.getNext());
		}
	}
	
	public void removeNode(T data, Node<T> prev, Node<T> current) {
		while(current!=null) {
			if(current.getData().compareTo(data)==0) {
				prev.setNext(current.getNext());
				current.setNext(null);
				return;
			}
			prev = current;
			current = current.getNext();
		}
	}
	
	public void traverseLinkedList() {
		Node<T> current = this.head;
		while(current!=null) {
			System.out.print(current.getData()+" -> ");
			current = current.getNext();
		}
	}
	
	public boolean isEmpty() {
		return (this.size==0);
	}
	
	public int size() {
		return 0;
	}
	
	@Override
	public Node<T> getMiddleNode() {
		if(!isEmpty()) {
			Node<T> fasterPointer = head;
			Node<T> slowerPointer = head;
			while(fasterPointer.getNext()!=null && fasterPointer.getNext().getNext()!=null) {
				fasterPointer = fasterPointer.getNext().getNext();
				slowerPointer = slowerPointer.getNext();
			}
			return slowerPointer;
		}else {	
			return null;
		}	
	}
	
	@Override
	public void reverse() {
		Node<T> prev = null;
		Node<T> next = null;
		Node<T> current = head;
		
		while(current!=null) {
			next = current.getNext();
			current.setNext(prev);
			prev = current;
			current = next;
		}

		this.tail = head;
		this.head = prev; 
	}
	
	public static void main(String[] args) {
		

	}

}
