package com.puneet.chugh;

public class MyDerivedClass<T,G> extends MyBaseClass<T>{

	MyBaseClass<T> myBaseClass;
	//G[] myArray;
	G myValue;
	public MyDerivedClass(int size1, int size2){
		super(size1);
		//myArray = new G[size2]; //compilation error : cannot create array of generic type
	
	}
	
	public void addItemG(T item1, G item2){
		super.addItemT(item1);
		myValue = item2;
	}

	public void showItem(){
		super.showItem();
		System.out.println("Value of G item is : "+this.myValue);
	}

	public static void main(String[] args){

		MyDerivedClass<String,Integer> myDerivedClass = new MyDerivedClass<String,Integer>(2,2);

		myDerivedClass.addItemG("Puneet", 28);
		myDerivedClass.showItem();
	}
	
}
