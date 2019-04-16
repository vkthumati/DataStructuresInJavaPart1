package com.thumati.ds.substringsearch;

public class SubStringSearch {

	public int subStringSearch(String text, String pattern) {
		int lenghtOfText = text.length();
		int lenghtOfPattern = pattern.length();
		
		for(int i=0; i<=lenghtOfText-lenghtOfPattern;++i) {
			int j;
			for(j=0; j<lenghtOfPattern;++j) {
				if(text.charAt(i+j)!=pattern.charAt(j)) {
					break;
				}
			}
			
			if(j == lenghtOfPattern) return i;
		}
		
		return -1;
	}
	
	public static void main(String[] args) {
		SubStringSearch search = new SubStringSearch();
		String text = "My name is Joe!";
		String pattern = "named";
		
		System.out.println(search.subStringSearch(text, pattern));

	}

}
