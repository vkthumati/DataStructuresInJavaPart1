package com.thumati.ds.bst;

public class BSTApp {
	public static void main(String[] args) {
		Tree<Integer> tree = new BinarySearchTree<Integer>();
		tree.insert(100);
		tree.insert(110);
		tree.insert(90);
		tree.insert(105);
		tree.insert(85);
		tree.insert(95);
		tree.insert(115);
		
		System.out.println(tree.findMax());
		System.out.println(tree.findMin());
		System.out.println("Inorder Traversal .........................");
		tree.traverse();
		
		
		Tree<Integer> tree1 = new BinarySearchTree<>();
		tree1.insert(2);
		tree1.insert(55);
		tree1.insert(67);
		tree1.insert(12);
		tree1.insert(11);
		
		Tree<Integer> tree2 = new BinarySearchTree<>();
		tree2.insert(2);
		tree2.insert(55);
		tree2.insert(67);
		tree2.insert(12);
		tree2.insert(11);
		
		TreeCompareHelper<Integer> compare = new TreeCompareHelper<>();
		System.out.println("\n\nTree1 and Tree2 Equal : "+compare.compareTrees(tree1.getRoot(), tree2.getRoot()));
		
		Tree<Integer> bst = new BinarySearchTree<>();
		bst.insert(2);
		bst.insert(55);
		bst.insert(67);
		bst.insert(12);
		bst.insert(11);
		System.out.println("\n\nKth Smallest : "+bst.getKthSmallest(bst.getRoot(), 5));
		
		
		// O(N)   OR  O(logN)
		Tree<Person> personbst = new BinarySearchTree<>();
		personbst.insert(new Person("Adam",47));
		personbst.insert(new Person("Kevin",21));
		personbst.insert(new Person("Joe",55));
		personbst.insert(new Person("Arnold",20));
		personbst.insert(new Person("Noel",34));
		personbst.insert(new Person("Marko",68));
		personbst.insert(new Person("Susan",23));
		personbst.insert(new Person("Rose",38));
		
		System.out.println("\n\nSum of all person's ages : "+personbst.getAgesSum());
	}
}
