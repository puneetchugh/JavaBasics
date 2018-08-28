# generic method has type with solid bracket <> before the return type
# for generic class, the type is defined immediately after the classname within solid bracket <>
# Cannot create array of generic type.
# Can create array of specific type and then typecast to generic, but its not recommended

package com.puneet.chugh;

public class MyBaseClass<T>{

	T[] myArray;
	T myValue;
	public MyBaseClass(int size){
		//myArray = new T[size]; compilation error : cannot create array of generic type
	}

	public void addItemT(T item){
		myValue = item;
	}
	
	public void showItem(){
		System.out.println("Value of T item is : "+myValue);
	}

	/*
	public static void main(String[] args){
		
		
	}*/
}
