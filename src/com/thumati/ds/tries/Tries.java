package com.thumati.ds.tries;

import java.util.ArrayList;
import java.util.List;

public class Tries {
	private Node root;
	private int indexOfSingleChild;
	
	public Tries() {
		this.root = new Node("");
	}
	
	public void insertAsMap(String key, int value) {
		Node tempNode = root;
		for(int i=0; i<key.length(); ++i) {
			char c = key.charAt(i);
			int asciiIndex = c - 'a';
			if(tempNode.getChild(asciiIndex)==null) {
				Node node = new Node(String.valueOf(c));
				tempNode.setChild(asciiIndex, node, value);
				tempNode = node;
			}else {
				tempNode = tempNode.getChild(asciiIndex);
			}
		}
		tempNode.setLeaf(true);
	}
	
	public void insert(String key) {
		Node tempNode = root;
		for(int i=0; i<key.length(); ++i) {
			char c = key.charAt(i);
			int asciiIndex = c - 'a';
			if(tempNode.getChild(asciiIndex)==null) {
				Node node = new Node(String.valueOf(c));
				tempNode.setChild(asciiIndex, node);
				tempNode = node;
			}else {
				tempNode = tempNode.getChild(asciiIndex);
			}
		}
		tempNode.setLeaf(true);
	}
	
	//O(length(key))
	public boolean search(String key) {
		Node trieNode = root;
		for(int i=0; i<key.length(); ++i) {
			char c = key.charAt(i);
			int asciiIndex = c - 'a';
			if(trieNode.getChild(asciiIndex)==null) {
				return false;
			}else {
				trieNode = trieNode.getChild(asciiIndex);
			}
		}
		//if(!trieNode.isLeaf()) return false;
		return true;
	}
	
	//O(length(key))
	public Integer searchAsMap(String key) {
		Node trieNode = root;
		for(int i=0; i<key.length(); ++i) {
			char c = key.charAt(i);
			int asciiIndex = c - 'a';
			if(trieNode.getChild(asciiIndex)!=null) {
				trieNode = trieNode.getChild(asciiIndex);
			}else {
				return null;
			}
		}
		return trieNode.getValue();
	}
	
	//autocomplete
	public List<String> allWordsWithprefix(String prefix){
		Node trieNode = root;
		List<String> allWords = new ArrayList<>();
		
		for(int i=0; i<prefix.length();++i) {
			char c = prefix.charAt(i);
			int asciiIndex = c - 'a';
			trieNode = trieNode.getChild(asciiIndex);
		}
		
		collect(trieNode, prefix, allWords);
		
		return allWords;
	}
	
	
	public String longestCommonPrefix() {
		Node trieNode = root;
		String longestCommonPrefix="";
		
		while( countNoOfChildren(trieNode)==1 && !trieNode.isLeaf()) {
			trieNode = trieNode.getChild(indexOfSingleChild);
			longestCommonPrefix = longestCommonPrefix + String.valueOf( (char) (indexOfSingleChild+'a'));
		}
		
		return longestCommonPrefix;
	}
	
	private int countNoOfChildren(Node trieNode) {
		int noOfChildren=0;
		for(int i=0; i<trieNode.getChildren().length; ++i) {
			if(trieNode.getChild(i)!=null) {
				noOfChildren++;
				indexOfSingleChild=i;
			}
		}
		return noOfChildren;
	}

	private void collect(Node node, String prefix, List<String> allWords) {
		if(node==null) return;
		if(node.isLeaf()) {
			allWords.add(prefix);
		}
		
		for(Node childNode : node.getChildren()) {
			if(childNode==null) continue;
			String childCharacter = childNode.getCharacter();
			collect(childNode, prefix+childCharacter, allWords);
		}
	}
}
