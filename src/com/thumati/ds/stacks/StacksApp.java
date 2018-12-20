package com.thumati.ds.stacks;

public class StacksApp {

	public static void main(String[] args) {
		Stacks<Student> stack = new Stacks<>();
		stack.push(new Student("Vasanth", 1001));
		stack.push(new Student("Kumar", 1002));
		stack.push(new Student("Thumati", 1003));
		stack.push(new Student("Akshay", 1004));
		stack.push(new Student("Yaminee", 1005));
		stack.push(new Student("Shashank", 1006));
		stack.push(new Student("Deepika", 1007));
		
		System.out.println("Stack Size : "+stack.size());
		System.out.println(stack);
		System.out.println("Peek : "+stack.peek());
		System.out.println("Pop : "+stack.pop());
		System.out.println("Stack Size : "+stack.size());
		System.out.println(stack);
	}

}
