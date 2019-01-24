package com.thumati.ds.tst;

public class App {
	public static void main(String[] args) {
		TernarySearchTree tst = new TernarySearchTree();
		
		tst.put("apple", 1);
		tst.put("orange", 2);
		//tst.put("apple", 1);
		System.out.println(tst.get("orange"));
	}
}
