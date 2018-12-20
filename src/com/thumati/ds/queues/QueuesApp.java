package com.thumati.ds.queues;

public class QueuesApp {

	public static void main(String[] args) {
		Queues<Integer> queue = new Queues<Integer>();
		
		queue.enqueue(10);
		queue.enqueue(20);
		queue.enqueue(30);
		queue.enqueue(40);
		queue.enqueue(50);
		
		System.out.println("Dequeue : "+queue.dequeue());
		System.out.println("Dequeue : "+queue.dequeue());
		
		System.out.println(queue);
		
		System.out.println("Dequeue : "+queue.dequeue());
		System.out.println("Dequeue : "+queue.dequeue());
		System.out.println("Dequeue : "+queue.dequeue());
		System.out.println("Dequeue : "+queue.dequeue());
	}

}
