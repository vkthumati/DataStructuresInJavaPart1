package com.thumati.ds.arrays;

public class InPlaceReverseArray {

	//the running time complexity is O(N) + in-place algorithm(no need for extra memory)
	public static void inPlaceReverseArray(int[] nums) {
		//pointer to the first item
		int startIndex = 0;
		
		//pointer to the last item
		int endIndex = nums.length-1;
		
		//we swap 2 items in 1 iteration, so we just have to make N/2 iterations
		while(startIndex<endIndex) {
			//swap two items with index endIndex and startIndex
			swap(nums, startIndex++, endIndex--);
		}
	}
	
	public static void swap(int[] nums, int indx1, int indx2) {
		int temp = nums[indx1];
		nums[indx1] = nums[indx2];
		nums[indx2] = temp;
	}
	
	public static void main(String[] args) {
		int[] nums = new int[50];
		for(int i=0;i<nums.length;++i) {
			nums[i] = i;
		}
		
		for(int num : nums) {
			System.out.print(num+", ");
		}
		
		System.out.println();
		inPlaceReverseArray(nums);
		System.out.println();
		
		for(int num : nums) {
			System.out.print(num+", ");
		}
	}

}
