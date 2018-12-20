package com.thumati.ds.queues;

import com.thumati.ds.stacks.Stacks;

public class QueueWithOneStackRecursive<T extends Comparable<T>> {
	//use one stack for enqueue operation
	private Stacks<T> stack;
	
	public QueueWithOneStackRecursive() {
		this.stack = new Stacks<>();
	}
	
	//adding an item to the queue is O(1) operation
	public void enqueue(T data) {
		this.stack.push(data);
	}
	
	//NOTE : We use 2 stack again but instead of explicitly define the second stack 
	// we use call-stack of program (stack memory or execution stack)
	public T dequeue() {
		//base case for the recursive method calls the first item
		//is what we are after (this is what we need for queue's dequeue operation)
		if(stack.size()==1) {
			return stack.pop();
		}
		
		//we keep popping the items until we find the last one
		T item = stack.pop();
		
		//we call the method recursively
		T lastDequeuedItem = dequeue();
		
		//after we find the item we dequeue we have to reinsert the items one by one
		enqueue(item);
		
		//this is the item we are looking for(this is what have been popped off in the stack.size()==1 section
		
		return lastDequeuedItem;
	}
}
