package com.puneet.chugh;
import java.lang.Exception;
import java.io.*;
public class ReadSampleFile{
	
	private String filename;
	
	public ReadSampleFile(String filename){
		this.filename = filename;
	}

	public void readUsingReader() throws IOException{
		
		File file = new File("src/com/puneet/chugh/"+filename);
	
		
		try(Reader reader = new InputStreamReader(new FileInputStream(file));){
			int oneChar;
			while((oneChar = reader.read()) != -1){
				System.out.printf("%c", (char)oneChar);
			}
		}catch(IOException ioe){
			System.out.println("Its an IO Exception...");
			throw new IOException("Rethrowing IO Exception...");
		}	
	}

	public void readUsingStream(){
		
		File file = new File("src/com/puneet/chugh/"+filename);
		int oneByte;

		try(InputStream stream = (new FileInputStream(file))){
			while((oneByte = stream.read()) != -1){
				
				System.out.printf("%d\n", oneByte);
	
			}
		}catch(IOException ioe){
			System.out.println("Its an IO Exception...");
			System.out.println(ioe.getMessage());
			//throw new IOException("Rethrowing IO Exception...");
		}	

	}

	public void readUsingBufferedStream(){
		
		File file = new File("src/com/puneet/chugh/"+filename);
		int oneByte;

		try(InputStream stream = new BufferedInputStream(new FileInputStream(file))){
			byte[] byteArray = new byte[10];
			while(stream.read(byteArray, 0, 2) != -1){
				
				System.out.printf("%c", (char)(byteArray[0]));
	
			}
		}catch(IOException ioe){
			System.out.println("Its an IO Exception...");
			System.out.println(ioe.getMessage());
			//throw new IOException("Rethrowing IO Exception...");
		}	

	}

	public void readUsingBufferedReader(){
		File file = new File("src/com/puneet/chugh/"+filename);
		
		int oneChar;

		try(Reader reader = new BufferedReader(new FileReader(file))){
			while((oneChar=reader.read()) != -1){
				System.out.printf("%c", (char)oneChar);
			}
		}catch(IOException ioe){
			
			System.out.println("An IO Exception has occurred..");
			System.out.println(ioe.getMessage());
		}
	}


	public static void main(String[] args){

		ReadSampleFile readSample = new ReadSampleFile("sample.txt");
		System.out.println("Using InputStream to read a file..");
		readSample.readUsingStream();
		try{
			readSample.readUsingReader();
		}catch(IOException ioe){
			System.out.println(ioe.getMessage());
		}
		
		readSample.readUsingBufferedStream();
		readSample.readUsingBufferedReader();	
		
	}
}
