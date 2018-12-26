package com.thumati.ds.avl;

public class App {

	public static void main(String[] args) {
		Tree tree = new AVLTree();
		
		//left-left
		/*tree.insert(3);
		tree.insert(2);
		tree.insert(1);*/
		
		//right-right
		/*tree.insert(1);
		tree.insert(2);
		tree.insert(3);*/
		
		//left-right
		/*tree.insert(3);
		tree.insert(1);
		tree.insert(2);*/
		
		//right-left
		/*tree.insert(3);
		tree.insert(5);
		tree.insert(4);*/
		
		
		tree.insert(10);
		tree.insert(20);
		tree.insert(30);
		tree.insert(40);
		tree.insert(50);
		tree.insert(60);
		
		tree.inOrderTraversal();
	}

}
