package com.thumati.ds.heap;

public class CheckHeap {

	public static void main(String[] args) {
		CheckHeap checkHeap = new CheckHeap();
		
		int[] array = {10, 14, 19, 26, 31, 42, 27, 44, 35, 33, 35};
		
		System.out.println(checkHeap.isMinHeap(array));
	}

	public boolean isMinHeap(int[] heap) {
		//leaf nodes do not have children (those are NULL values)
		//so it means that if node with index i -> 2*i+2>n where N is the size of the array then
		//we know that it is a leaf node
		//rearrange the equation: (size of the array without leaf nodes)=(N-2)/2 this is the effective
		//length so the items we have to consider
		for(int i=0;i<=(heap.length-2)/2;++i) {
			//node with index i has left child 2*i+1 and right child 2*i+2 in the array representation
			//we just have to check one by one whether the heap property is violated or not
			if(heap[i]>heap[2*i+1] || heap[i]>heap[2*i+2]) {
				return false;
			}
		}
		//the array represents a valid minimum heap(so all the child nodes are smaller than the parents)
		return true;
	}
}
