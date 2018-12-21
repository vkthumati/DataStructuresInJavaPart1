package com.thumati.ds.bst;

public interface Tree<T extends Comparable<T>> {
	public Node<T> getRoot();
	public void insert(T data);
	public void insertNode(T data);
	public void delete(T data);
	public void traverse();
	public T findMax();
	public T findMin();
	public Node<T> getKthSmallest(Node<T> node, int k);
	public int getAgesSum();
}
