package com.thumati.ds.arrays;

public class MyArrays {

	public static void main(String[] args) {
		int[] nums = new int[20];
		for(int i=0; i<nums.length;++i) {
			nums[i] = i;
		}
		
		//O(1) random index
		int num = nums[2];
		System.out.println(num);
		
		//O(N) Linear Search --> O(logN) BinarySearchTree --> O(1) hashtables
		for(int i=0; i<nums.length;++i) {
			if(nums[i]==4) {
				System.out.println("Index Found : "+i);
			}
		}
		
		for(int n:nums) {
			
		}
		
		Employee[] empArray = new Employee[10];
		for(Employee emp:empArray) {
			
		}
	}

}

class Employee{
	int id;
}
