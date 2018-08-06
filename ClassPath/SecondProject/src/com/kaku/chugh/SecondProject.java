package com.kaku.chugh;
import com.puneet.chugh.FirstProject;

public class SecondProject{

	public void message(){
		System.out.println("I am inside SecondProject()");
		
	}

	public void printMyFirstProject(){
		FirstProject first = new FirstProject();
		first.printMessage();
	}
}


