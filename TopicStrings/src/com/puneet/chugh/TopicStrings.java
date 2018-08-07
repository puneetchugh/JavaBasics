/* Strings
* Strings are immutable in java
* Strings are very fast because they are stored with their hashmap values
* Strings are stored in string pool literals and if you create a string with same value
  again it would refer the same value
* The previous point is the major reason why string literal is immutable in java because 
  multiple points can be referencing to same variable and changing from one point would 
  change it for all of them. Also, it would change the entry and exit hash value of string
* Strings in string literal stay for longer, they are not quickly garbage collected
* Immutability of strings makes them fast but also vulnerable to too much accumulation as 
  every operation on String produces another string. So, there's a mutable alternative to it, 
  which is StringBuilder(faster, not thread safe) and StringBuffer(slower, thread safe)
* Since string literal last for longer in java program, its better to use character array for 
  sensitive information like passwords, etc
* + is overloaded in java, ie, it concatenates the strings on both its sides
* Strings in java are not null terminated as C or C++
* Creating a new String() object would create a string object, a new string literal if it doesn't exist
  So, its better to create strings like String name = "Puneet"
* Comparing Strings with == compares the reference of the Strings not actual values.
* To compare the actual values of strings, use equals or compareTo(cannot have null strings) and their 
  case insensitive counterparts
*/

package com.puneet.chugh;
import java.lang.NullPointerException;
public class TopicStrings{

	public static void main(String[] args){

		String name = "Puneet Chugh";
		System.out.printf("name = %s\n", name);
		String mySubString = name.substring(0,6);
		System.out.printf("name.substring(0,6) = %s\n", mySubString);
		mySubString = name.substring(0,5);
		System.out.printf("name.substring(0,5) = %s\n", mySubString);

		String anotherName = new String("Puneet Chugh");
			
		char oneChar = name.charAt(5);
		System.out.println("name.charAt(5) : "+oneChar);	
			
		boolean isEqual = name==anotherName;
		System.out.println("name==anotherName : "+isEqual);
		
		isEqual = name.endsWith("Chugh");
		System.out.println("name.endsWith(\"Chugh\") : " + isEqual);
		
		isEqual = name.equals(anotherName);
		System.out.println("name.equals(anotherName) : "+isEqual);
		
		isEqual = name.equals(null);
		System.out.println("name.equals(null) : "+isEqual);

		isEqual = name.compareTo(anotherName) == 0 ? true : false;
		System.out.println("name.compareTo(anotherName) : "+isEqual);
		
		try{
			isEqual = name.compareTo(null) == 0 ? true : false;
			System.out.println("name.compareTo(null) : "+isEqual);
		
		}catch(NullPointerException npe){
			System.out.println("name.compareTo(null) is a NullPointerException scenario");
		}

		
		StringBuilder sb = new StringBuilder();

		System.out.println("StringBuilder sb = new StringBuilder()");
		System.out.println("sb.capacity() : "+sb.capacity());

		sb.append("Kaku");
		System.out.println("sb.append(\"Kaku\") : "+sb.toString());
		System.out.println("sb.capacity() : "+sb.capacity());
		
		sb.append("Chugh");
		System.out.println("sb.append(\"Chugh\") : "+sb.toString());
		System.out.println("sb.capacity() : "+sb.capacity());
		
		sb.append("Puneet");
		System.out.println("sb.append(\"Puneet\") : "+sb.toString());
		System.out.println("sb.capacity() : "+sb.capacity());

		sb.delete(0,4);
		System.out.println("sb.delete(0,4) : "+sb.toString());

		sb.replace(0, 5, "Puneet");
		System.out.println("sb.replace(0, 5, \"Puneet\") : "+ sb.toString());
	
		System.out.println("sb.length() : "+sb.length());
		
		sb.delete(0, sb.length());
		System.out.println("sb.delete(0, sb.length()) : "+sb.toString());

	}
}
