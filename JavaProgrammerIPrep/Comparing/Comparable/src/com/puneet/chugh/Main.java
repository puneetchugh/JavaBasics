package com.puneet.chugh;
import java.util.*;


public class Main{

	public static void main(String[] args){	
		Set<Student> studentSet = new HashSet<>();

		Student st1  = new Student(1, "Puneet Chugh", 28);
		Student st2  = new Student(1, "Puneet Chugh", 28);

		studentSet.add(st1);
		
		if(studentSet.contains(st2)){ //HashSet stores each object with a hashcode,
					      //if hashCode is defined, then if would identify
					      //them as same
			System.out.println("Set already contains the object");
		}

		boolean isAdded = studentSet.add(st2);
		System.out.println("isAdded : "+isAdded);

		System.out.println("Is st1 == st2 ? "+(st1==st2)); //false (checking reference)
		System.out.println("Is st1.equals(st2) ? "+st1.equals(st2)); //true (checking actual equality)

		for(Student student : studentSet){
			System.out.printf("Student id : %d\tName : %s\tAge : %d\n", student.getId(), student.getName(), student.getAge());
		}

		

		List<Student> studentList = new ArrayList<Student>();
		studentList.add(st1);
		System.out.println("Does array list contain st2 ? "+studentList.contains(st2)); //It only checks the equals() method, 
											 	//if equals() method is defined, arraylist
												//contains will act accordingly

	
		treeSetSorting();
		myComparator();	
	}

	public static void treeSetSorting(){
		
		
		Student st1  = new Student(1, "Kaku Chugh", 28);
		Student st2  = new Student(4, "Shiv Chugh", 28);
		Student st3  = new Student(10, "Nishu", 30);
		Student st4 = new Student(11, "Maya", 40);

		TreeSet<Student> set = new TreeSet<Student>();
		set.add(st1);
		set.add(st2);
		set.add(st3);
		set.add(st4);
		
		for(Student st : set){
			System.out.printf("Student id : %d\tName : %s\tAge : %d\n",st.getId(), st.getName(), st.getAge());
		}
	}

	public static Comparator<Student> nameComparator = new Comparator<Student>(){

		@Override
		public int compare(Student st1, Student st2){
			return st1.getName().hashCode() - st2.getName().hashCode();
		}
	};
	
	public static void myComparator(){
		
		
		Student st1  = new Student(1, "Kaku Chugh", 28);
		Student st2  = new Student(4, "Shiv Chugh", 28);
		Student st3  = new Student(10, "Nishu", 30);
		Student st4 = new Student(11, "Maya", 40);

		TreeSet<Student> set = new TreeSet<Student>(nameComparator);
		set.add(st1);
		set.add(st2);
		set.add(st3);
		set.add(st4);
		
		for(Student st : set){
			System.out.printf("Student id : %d\tName : %s\tAge : %d\n",st.getId(), st.getName(), st.getAge());
		}
	}
}
