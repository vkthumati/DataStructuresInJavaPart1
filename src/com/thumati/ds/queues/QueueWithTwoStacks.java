package com.thumati.ds.queues;

import com.thumati.ds.stacks.Stacks;

public class QueueWithTwoStacks<T extends Comparable<T>> {
	private Stacks<T> enqueueStack;
	private Stacks<T> dequeueStack;
	
	public QueueWithTwoStacks() {
		this.enqueueStack = new Stacks<T>();
		this.dequeueStack = new Stacks<T>();
	}
	
	public void enqueue(T data) {
		this.enqueueStack.push(data);
	}
	
	public T dequeue() {
		//no items in the stacks
		if(enqueueStack.isEmpty() && dequeueStack.isEmpty()) {
			throw new RuntimeException("Queue is empty.....");
		}
		
		//if the dequeueStack is empty we have to add items O(N) time
		if(dequeueStack.isEmpty()) {
			while(!enqueueStack.isEmpty()) {
				dequeueStack.push(enqueueStack.pop());
			}
		}
		
		//otherwise we just have to pop off an item in O(1)
		return dequeueStack.pop();
	}
	
	public static void main(String[] args) {
		QueueWithTwoStacks<Integer> queue = new QueueWithTwoStacks<>();
		
		queue.enqueue(10);
		queue.enqueue(20);
		queue.enqueue(30);
		queue.enqueue(40);
		
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		
		queue.enqueue(50);
		queue.enqueue(60);
		
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
	}
	
}
