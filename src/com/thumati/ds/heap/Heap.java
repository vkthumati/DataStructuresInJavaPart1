package com.thumati.ds.heap;

public class Heap {
	
	//we represent the heap data structure with an array
	private int[] heap;
	
	//we want to track the size (the number of items in the heap)
	private int heapSize;
	
	public Heap() {
		this.heap = new int[Constants.CAPACITY];
	}
	
	//insertion takes O(1) running time BUT we have to make sure that the heap properties are not violated(it takes O(log N) because of the fixUp() method)
	public void insert(int data) {
		//we are not able to insert more items than the value of the CAPACITY
		if(isHeapFull()) throw new RuntimeException("Heap is full...");
		
		//insert the item + increment the counter
		this.heap[heapSize]=data;
		++heapSize;
		
		//we insert the item to the last position of the array: of course the heap properties may be violated so we have to fix it if necessary.
		fixUp(heapSize-1);
	}
	
	
	//we consider the last item and checks whether swaps are needed or not
	//running time : O(logN)
	private void fixUp(int index) {
		//the parent index of the given node in the heap
		//we store the heap in an array(!!!)
		int parentIndex = (index-1)/2;
		
		//while the index>0 means until we consider all the items "above" the one we inserted 
		//we have to swap the node with the parent if the heap property is violated
		//it is a MAX HEAP: largest items are in the higher layers(max item == root node)
		if(index>0 && heap[index] > heap[parentIndex]) {
			swap(index, parentIndex);
			fixUp(parentIndex);
		}
	}

	//swap two items with (index1, index2) in the heap array
	private void swap(int index1, int index2) {
		int temp = heap[index1];
		heap[index1]=heap[index2];
		heap[index2]=temp;
	}
	
	private boolean isHeapFull() {
		return Constants.CAPACITY == heapSize;
	}

	//we have N items and we want to sort them with a heap
	//every poll() operation takes O(log N) time because of the fixDown() method thats why 
	//the overall running time complexity is O(N log N) for heapsort
	public void heapSort() {
		//we decrease the size of the heap in the poll() method so we have to store it(!!!)
		int size = heapSize;
		
		for(int i=0; i<size; ++i) {
			int max = poll();
			System.out.println(max+" ");
		}
	}
	
	//it returns the maximum item + removes it from the heap
	//note: we just do not care about item any more but because 
	//we have an array with fix size we are not able to get rid of it completely
	public int poll() {
		int max = getMax();
		
		swap(0, heapSize-1);
		--this.heapSize;
		
		fixDown(0);
		
		return max;
	}
	
	
	//we return the root node. Because it is a max heap, the root is the max item
	//of course because of the array representation it takes O(1) time
	//this is the peek() method.
	private int getMax() {
		return this.heap[0];
	}
	
	//we have a given item in the heap and we consider all the item BELOW and check
	//whether the heap properties are violated or not.
	private void fixDown(int index) {
		//every node has children: left chile and right child
		//in the array the node i has left child with index 2*i+1 and right child with index 2*i+2
		int leftIndex = 2*index+1;
		int rightIndex = 2*index+2;
		
		//max heap so the parent node is always greater than the children
		int largestIndex = index;
		
		//if the left child is greater than parent: largest is the left node
		if(leftIndex<heapSize && heap[leftIndex] > heap[index])
			largestIndex = leftIndex;
		
		//if the right child is greater than left child : largest is the right node
		if(rightIndex<heapSize && heap[rightIndex] > heap[largestIndex])
			largestIndex = rightIndex;
		
		//we do not want to swap items with themselves
		if(index!=largestIndex) {
			swap(index, largestIndex);
			fixDown(largestIndex);
		}
	}
}
