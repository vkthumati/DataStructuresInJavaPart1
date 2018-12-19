package com.thumati.ds.arrays;

import java.util.ArrayList;
import java.util.List;

public class MyArrayList {

	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("Vasanth");
		list.add("Kumar");
		list.add("Thumati");
		
		for(String str : list) {
			
		}
		
		System.out.println(list.size());
		
		Object[] objArray = list.toArray();
		String[] strArray = list.toArray(new String[] {});
		
		for(Object obj : objArray) {
			System.out.println(obj);
		}
		
		System.out.println("\n");
		
		for(String str : strArray) {
			System.out.println(str);
		}
	}

}
