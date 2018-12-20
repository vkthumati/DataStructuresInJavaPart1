package com.thumati.ds.stacks;

public class MaxItemStack {
	//this is the original stack
	private Stacks<Integer> mainStack;
	
	//this stack is just for tracking the maximum item
	private Stacks<Integer> maxStack;
	
	public MaxItemStack() {
		this.mainStack = new Stacks<>();
		this.maxStack = new Stacks<>();
	}
	
	public void push(int item) {
		//push the new item onto the stack
		mainStack.push(item);
		
		if(mainStack.size()==1) {
			maxStack.push(item);
			return;
		}
		
		//if the item is the largest one so far: we insert it onto the stack
		if(item > maxStack.peek()) {
			maxStack.push(item);
		}else {//if not the largest one then we duplicate the largest one on the maxStack
			maxStack.push(maxStack.peek());
		}
	}
	
	//when removing an item we remove it from both the stacks
	public int pop() {
		maxStack.pop();
		return mainStack.pop();
	}
	
	//max item is the last item we have inserted into the maxStack
	public int getMaxItem() {
		return maxStack.peek();
	}
	
	public static void main(String[] args) {
		MaxItemStack stack = new MaxItemStack();
		stack.push(9);
		stack.push(10);
		stack.push(20);
		stack.push(30);
		stack.push(40);
		stack.push(50);
		stack.push(60);
		stack.push(70);
		stack.push(80);
		
		System.out.println("Max : "+stack.getMaxItem());
		stack.pop();
		System.out.println("Max : "+stack.getMaxItem());
		stack.pop();
		System.out.println("Max : "+stack.getMaxItem());
		stack.pop();
		System.out.println("Max : "+stack.getMaxItem());
		stack.pop();
		System.out.println("Max : "+stack.getMaxItem());
	}
}
