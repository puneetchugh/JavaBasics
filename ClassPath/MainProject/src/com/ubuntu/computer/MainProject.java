package com.ubuntu.computer;
import com.kaku.chugh.SecondProject;

public class MainProject{

	public void myMessage(){
		System.out.println("I am in MainProject()");
	}

	public static void main(String[] args){
	
		SecondProject secondClass = new SecondProject();
		secondClass.message();
		secondClass.printMyFirstProject();
		
		MainProject mainProject = new MainProject();
		mainProject.myMessage();
				
	}
}
