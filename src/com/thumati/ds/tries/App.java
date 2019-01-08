package com.thumati.ds.tries;

import java.util.List;

public class App {

	public static void main(String[] args) {
		/*Tries tries = new Tries();
		
		tries.insert("joe", 1);
		tries.insert("joell", 2);		
		//tries.insert("adamovich", 3);
		tries.insert("helloworld", 4);
		tries.insert("adamm", 6);
		tries.insert("adam", 5);
		//tries.insert("adamm", 6);
		
		System.out.println( tries.search("jo") );
		System.out.println( tries.search("joe") );
		System.out.println( tries.searchAsMap("joe") );
		System.out.println( tries.searchAsMap("adam") );
		System.out.println( tries.searchAsMap("adamm") );*/
		
		/*Tries trie = new Tries();
		trie.insert("adam");
		trie.insert("adr");
		trie.insert("adda");
		trie.insert("adada");
		trie.insert("adazzz");
		
		List<String> list = trie.allWordsWithprefix("ada");
		
		for(String s : list) {
			System.out.println(s);
		}*/
		
		/*Tries trie = new Tries();
		trie.insert("adam");
		trie.insert("kevin");
		trie.insert("evelin");
		trie.insert("addams");
		trie.insert("junior");
		
		List<String> list = trie.allWordsWithprefix("");
		
		for(String s : list) {
			System.out.println(s);
		}*/
		
		Tries trie = new Tries();
		trie.insert("adam");
		trie.insert("adamm");
		trie.insert("adamee");
		trie.insert("adams");
		trie.insert("adama");
		
		System.out.println("The longest common prefix : "+trie.longestCommonPrefix());
		
		
	}

}
