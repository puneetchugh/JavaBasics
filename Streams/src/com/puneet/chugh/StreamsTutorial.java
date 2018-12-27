//1. If a stream is operated once by terminal operation, then it is said to be consumed

package com.puneet.chugh;
import java.util.stream.Stream;
import java.util.*;
import java.util.Map.*;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.*;
import java.util.function.Function;
import java.util.regex.Pattern;

public class StreamsTutorial{

	public static void main(String[] args){

		Stream<Person> personStream = createStream(getList());
		printTerminalOperation(ageFilterOperation(personStream));

		personStream = createStream(getList());
		printTerminalOperationString(mapNamesOperation(personStream));	
	
		personStream = createStream(getList());
		printTerminalOperationString(mapNamesOperationUpperCase(personStream));	

		personStream = createStream(getList());
		usingAgeForFilter(personStream);

		flattenMap();

		personStream = createStream(getList());
		usingPeek(personStream);

		personStream = createStream(getList());
		usingTerminalSum(personStream);

		personStream = createStream(getList());
		usingTerminalReduce(personStream);

		personStream = createStream(getList());
		usingIntermediateSort(personStream);

		splittingStringUsingStream();

		personStream = createStream(getList());
		getBasicStats(personStream);

		groupingAndMappingUsingStream();
	}

	public static void printTerminalOperationString(Stream<String> personNameStream){
		personNameStream.forEach(System.out::println);
	}
	
	public static void printTerminalOperation(Stream<Person> personStream){
		personStream.forEach(s -> System.out.println("Name : "+s.getName()+"\t  Age : "+s.getAge()));
	}

	public static Stream<Person> ageFilterOperation(Stream<Person> personStream){
		System.out.println("Filtering out people of age under 30");
		return personStream
			.filter(s-> s.getAge() > 30);
	}

	public static Stream<String> mapNamesOperation(Stream<Person> personStream){
		System.out.println("Creating map of names from the Stream of Person(s)");
		return personStream
			.map(s -> s.getName());
	}

	public static Stream<String> mapNamesOperationUpperCase(Stream<Person> personStream){
		System.out.println("Creating map of names from the Stream of Person(s)");
		return		personStream
				.map(s -> s.getName())
				.map(String::toUpperCase);
	}

	public static void getBasicStats(Stream<Person> personStream){
		
		System.out.println("DoubleSummaryStatistics...");
		DoubleSummaryStatistics stats = 
			personStream
			.collect(summarizingDouble(Person::getAge));
		System.out.println("Max Age : "+stats.getMax());
		System.out.println("Min Age : "+stats.getMin());
		System.out.println("Avg Age : "+stats.getAverage());
		System.out.println("Total people : "+stats.getCount());
		
		System.out.println("Sum of Ages : "+stats.getSum());
	}
		
	public static void usingAgeForFilter(Stream<Person> personStream){
		System.out.println("Finding the person with age 21/50/40");	
		Integer[] ages = {21, 50, 40};

				Stream.of(ages)
				      .map(StreamsTutorial::findPersonByAge)
				      .filter(p -> p != null)
				      .findFirst()
				      .orElse(null)
				      .forEach(s->System.out.println("Name : "+s.getName()+"\tAge : "+s.getAge()));
	}

	public static void groupingAndMappingUsingStream(){

		System.out.println("Creating List using Stream..");
		String namesString = "Puneet,Kaku,David,Christine,Steph,John,Camron,Patrick,Katrina,Maria,George,Dwayne,Nick,Nitin,Sonia,Tanya,Hemant,Ajay,Tanmay,Sudhanshu,Chris,Matt,Bill,Andrew,Edward,Ryan,Nishesh,Shivender,Divya,Deepankar,Devender,Hemraj,Priya,Monica,Garima,Pallavi,Shekhar,Vijay,Victor,Vivek,Shilpa,Prem,Namrata,Rajendra,Ravina,Navjot,Salman,Nimesh,Akshaya,Arriane,Thomas,Robert,Srinivas,Martin,Michael,Michelle,Kamran,Randall,Lakshay,Saksham,Neha,Poonam,Shanky,Amit,Narayan,Anupam,Narendra,Shankar,Sanjay,Ajit,Anay,Vinay,Piyush,Annie,Lauren,Laura,Angela,Sophia,Harbhajan,Randy,Rinshu,Jai,Jitender,Charles,Perry,Elliott,Satish,Tommy,Jeff,Raj,Ramya,Priyanka,Camilo,Prashanta,Shruti,Shravan,Amaira,Bhushan,Bhavana,Rekha,Parkash,Jyoti,Saroj,Devesh,Veena,Sunita,Sujata,Kabir,Aarti,Vanya,Pranav,Premjith,Satyajith,Gaurav,Pooran,Khalid,Oliver,Demetrius,Sahil,Savanah,Cynthia,Elizabeth,Antony,Frank,Ishan,Khali,Gurupreet,Kapil,Virat,Kajol,Bunty,Babloo,Satvik";
		Stream<String> stringStream = Pattern.compile(",").splitAsStream(namesString);
		
		List<String> peopleList = stringStream
						.filter(s -> s.startsWith("P"))
						.collect(toList());
		System.out.println("Filtered list after pruning the names that start with P");
		for(String person : peopleList){
			System.out.println(person);
		} 

		//groupingBy() and mapping() can divide the stream into multiple lists
		//based on the criteria mentioned in groupingBy()
		stringStream = Pattern.compile(",").splitAsStream(namesString);
		Map<Character,List<String>> namesMap = stringStream
							.collect(
							Collectors.groupingBy(s-> new Character(s.charAt(0)),
							Collectors.mapping(s->s, Collectors.toList())));
		for(Map.Entry<Character,List<String>> entry : namesMap.entrySet()){
			System.out.println("Printing names starting with : "+entry.getKey());
			for(String name : entry.getValue()){
				System.out.printf("%s\t", name);
			}
			System.out.println("");
		}
		
		//partitioningBy() can only divide the stream into 2 lists
		//based on the criteria mentioned in partitioningBy()
		stringStream = Pattern.compile(",").splitAsStream(namesString);
		Map<Boolean, List<String>> namesMap2 = stringStream
							.collect(
								Collectors.partitioningBy(s -> (findAscii(s)%2 == 0))
							);
		for(Map.Entry<Boolean,List<String>> entry : namesMap2.entrySet()){
			System.out.println("Printing names with asicii sum even : "+entry.getKey());
			for(String name : entry.getValue()){
				System.out.printf("%s\t", name);
			}
			System.out.println("");
		}
						
	}

	public static void splittingStringUsingStream(){
		
		Stream<String> stringStream = Pattern.compile(",").splitAsStream("Puneet,Kaku,David,Christine,Steph,John,Camron,Patrick,Katrina,Maria,George,Dwayne,Nick,Nitin,Sonia,Tanya,Hemant,Ajay,Tanmay,Sudhanshu,Chris,Matt,Bill,Andrew,Edward,Ryan,Nishesh,Shivender,Divya,Deepankar,Devender,Hemraj,Priya,Monica,Garima,Pallavi,Shekhar,Vijay,Victor,Vivek,Shilpa,Prem,Namrata,Rajendra,Ravina,Navjot,Salman,Nimesh,Akshaya,Arriane,Thomas,Robert,Srinivas,Martin,Michael,Michelle,Kamran,Randall,Lakshay,Saksham,Neha,Poonam,Shanky,Amit,Narayan,Anupam,Narendra,Shankar,Sanjay,Ajit,Anay,Vinay,Piyush,Annie,Lauren,Laura,Angela,Sophia,Harbhajan,Randy,Rinshu,Jai,Jitender,Charles,Perry,Elliott,Satish,Tommy,Jeff,Raj,Ramya,Priyanka,Camilo,Prashanta,Shruti,Shravan,Amaira,Bhushan,Bhavana,Rekha,Parkash,Jyoti,Saroj,Devesh,Veena,Sunita,Sujata,Kabir,Aarti,Vanya,Pranav,Premjith,Satyajith,Gaurav,Pooran,Khalid,Oliver,Demetrius,Sahil,Savanah,Cynthia,Elizabeth,Antony,Frank,Ishan,Khali,Gurupreet,Kapil,Virat,Kajol,Bunty,Babloo,Satvik");

		Map<Integer,String> peopleMap = 
			stringStream
			.collect(
				toMap(s -> findAscii(s), s -> s, (x,y)-> (x+","+y))
			);

		for(Map.Entry<Integer,String> mapEntry : peopleMap.entrySet()){
			System.out.println("Key : "+mapEntry.getKey()+"\tName : "+mapEntry.getValue());
		}
	}

	public static int findAscii(String string){

		char[] stringChar = string.toCharArray();
		int ascii = 0;
		for(char character : stringChar){
			ascii+=character;
		}
		return ascii;
	}

	public static void usingIntermediateSort(Stream<Person> personStream){
		System.out.println("Names after sorting");
		personStream
			.sorted((p1,p2) -> p1.getName().compareTo(p2.getName()))
			.forEach(p -> System.out.println(p.getName()));
	}
	
	public static void usingTerminalSum(Stream<Person> personStream){
		System.out.println("Using Terminal Operation");
		int sum = personStream
				.filter(p -> p.getName().startsWith("P"))
				.mapToInt(p -> p.getAge())
				.sum();
		System.out.println("Sum of ages : "+sum);
	}

	public static void usingTerminalReduce(Stream<Person> personStream){
		System.out.println("Using Terminal Reduce Operation");
		//Optional<Integer> optionalInt = 
				personStream
				.filter(p -> (p.getAge()>25 && p.getAge()<45))
				.map(p -> p.getAge())
				.reduce(((x,y)-> x+y))
				.ifPresent(System.out::println);
	}

	public static void usingPeek(Stream<Person> personStream){
		personStream
			.peek(p -> p.incrementAge(10))
			.filter(p -> p.getAge()>40)
			.forEach(p -> System.out.println("Name : "+p.getName()+"\tAge: "+p.getAge()));
	}
	
	public static void flattenMap(){
		System.out.println("Flatten a map");
		List<List<String>> twoLevelList = Arrays.asList(
							Arrays.asList("Puneet", "Chugh"),
							Arrays.asList("Pankaj", "Sharma"),
							Arrays.asList("Viridian", "Bush")
								);
		List<String> oneLevelList = twoLevelList.stream()
						.flatMap(Collection::stream)
						.collect(Collectors.toList());

		for(String string : oneLevelList){
			System.out.println(string);
		}
		
	}

	public static Stream<Person> findPersonByAge(int age){
		Stream<Person> personStream = createStream(getList());
		return personStream.
			filter(s->(s.getAge() == age));
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
							  new Person(48, "David", "5559094040")};

		return Arrays.asList(myObjectArray);
	}

	public static Stream<Person> createStream(List<Person> personList){
		return personList.stream();
	}

}
