package com.thumati.ds.avl;

public class AVLTree implements Tree {
	private Node root;

	@Override
	public void insert(int data) {
		this.root = insert(root, data);
	}

	@Override
	public void inOrderTraversal() {
		if (root == null)
			return;
		inOrderTraversal(root);
	}

	@Override
	public void delete(int data) {
		root = delete(root, data);

	}

	private Node delete(Node node, int data) {
		if (node == null)
			return node;

		// first we have to look for the node we want to get rid of
		if (data < node.getData()){ 
			// data smaller than given node's data -> go to the left recursively
			node.setLeft(delete(node.getLeft(), data));
		} else if (data > node.getData()) { // data greater than given node's data -> go to the right recursively
			node.setRight(delete(node.getRight(), data));
		} else { // we have found the node we want to remove !!!

			if (node.getLeft() == null && node.getRight() == null) {
				System.out.println("Removing a leaf node...");
				return null;
			}

			if (node.getLeft() == null) {
				System.out.println("Removing the right child...");
				Node tempNode = node.getRight();
				node = null;
				return tempNode;
			} else if (node.getRight() == null) {
				System.out.println("Removing the left child...");
				Node tempNode = node.getLeft();
				node = null;
				return tempNode;
			}

			// this is the node with two children case !!!
			System.out.println("Removing item with two children...");
			Node tempNode = getPredecessor(node.getLeft());

			node.setData(tempNode.getData());
			node.setLeft(delete(node.getLeft(), tempNode.getData()));
		}

		node.setHeight(Math.max(height(node.getLeft()), height(node.getRight())) + 1);

		// have to check on every delete operation whether the tree has become
		// unbalanced or not !!!
		return settleDeletion(node);
	}

	private Node settleDeletion(Node node) {

		int balance = getBalance(node);

		// OK, we know the tree is left heavy BUT it can be left-right heavy or
		// left-left heavy
		if (balance > 1) {

			// left right heavy situation: left rotation on parent + right rotation on
			// grandparent
			if (getBalance(node.getLeft()) < 0) {
				node.setLeft(leftRotation(node.getLeft()));
			}

			// this is the right rotation on grandparent ( if left-left heavy, thats single
			// right rotation is needed
			return rightRotation(node);
		}

		// OK, we know the tree is right heavy BUT it can be left-right heavy or
		// right-right heavy
		if (balance < -1) {
			// right - left heavy so we need a right rotation ( on parent!!! ) before left
			// rotation
			if (getBalance(node.getRight()) > 0) {
				node.setRight(rightRotation(node.getRight()));
			}

			// left rotation on grand parent
			return leftRotation(node);
		}

		return node;
	}

	private Node getPredecessor(Node node) {

		Node predecessor = node;

		while (predecessor.getRight() != null)
			predecessor = predecessor.getRight();

		return predecessor;
	}
	
	private Node insert(Node node, int data) {
		if (node == null)
			return new Node(data);

		if (data <= node.getData())
			node.setLeft(insert(node.getLeft(), data));
		else
			node.setRight(insert(node.getRight(), data));

		node.setHeight(Math.max(height(node.getLeft()), height(node.getRight())) + 1);

		node = settleViolations(data, node);

		return node;
	}

	private Node settleViolations(int data, Node node) {
		int balance = getBalance(node);

		// doubly-left heavy situation/left-left heavy(Case I)
		if (balance > 1 && data < node.getLeft().getData()) {
			return rightRotation(node);
		}

		// doubly-right/right-right heavy situation(Case II)
		if (balance < -1 && data > node.getRight().getData()) {
			return leftRotation(node);
		}

		// left and right rotations(Case III)
		if (balance > 1 && data > node.getLeft().getData()) {
			node.setLeft(leftRotation(node.getLeft()));
			return rightRotation(node);
		}

		// right and left rotations(Case IV)
		if (balance < -1 && data < node.getRight().getData()) {
			node.setRight(rightRotation(node.getRight()));
			return leftRotation(node);
		}

		return node;
	}

	private void inOrderTraversal(Node node) {
		if (node != null) {
			inOrderTraversal(node.getLeft());
			System.out.println(node.getData());
			inOrderTraversal(node.getRight());
		}
	}

	private int height(Node node) {
		if (node == null)
			return -1;
		return node.getHeight();
	}

	private int getBalance(Node node) {
		if (node == null)
			return 0;
		return height(node.getLeft()) - height(node.getRight());
	}

	private Node rightRotation(Node node) {
		System.out.println("Rotating to the right on the node : " + node);
		Node tempLeftNode = node.getLeft();
		Node tempNode = tempLeftNode.getRight();
		tempLeftNode.setRight(node);
		node.setLeft(tempNode);

		node.setHeight(Math.max(height(node.getLeft()), height(node.getRight())) + 1);
		tempLeftNode.setHeight(Math.max(height(tempLeftNode.getLeft()), height(tempLeftNode.getRight())) + 1);

		return tempLeftNode;
	}

	private Node leftRotation(Node node) {
		System.out.println("Rotating to the left on the node : " + node);
		Node tempRightNode = node.getRight();
		Node tempNode = tempRightNode.getLeft();
		tempRightNode.setLeft(node);
		node.setRight(tempNode);

		node.setHeight(Math.max(height(node.getLeft()), height(node.getRight())) + 1);
		tempRightNode.setHeight(Math.max(height(tempRightNode.getLeft()), height(tempRightNode.getRight())) + 1);

		return tempRightNode;
	}
}
