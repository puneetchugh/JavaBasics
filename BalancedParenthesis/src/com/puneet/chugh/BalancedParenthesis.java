package com.puneet.chugh;
import java.util.*;

//return unbalanced if parenthesis not balanced
//if balanced, return the string without string
public class BalancedParenthesis{

	String string;
	public BalancedParenthesis(String inputString){
		string = inputString;
	}

	public String checkBalance(){
		String UNBALANCED = "unbalanced";
		Stack<Character> openStack = new Stack();
		Stack<Character> closeStack = new Stack();
		for(char oneChar : string.toCharArray()){
			switch(oneChar){
				case '(' : 
					openStack.push(oneChar);
					break;
				case ')' : 
					if(openStack.size() > closeStack.size()){
						closeStack.push(oneChar);
					}
					else
						return UNBALANCED;
					break;
				default : 
					break;
			}
		}
		
		if(openStack.size() == closeStack.size()){
			StringBuffer sb = new StringBuffer();
			
			String string1 = string.replace("(","");
			String string2 = string1.replace(")","");
			return string2;
		}
		return UNBALANCED;
	}

	public static void main(String[] args){

		BalancedParenthesis balPar = new BalancedParenthesis("ab(c())");
		String string = balPar.checkBalance();
		if(string.equalsIgnoreCase("unbalanced")){
			System.out.printf("ab(c()) : %s\n",string );
		}
		else
			System.out.printf("ab(c()) : %s\n",string );

		
		balPar = new BalancedParenthesis(")(");
		string = balPar.checkBalance();
		if(string.equalsIgnoreCase("unbalanced")){
			System.out.printf(")( : %s\n",string );
		}
		else
			System.out.printf(")( : %s\n",string );

		
		balPar = new BalancedParenthesis("(ab)cd)");
		string = balPar.checkBalance();
		if(string.equalsIgnoreCase("unbalanced")){
			System.out.printf("(ab)cd) : %s\n",string );
		}
		else
			System.out.printf("(ab)cd) : %s\n",string );

		
		balPar = new BalancedParenthesis("(())");
		string = balPar.checkBalance();
		if(string.equalsIgnoreCase("unbalanced")){
			System.out.printf("(()) : %s\n",string );
		}
		else
			System.out.printf("(()) : %s\n",string );
	
	}
}
