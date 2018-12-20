package com.thumati.ds.stacks;

public class StacksWithArrayApp {

	public static void main(String[] args) {
		StacksWithArray<Employee> stack = new StacksWithArray<>(20);
		
		stack.push(new Employee("Vasanth", 1001));
		stack.push(new Employee("Akshay", 1002));
		stack.push(new Employee("Yaminee", 1003));
		stack.push(new Employee("Shashank", 1004));
		stack.push(new Employee("Prashanth", 1005));
		stack.push(new Employee("Jithendra", 1006));
		stack.push(new Employee("Deepika", 1007));
		stack.push(new Employee("Yashitha", 1008));
		stack.push(new Employee("Ravi", 1009));
		stack.push(new Employee("Pavan", 1010));
		
		System.out.println(stack);
	}

}
