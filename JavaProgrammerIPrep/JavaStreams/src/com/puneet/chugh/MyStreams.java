package com.puneet.chugh;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.*;
import java.util.stream.Stream;
import java.util.Map.*;
import java.util.function.Function;
import java.util.*;
import java.util.regex.Pattern;

public class MyStreams{

	public static void main(String[] args){
	
		incrementAllAgeBy2(getStream(getList()));
		createMap1(getStream(getList()));	
		createMap2(getStream(getList()));	
		createMap3(getStream(getList()));
		showStats(getStream(getList()));
		findingwithAge();
		sortNames();
		splittingStringUsingStream();
		reduce1();
		reduce2();	
	}


	//use peak method of streams to increment age of evey person by 2
	public static void incrementAllAgeBy2(Stream<Person> personStream){

		System.out.println("Person after incrementing age of every person by 2");
		personStream
		.peek(p -> p.incrementAge(2))
		.forEach(p -> System.out.printf("Name : %s\tAge : %d\t", p.getName(), p. getAge()));
	}

	public static void findingwithAge(){

		//Here, retrieving people with age 21, 25, 30,
		//Then displaying people with age only 21 years.
		System.out.println("People with 21 years of age");
		Integer[] age = {21, 25, 30};
		
		Stream.of(age)
			.map(MyStreams::findPersonByAge)
			.filter(p -> p!=null)
			.findFirst()
			.orElse(null)
			.forEach(s->System.out.printf("Name : %s\tAge : %d\tPhone : %s\n", ((Person)s).getName(), ((Person)s).getAge(), ((Person)s).getTelNumber()));
	}

	public static Stream<Person> findPersonByAge(int age){
		Stream<Person> personStream = getStream(getList());
		return personStream.
			filter(s->(s.getAge() == age));
	} 

	//convert the list to map with age being the key of the map,
	//only storing Person with age >= 25.
	//Values should be in the form of list
	public static void createMap1(Stream<Person> personStream){


		Map<Integer,List<Person>> map = personStream
						.filter(s -> (s.getAge()>=25))
						.collect(
							Collectors.groupingBy(s -> ((Person)s).getAge(),
							Collectors.mapping(s->s, Collectors.toList()))
						);

		for(Map.Entry<Integer, List<Person>> mapEntry: map.entrySet()){
		
			System.out.println("Key : "+mapEntry.getKey());
			for(Person p : mapEntry.getValue()){
				System.out.printf("Name : %s\tAge : %d\n", p.getName(), p.getAge());
			}
		}
		
	}
		
	//convert the list to map with key being a boolean,
	//all ages less <= 25 are false, and all ages > 25 true,
	//Store the Person object as List
	public static void createMap3(Stream<Person> personStream){
		
		Map<Boolean,List<Person>> map = personStream
						.collect(
							Collectors.partitioningBy(s -> (s.getAge()>25))
						);
		for(Map.Entry<Boolean, List<Person>> mapEntry: map.entrySet()){
		
			System.out.println("Key : "+mapEntry.getKey());
			for(Person p : mapEntry.getValue()){
				System.out.printf("Name : %s\tAge : %d\n", p.getName(), p.getAge());
			}
		}
	}

	//convert the list to map with age being the key of the map.
	//Values should be comma separated string if more than one 
	//value maps to the same key
	public static void createMap2(Stream<Person> personStream){
		
		Map<Integer,String> map = personStream
						.collect(
							Collectors.toMap(
								s->((Person)s).getAge(),
								s->((Person)s).getName(),
								(x,y)->x+","+y
							)
						);

		for(Map.Entry<Integer,String> mapEntry : map.entrySet()){
			
			System.out.printf("Key : %d\t%s\n", mapEntry.getKey(), mapEntry.getValue());
				
		}
	}

	//use summarizingDouble and show the stats related to age.
	public static void showStats(Stream<Person> personStream){
		//Similarly, IntSummaryStatistics can also be created using summarizingInt()	
		DoubleSummaryStatistics stats = personStream
						.collect(summarizingDouble(Person::getAge));

		System.out.printf("Max : %f\tMin : %f\tAvg : %f\tCount : %d\n", stats.getMax(),stats.getMin(),stats.getAverage(),stats.getCount());
	}

	public static List<Person> getList(){
		
		Person[] myObjectArray = new Person[]{new Person(28, "Puneet", "3019937834"),
							  new Person(21, "Patrick", "4479908877"),
							  new Person(19, "Pratik", "8097891122"),
							  new Person(30, "Roland", "9098991234"),
							  new Person(40, "Seth", "4049099898"),
							  new Person(50, "Ravindra", "3032021234"),
							  new Person(25, "Chris", "7072029876"),
							  new Person(34, "Steve", "6064048900"),
							  new Person(22, "Matt", "5050009876"),
							  new Person(30, "Steve", "2021019494"),
							  new Person(48, "David", "5559094040"),
							  new Person(38, "Dravid", "5590894040"),
							  new Person(29, "Dan", "5309094040"),
							  new Person(33, "McConnel", "5345094040"),
							  new Person(21, "Anna", "5556894040"),
							  new Person(19, "Angela", "9019094040"),
							  new Person(30, "Victor", "7909094040"),
							  new Person(25, "Zach", "7859094040")};
							  
								
		return Arrays.asList(myObjectArray);
	}

	public static Stream<Person> getStream(List<Person> personList){
		return personList.stream();
	}

	//Split the comma separated String using Stream and store them in map,
	//Key value being the String's first character and 
	//Value being the strings stored in comma separated manner
	public static void splittingStringUsingStream(){
		
		Stream<String>	stringStream = getStringStream();	
		
		Map<Character,String> peopleMap = 
						stringStream
						.collect(
							toMap(s -> s.charAt(0) , 
							s -> s, 
							(x,y) -> (x+","+y)
					     		)
						);

		for(Map.Entry<Character,String> mapEntry : peopleMap.entrySet()){
			System.out.println("Key : "+mapEntry.getKey()+"\tName : "+mapEntry.getValue());
		}
	}

	//concatenate all names that start with P in a colon separated manner
	public static void reduce2(){
		
		Stream<String> stringStream = getStringStream();

			
		Optional<String> allName = stringStream
				.filter(s -> s.startsWith("P"))
				.reduce((p1,p2) -> p1+":"+p2);
	
		System.out.printf("All names starting with P : %s\n", allName.get());
	}

	//find name with highest hashCode()
	public static void reduce1(){
		
		Stream<String> stringStream = getStringStream();

		Optional<String> name = stringStream
				.reduce((x,y) -> x.hashCode() > y.hashCode() ? x : y);
		System.out.println("Name with highest hascode : "+name.get() );
		
	}

	//Sort all the names whose length is 6
	public static void sortNames(){

		System.out.println("Sorted names...");
		Stream<String> stringStream = getStringStream();
		
//		List<String> sortedNamesList = 
						stringStream
						.filter(s -> s.length()==6)
						.sorted((x,y)-> x.compareTo(y))
						.forEach(p -> System.out.printf("%s\n",p));
	}
	
	public static Stream<String> getStringStream(){
		Stream<String> stringStream = Pattern.compile(",").splitAsStream("Puneet,Kaku,David,Christine,Steph,John,Camron,Patrick,Katrina,Maria,George,Dwayne,Nick,Nitin,Sonia,Tanya,Hemant,Ajay,Tanmay,Sudhanshu,Chris,Matt,Bill,Andrew,Edward,Ryan,Nishesh,Shivender,Divya,Deepankar,Devender,Hemraj,Priya,Monica,Garima,Pallavi,Shekhar,Vijay,Victor,Vivek,Shilpa,Prem,Namrata,Rajendra,Ravina,Navjot,Salman,Nimesh,Akshaya,Arriane,Thomas,Robert,Srinivas,Martin,Michael,Michelle,Kamran,Randall,Lakshay,Saksham,Neha,Poonam,Shanky,Amit,Narayan,Anupam,Narendra,Shankar,Sanjay,Ajit,Anay,Vinay,Piyush,Annie,Lauren,Laura,Angela,Sophia,Harbhajan,Randy,Rinshu,Jai,Jitender,Charles,Perry,Elliott,Satish,Tommy,Jeff,Raj,Ramya,Priyanka,Camilo,Prashanta,Shruti,Shravan,Amaira,Bhushan,Bhavana,Rekha,Parkash,Jyoti,Saroj,Devesh,Veena,Sunita,Sujata,Kabir,Aarti,Vanya,Pranav,Premjith,Satyajith,Gaurav,Pooran,Khalid,Oliver,Demetrius,Sahil,Savanah,Cynthia,Elizabeth,Antony,Frank,Ishan,Khali,Gurupreet,Kapil,Virat,Kajol,Bunty,Babloo,Satvik");

		return stringStream;
	}
}
