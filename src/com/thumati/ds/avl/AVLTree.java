package com.thumati.ds.avl;

public class AVLTree implements Tree{
	private Node root;
	
	@Override
	public void insert(int data) {
		this.root = insert(root, data);
	}
	
	private Node insert(Node node, int data) {
		if(node==null)
			return new Node(data);
		
		if(data <=node.getData())
			node.setLeft( insert(node.getLeft(), data) );
		else
			node.setRight( insert(node.getRight(), data) );
		
		node.setHeight( Math.max(height(node.getLeft()), height(node.getRight())) +1);
		
		node = settleViolations(data, node);
		
		return node;
	}

	private Node settleViolations(int data, Node node) {
		int balance = getBalance(node);
		
		//doubly-left heavy situation/left-left heavy(Case I)
		if(balance>1 && data<node.getLeft().getData()) {
			return rightRotation(node);
		}
		
		//doubly-right/right-right heavy situation(Case II)
		if(balance<-1 && data>node.getRight().getData()) {
			return leftRotation(node);
		}
		
		//left and right rotations(Case III)
		if(balance>1 && data>node.getLeft().getData()) {
			node.setLeft(leftRotation(node.getLeft()));
			return rightRotation(node);
		}
		
		//right and left rotations(Case IV)
		if(balance<-1 && data<node.getRight().getData()) {
			node.setRight(rightRotation(node.getRight()));
			return leftRotation(node);
		}
		
		return node;
	}

	@Override
	public void inOrderTraversal() {
		if(root==null) return;
		inOrderTraversal(root);
	}

	public void inOrderTraversal(Node node) {
		if(node!=null) {
			inOrderTraversal(node.getLeft());
			System.out.println(node.getData());
			inOrderTraversal(node.getRight());
		}
	}
	
	private int height(Node node) {
		if(node==null) return -1;
		return node.getHeight();
	}
	
	private int getBalance(Node node) {
		if(node==null) return 0;
		return height(node.getLeft()) - height(node.getRight());
	}
	
	private Node rightRotation(Node node) {
		System.out.println("Rotating to the right on the node : "+node);
		Node tempLeftNode = node.getLeft();
		Node tempNode = tempLeftNode.getRight();
		tempLeftNode.setRight(node);
		node.setLeft(tempNode);
		
		node.setHeight(Math.max(height(node.getLeft()), height(node.getRight()))+1);
		tempLeftNode.setHeight(Math.max(height(tempLeftNode.getLeft()), height(tempLeftNode.getRight()))+1);
		
		return tempLeftNode;
	}
	
	private Node leftRotation(Node node) {
		System.out.println("Rotating to the left on the node : "+node);
		Node tempRightNode = node.getRight();
		Node tempNode = tempRightNode.getLeft();
		tempRightNode.setLeft(node);
		node.setRight(tempNode);
		
		node.setHeight(Math.max(height(node.getLeft()), height(node.getRight()))+1);
		tempRightNode.setHeight(Math.max(height(tempRightNode.getLeft()), height(tempRightNode.getRight()))+1);
		
		return tempRightNode;
	}
}
