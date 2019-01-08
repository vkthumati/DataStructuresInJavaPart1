package com.thumati.ds.tries;

public class Node {
	private String character;
	private int value;
	private Node[] children;
	private boolean leaf;
	private boolean visited;
	
	public Node(String character) {
		this.character= character;
		this.children = new Node[Constant.ALPHABET_SIZE];
	}
	
	public void setChild(int index, Node node) {
		node.setValue(value);
		this.children[index] = node;
	}
	
	public void setChild(int index, Node node, int value) {
		node.setValue(value);
		this.children[index] = node;
	}
	
	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public Node getChild(int index) {
		return this.children[index];
	}
	
	public String getCharacter() {
		return character;
	}

	public void setCharacter(String character) {
		this.character = character;
	}

	public Node[] getChildren() {
		return children;
	}

	public void setChildren(Node[] children) {
		this.children = children;
	}

	public boolean isLeaf() {
		return leaf;
	}

	public void setLeaf(boolean leaf) {
		this.leaf = leaf;
	}

	public boolean isVisited() {
		return visited;
	}

	public void setVisited(boolean visited) {
		this.visited = visited;
	}

	@Override
	public String toString() {
		return this.character;
	}
}
