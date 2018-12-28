package com.thumati.ds.bst;

public class BinarySearchTree<T extends Comparable<T>> implements Tree<T>{
	private Node<T> root;
	
	@Override
	public void insert(T data) {
		Node<T> newNode = new Node<T>(data);
		if(root==null) {
			root = newNode;
		}else {
			Node<T> current = root;
			Node<T> parent = current;
			boolean isLeftNode = false;
			while(current!=null) {
				parent = current;
				if(data.compareTo(current.getData()) <= 0) {
					isLeftNode = true;
					current = current.getLeft();
				}else {
					isLeftNode = false;
					current = current.getRight();
				}
			}
			
			if(isLeftNode) {
				parent.setLeft(newNode);
			}else {
				parent.setRight(newNode);
			}
		}
	}

	@Override
	public void insertNode(T data) {
		if(root==null) {
			root = new Node<T>(data);
		}else {
			insertNode(data, root);
		}
	}
	
	private void insertNode(T newData, Node<T> node) {
		if(newData.compareTo(node.getData()) <=0 ) {
			if(node.getLeft()!=null) {
				insertNode(newData, node.getLeft());
			}else {
				Node<T> newNode = new Node<T>(newData);
				node.setLeft(newNode);
			}
		}else {
			if(node.getRight()!=null) {
				insertNode(newData, node.getRight());
			}else {
				Node<T> newNode = new Node<T>(newData);
				node.setRight(newNode);
			}
		}
	}
	
	@Override
	public void delete(T data) {
		if (root != null)
			root = delete(root, data);
	}

	private Node<T> delete(Node<T> node, T data) {

		if (node == null)
			return node;

		if (data.compareTo(node.getData()) < 0) {
			node.setLeft(delete(node.getLeft(), data));
		} else if (data.compareTo(node.getData()) > 0) {
			node.setRight(delete(node.getRight(), data));
		} else {

			// we have found the node we want to remove !!!
			if (node.getLeft() == null && node.getRight() == null) {
				System.out.println("Removing a leaf node...");
				return null;
			}

			if (node.getLeft() == null) {
				System.out.println("Removing the right child...");
				Node<T> tempNode = node.getRight();
				node = null;
				return tempNode;
			} else if (node.getRight() == null) {
				System.out.println("Removing the left child...");
				Node<T> tempNode = node.getLeft();
				node = null;
				return tempNode;
			}

			// this is the node with two children case !!!
			System.out.println("Removing item with two children...");
			Node<T> tempNode = getPredecessor(node.getLeft());

			node.setData(tempNode.getData());
			node.setLeft(delete(node.getLeft(), tempNode.getData()));

		}

		return node;
	}
	
	private Node<T> getPredecessor(Node<T> node) {
		
		if( node.getRight() != null )
			return getPredecessor(node.getRight());
		
		System.out.println("Predecessor is: "+node);
		return node;
	}

	@Override
	public void traverse() {
		if(root!=null) {
			inorderTraversal(root);
		}
	}

	private void inorderTraversal(Node<T> node) {
		if(node!=null) {
			inorderTraversal(node.getLeft());
			System.out.print(node.getData()+" --> ");
			inorderTraversal(node.getRight());
		}
	}
	
	@Override
	public T findMax() {
		if(root==null) return null;
		return findMax(root);
	}
	
	@Override
	public T findMin() {
		if(root==null) return null;
		return findMin(root);
	}
	
	private T findMax(Node<T> node) {
		if(node.getRight()!=null)
			return findMax(node.getRight());
		return node.getData();
	}

	private T findMin(Node<T> node) {
		if(node.getLeft()!=null)
			return findMin(node.getLeft());
		return node.getData();
	}
	
	@Override
	public Node<T> getRoot() {
		return this.root;
	}
	
	//calculate the size of a subtree with root node 'node'
	private int treeSize(Node<T> node) {
		
		//this is the base case
		if(node==null) return 0;
		
		//recursively sum up the size of the left subtree + size of the right subtree
		//size of a tree = size of the left sub tree + size of right sub tree +1(because of the root)
		return ( treeSize(node.getLeft()) + treeSize(node.getRight()) + 1 );
	}
	
	@Override
	public Node<T> getKthSmallest(Node<T> node, int k) {
		
		//number of nodes in the left subtree+1 because we count the root node of the subtree as well
		int n = treeSize(node.getLeft())+1;
		
		//this is when we find the kth smallest item
		if(n==k)
			return node;
		
		//if the number of nodes in the left subtree > k then it means the k-th smallest item is in the left subtree
		if(n>k) return getKthSmallest(node.getLeft(), k);
		
		//if the number of nodes in the left subtree < k then we can discard the left subtree and consider the right subtree.
		//Now we are not looking for the kth but the k-n th smallest item.
		if(n<k) return getKthSmallest(node.getRight(), k-n);
		
		return null;
	}
	
	@Override
	public int getAgesSum() {
		return getAges(this.root);
	}
	
	private int getAges(Node<T> node) {
	
		System.out.println("considering node "+node);
		
		//we have to reinitialize the variables (sum is the parent's node value so the sum of the subtrees so far)
		int sum = 0;
		int leftSum = 0;
		int rightSum = 0;
		
		//null nodes have sum value 0
		if(node==null) {
			return 0;
		}
		
		//we do a simple post-order traversal because here we have to calculate both left and right value to 
		//be able to calculate the parent's value (sum of childrens' ages)
		//check the left subtree recursively
		leftSum = getAges(node.getLeft());
		//check the right subtree recursively
		rightSum = getAges(node.getRight());
		
		//update the sum ... given node's value is the own value + left subtree sum + right subtree sum
		System.out.println("Considering node "+node+" total ages so far is "+(((Person)node.getData()).getAge()+leftSum+rightSum));
		sum = ((Person)node.getData()).getAge()+leftSum+rightSum;
		
		return sum;
	}
}
