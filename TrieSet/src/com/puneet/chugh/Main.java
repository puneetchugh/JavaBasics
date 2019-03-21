package com.puneet.chugh;

public class Main{

	public static void main(String[] args){
		
		Trie root = new Trie();

		root.insert("char", root);
		root.insert("character", root);
		root.insert("happen", root);
		root.insert("happened", root);
		root.insert("happening", root);
		root.insert("cool", root);
		root.insert("cooling", root);
		root.insert("summer", root);

		System.out.println("Does happening exist ? "+((root.search("happening", root) == null)? "false":"true"));
		System.out.println("Does happens exists ? "+((root.search("happens", root) == null) ? "false" : "true"));
	}
}
