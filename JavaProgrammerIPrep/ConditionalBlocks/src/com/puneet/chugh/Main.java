package com.puneet.chugh;

public class Main{

	public static void main(String[] args){
		System.out.println("conditionalBlock (80) :"+conditionalBlock(80));	
		switchBlock("ABC");
		switchBlock("abc");
		
	}


// < 40 -> print Fail
// 40-70 -> print Fair
// 70-80 -> print Good
// 80-90 -> print Very Good 
// 90-100 -> Excellent
public static String conditionalBlock(int integer){


	String retString = (integer < 40) ? "Fail" : 
			(integer>=40 && integer<40) ? "Fair" : 
				(integer>=70 && integer<80) ? "Good" : 
					(integer>=80 && integer<90) ? "Very Good" : "Excellent" ;
	return retString; 

	
}

public static void switchBlock(String string){

	switch(string){
		
		case "abc":
			System.out.println("abc");
			break;
		case "xyz":
			System.out.println("xyz");
			break;
		default : 
			System.out.println("Inside default: "+string);
	}
}

//switch() cannot be used with boolean
/*
public static void switchForBoolean(boolean val){

	switch(val){

		case true:// 
		case false: //
	
	}
}
*/
}
