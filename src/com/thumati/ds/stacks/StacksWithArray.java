package com.thumati.ds.stacks;

import java.util.Arrays;

//It is a space/memory friendly
public class StacksWithArray<T> {
	//It is a space/memory friendly
	private T[] stack;
	private int noOfItems;
	
	@SuppressWarnings("unchecked")
	public StacksWithArray() {
		this.stack = (T[])new Object[10];
		this.noOfItems = 0;
	}
	
	@SuppressWarnings("unchecked")
	public StacksWithArray(int size) {
		this.noOfItems = 0;
		this.stack = (T[])new Object[size];
	}
	
	public int size() {
		return noOfItems;
	}
	
	public boolean isEmpty() {
		return noOfItems==0;
	}
	
	//O(N) Linear Time Complexity
	//O(1) if no resize
	public void push(T data) {
		if(noOfItems==stack.length) {
			resize(2*this.stack.length);
		}
		stack[noOfItems++]=data;
	}
	
	//O(N) Linear Time Complexity
	//O(1) if no resize
	public T pop() {
		T data = null;
		if(!isEmpty()) {
			if(this.noOfItems>0 && this.noOfItems==this.stack.length/4) {
				resize(this.stack.length/2);
			}
			data = this.stack[--this.noOfItems];
			this.stack[this.noOfItems] = null;
		}
		return data;
	}
	
	//O(1)
	public T peek() {
		return stack[noOfItems-1];
	}
	
	//O(N) Linear Time Complexity
	@SuppressWarnings({"unchecked", "unused"})
	public void resize(int newCapacity) {
		T[] newStack= (T[]) new Object[newCapacity];
		for(int i=0; i<this.stack.length; ++i) {
			newStack[i] = this.stack[i];
		}
		stack = newStack;
	}

	@Override
	public String toString() {
		return "StacksWithArray [stack=" + Arrays.toString(stack) + ", noOfItems=" + noOfItems + "]";
	}
	
	
}
