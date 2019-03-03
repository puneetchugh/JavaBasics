/*
# FileInputStream/FileOutputStream are used to read/write data in byte format from/write to file
# FileReader/FileWriter are used to read/write data in character format
# InputStream/OutputStream can be used with network same way we use them with Files 

# Stream would read/write byte data generically, with the exception of DataInputStream/DataOutputStream 
# DataInputStream/DataOutputStream also gives your the option of int, long, float, double
# Reader/Writer would read/write character data generically.

# An InputStream can be provided as an input to Reader/BufferedReader

# Reader has many different subclasses like BufferedReader, InputStreamReader, PushbackReader, StringReader
# You can get interesting outputs by combining streams and readers.
# Eg: Reader reader = new BufferedInputReader(new FileReader(new InputStream));
*/
package com.spectralink.IOSample;

import java.io.File;
import java.io.*;
import java.io.IOException;

public class IOSample{

	private static String FILENAME = "puneet.txt";

	public static void useBufferedReader(){
		
		System.out.println("Inside useBufferedReader()");
		String localFileName = "Sample.txt";
		File newFile = new File("/home/pchugh/JavaBasics/LearnIO/src/com/spectralink/IOSample/" +localFileName);
		
		try{
			Reader reader = new BufferedReader(new FileReader(newFile), 2);
			char[] charArray = new char[4];
			while(reader.read(charArray, 2, 2)!= -1 ){
				System.out.println(charArray[2]);
				System.out.println((char)charArray[3]);

				//System.out.println((char)charArray[2] + (char)charArray[3]); Why does this produce sum of the ascii of two characters rather than printing the characters
			} 
			reader.close();	
		}catch(IOException ioe){

			System.out.println("Produced IOException...");
			System.out.println(ioe.getMessage());
			ioe.printStackTrace();
		}
	}

	public static void useInputStream(){
		
		System.out.println("Inside useInputStream()");
		String localFileName = "Sample.txt";
		File newFile = new File("/home/pchugh/JavaBasics/LearnIO/src/com/spectralink/IOSample/" +localFileName);


		try{
			int i;
			InputStream stream = new FileInputStream(newFile);
			while(( i = stream.read()) != -1){
				byte oneByte = (byte)i;
				System.out.println(String.valueOf(oneByte));
			}
			stream.close();
			
		}catch(IOException ioe){

			System.out.println("Produced IOException...");
			System.out.println(ioe.getMessage());
			ioe.printStackTrace();
		}

	}

	public static void useFileReader(){
		
		System.out.println("Inside useFileReader()");
		String localFileName = "Sample.txt";
		File newFile = new File("/home/pchugh/JavaBasics/LearnIO/src/com/spectralink/IOSample/" +localFileName);


		try{
			int c;
			//Reader reader = new FileReader(newFile);
			Reader reader = new InputStreamReader(new FileInputStream(newFile));
			while(( c = reader.read()) != -1){
				char oneChar = (char)c;
				System.out.println(String.valueOf(oneChar));
			}
			reader.close();
			
		}catch(IOException ioe){

			System.out.println("Produced IOException...");
			System.out.println(ioe.getMessage());
			ioe.printStackTrace();
		}

	}	
	
	
	public IOSample(){
	}

	public static void main(String[] args){
		
		File newFile = new File("/home/pchugh/JavaBasics/LearnIO/classes" +"/"+FILENAME); 
		//File newFile = new File("/home/pchugh/JavaBasics/LearnIO/classes", FILENAME);
		//File newFile = new File("file:///home/pchugh/JavaBasics/LearnIO/classes/"+FILENAME); This doesn't work.Learn how to do it!
		

		if(newFile.exists()){
			System.out.println("The file exists...");
		}
		else{
			System.out.println("Trying to create the file...");
			try{
				boolean isFileCreated = newFile.createNewFile();
				System.out.println("Was the file created : "+isFileCreated);
			}catch(IOException ioe){
				System.out.println("It produced IOException");
				System.out.println(ioe.getMessage());
				System.out.println("Printing stack trace ....");
				ioe.printStackTrace();
			}
		}
		useBufferedReader();
		useInputStream();
		useFileReader();

		
	}
}
