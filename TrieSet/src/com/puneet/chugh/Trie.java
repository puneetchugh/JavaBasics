package com.puneet.chugh;

public class Trie{
	
	public static int MAX_CHARS = 26;
	
	//private Trie root;
	private boolean isLastChar;
	private Trie[] children = new Trie[MAX_CHARS];
	
	public Trie(){}
		
	public void insert(String string, Trie root){
			
		if(string == null || string.length() == 0){
			return;
		}
		Trie tempTrie = root;
		int length = string.length();

		for(int counter=0; counter<length; counter++){
			char character = string.charAt(counter);
			int index = character - 'a';
			if(tempTrie.getChildren()[index] == null){
				tempTrie.setChild(index);
			}	
			tempTrie = tempTrie.getChildren()[index]; 
		}
		tempTrie.setLastChar();
	}

	public String search(String string, Trie root){
	
		if(string == null || string.length() == 0)
			return null;

		Trie tempTrie = root;
		int length = string.length();

		for(int counter=0; counter<length; counter++){
				char character = string.charAt(counter);
				int index = character - 'a';
				if(tempTrie.getChildren()[index] != null){
					tempTrie = tempTrie.getChildren()[index];
				}
			else{
				return null;
			}
		}
		return (tempTrie != null && tempTrie.getIsLastChar())? string : null;	
	}
	
	public void setChild(int index){
		children[index] = new Trie();
	}
	
	public Trie[] getChildren(){
		return children;
	}

	public void setLastChar(){
		isLastChar = true;
	}

	public boolean getIsLastChar(){
		return isLastChar;
	}
}
