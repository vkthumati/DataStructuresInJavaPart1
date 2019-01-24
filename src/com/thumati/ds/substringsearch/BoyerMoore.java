package com.thumati.ds.substringsearch;

import java.util.HashMap;
import java.util.Map;

public class BoyerMoore {
	private String text;
	private String pattern;
	private Map<Character, Integer> mismatchShiftTable;
	
	public BoyerMoore(String text, String pattern) {
		this.text = text;
		this.pattern = pattern;
		this.mismatchShiftTable = new HashMap<>();
	}
	
	public void preComputeShifts() {
		int lengthOfPattern = this.pattern.length();
		
		for(int index=0; index<lengthOfPattern; index++) {
			char actualCharacter = this.pattern.charAt(index);
			int maxShift = Math.max(1, lengthOfPattern-index-1);
			this.mismatchShiftTable.put(actualCharacter, maxShift);
		}
	}
	
	public int search() {
		int lenghtOfText = text.length();
		int lenghtOfPattern = pattern.length();
		int noOfSkips;
		
		for(int i=0; i<lenghtOfText-lenghtOfPattern; i+=noOfSkips) {
			noOfSkips = 0;
		}
		return 0;
	}
	
	public static void main(String[] args) {
		

	}

}
