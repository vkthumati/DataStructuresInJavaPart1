package com.thumati.ds.arrays;

/**
 * 
 * Problem : The problem is that we want to find duplicates in a T[] one-dimensional array of integers in O(N) running time where the integer values are smaller than the length of the array!
 *	The problem is that we want to find duplicates in a one-dimensional array of integers in O(N) running time where the integer values are smaller than the length of the array.
 * Note : input must be >=1 and < array length
 */
public class FindDuplicateIntegers {

	public static void solve(int[] nums) {
		
		//this is why it is an O(N) running time algorithm
		for(int i=0; i<nums.length; ++i) {
			
			//if this value is positive we have to make it negative
			if(nums[Math.abs(nums[i])] > 0) {
				nums[Math.abs(nums[i])] = -nums[Math.abs(nums[i])];
			}else { //otherwise it is negative : it means repetition
				System.out.println(Math.abs(nums[i])+" is a repetition!");
			}
		}
		
	}
	
	public static void main(String[] args) {
		int[] nums = {1, 4, 5, 6, 2, 6, 4, 1, 1, 1, 2};
		//int[] nums = {2, 3, 1, 2, 4, 3};
		
		solve(nums);
	}

}
