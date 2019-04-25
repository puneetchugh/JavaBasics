package com.puneet.chugh;
import java.util.*;
public class ParenthesisCheck{

	String parString;
	public ParenthesisCheck(String string){
		parString = string;
	}

	public String checkBalanced(){
		String IMBALANCED = "imbalanced";
		String BALANCED = "balanced";
		Stack<Character> stackOpen = new Stack();
		Stack<Character> stackClose = new Stack();

		for(char one : parString.toCharArray()){
			
			switch(one){
				case '{':
				case '(':
				case '[':
					//System.out.printf("Pushing %c to open stack\n",one);
					stackOpen.push(one);
					break;

				case '}' : 
					//System.out.printf("Checking open stack if it contains corresponding open par for %c\n", one);
					if(!stackOpen.isEmpty() && stackOpen.peek() == '{')
						stackOpen.pop();
					else{
						//System.out.printf("open stack has %c on the top\n",stackOpen.peek());
						return IMBALANCED;
					}
					break;
				case ')' :
					//System.out.printf("Checking open stack if it contains corresponding open par for %c\n", one);
					if(!stackOpen.isEmpty() && stackOpen.peek() == '(')
						stackOpen.pop();
					else{
						//System.out.printf("open stack has %c on the top\n",stackOpen.peek());
						return IMBALANCED;
					}
					break;
					
				case ']' :
					//System.out.printf("Checking open stack if it contains corresponding open par for %c\n", one);
					if(!stackOpen.isEmpty() && stackOpen.peek() == '[')
						stackOpen.pop();
					else{
						//System.out.printf("open stack has %c on the top\n",stackOpen.peek());
						return IMBALANCED;
					}
					break;
						
				default :
					//System.out.printf("Default %c in open stack\n",stackOpen.peek()); 
					return IMBALANCED;
			}
		}
		
		if(stackOpen.isEmpty())
			return BALANCED;

		return IMBALANCED;
		
	}  

	public static void main(String[] args){
	
		ParenthesisCheck paCheck = new ParenthesisCheck("({[]})(){}[]");
		System.out.printf("The input %s is %s\n", "({[]})(){}[]", paCheck.checkBalanced());
			
		paCheck = new ParenthesisCheck("[]()[]");
		System.out.printf("The input %s is %s\n", "[]()[]", paCheck.checkBalanced());

		paCheck = new ParenthesisCheck("[[]()[)]");
		System.out.printf("The input %s is %s\n", "[[]()[)]", paCheck.checkBalanced());

		paCheck = new ParenthesisCheck("))((]");
		System.out.printf("The input %s is %s\n", "))((]", paCheck.checkBalanced());
	
	}
}
