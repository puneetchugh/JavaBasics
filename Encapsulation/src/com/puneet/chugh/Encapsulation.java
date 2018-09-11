/*Encapsulation is binding the code and data together into a single unit, class.
  Encapsulation provides a shield to the data being accessed from outside. 
  There are limited ways of accessing the data from outside and that is using 
  an object of the class. 
  Encapsulation assists in data-hiding, increased flexiblity - the data members 
  could be made as read-only or write-only, increases reusability and makes 
  code testing easier.
*/

package com.puneet.chugh;

public class Encapsulation{

	private int variable;
	private String firstString;
	private String secondString;

	public Encapsulation(int variable, String firstString, String secondString){
		this(variable);
		this.firstString = firstString;
		this.secondString = secondString;
	}
	public Encapsulation(int variable){
		this.variable = variable;
	}

	public void setVariable(int variable){
		this.variable = variable;
	}
	
	public int getVariable(){
		return variable;
	}

	public String getFirstString(){
		return firstString;
	}

	public String getSecondString(){
		return secondString;
	}

	public void displayMembers(){
		System.out.println("Variable : "+variable+
				   "\nfirstString : "+firstString+
				   "\nsecondString : "+secondString);
	}

	public static void main(String[] args){
		
		Encapsulation encapsulation = new Encapsulation(10, "puneet", "chugh");
		encapsulation.displayMembers();	
	}
}
