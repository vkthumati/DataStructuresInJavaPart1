package com.thumati.ds.heap;

public class App {

	public static void main(String[] args) {
		Heap heap = new Heap();
		
		heap.insert(10);
		heap.insert(8);
		heap.insert(12);
		heap.insert(20);
		heap.insert(-2);
		heap.insert(0);
		heap.insert(1);
		heap.insert(321);
		
		/*System.out.println(heap.poll());
		System.out.println(heap.poll());
		System.out.println(heap.poll());
		System.out.println(heap.poll());
		System.out.println(heap.poll());
		System.out.println(heap.poll());
		System.out.println(heap.poll());
		System.out.println(heap.poll());*/
		
		heap.heapSort();
		
		System.out.println("==============================");
		
		heap.heapSort();
	}

}
