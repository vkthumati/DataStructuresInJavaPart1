package com.thumati.ds.arrays;

import java.util.Arrays;

public class Anagram {

	public static boolean solve(char[] s1, char[] s2) {
		
		if(s1.length!=s2.length)
			return false;
		
		//bottleneck because it has O(NlogN) running time
		Arrays.sort(s1);
		
		//bottleneck because it has O(NlogN) running time
		Arrays.sort(s2);
		
		//total running time till now is O(NlogN) + O(NlogN) = O(2NlogN) = O(NlogN). We can ignore constant 2
		
		//running time is O(N)
		for(int i=0; i<s1.length; ++i) {
			if(s1[i]!=s2[i])
				return false;
		}
		
		//total running time till now is O(NlogN) + O(N) = O(NlogN).  We can ignore smaller value O(N).
		
		return true;
	}
	
	public static void main(String[] args) {
		String word1 = "restful";
		String word2 = "fluster";
		
		boolean isAnagram = solve(word1.toCharArray(), word2.toCharArray());
		if(isAnagram) {
			System.out.println(word1+" And "+word2+ " are angram");
		}else {
			System.out.println(word1+" And "+word2+ " are not angram");
		}
	}
}
