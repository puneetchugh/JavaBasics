package com.puneet.chugh;
import java.time.*;
import java.util.Set;
import java.time.temporal.ChronoUnit;
import java.time.format.DateTimeFormatter;
public class MyDateClass{

	public MyDateClass(){

	}
	
	public void setLocalDate(){
		
		LocalDate today = LocalDate.now();
		System.out.println("Today is (Date): "+today);
		LocalDate firstDay_Feb_2018 = LocalDate.of(2018, Month.FEBRUARY, 1);
		System.out.println("First Day of Feb 2018 (Date) : "+firstDay_Feb_2018);	
	
		//Invalid input - Feb 29, 2018
		//LocalDate feb29_2018 = LocalDate.of(2018, Month.FEBRUARY, 29);

		LocalDate todayIST = LocalDate.now(ZoneId.of("Asia/Kolkata"));
		System.out.println("Indian Standard time (Date) : "+todayIST);
		
		LocalDate todayMST = LocalDate.now(ZoneId.of("America/Denver"));
		System.out.println("Mountain Standard time (Date) : "+todayMST);

		LocalDate todayEST = LocalDate.now(ZoneId.of("America/New_York"));
		System.out.println("Eastern Standard time (Date) : "+todayEST);
	
		LocalDate yesterday = LocalDate.now().minusDays(1);
		System.out.println("Yesterday : "+yesterday);
		
		LocalDate aug_30_2017 = LocalDate.of(2017, 8, 30);
		System.out.println("aug_30_2017 : "+aug_30_2017);

		LocalDate july_30_2017 = aug_30_2017.minus(1, ChronoUnit.MONTHS);
		System.out.println("july_30_2017 : "+july_30_2017);
	}

	
	public void setLocalTime(){

		LocalTime localTime = LocalTime.now();
		System.out.println("Local time now : "+localTime);

		LocalTime specificTime = LocalTime.of(14, 20, 50, 80);
		System.out.println("Specific time : "+specificTime);	
	
		//Invalid input - Feb 28, 2018
		//LocalDate feb29_2018 = LocalTime.of(29, 20, 50, 80);

		LocalTime todayIST = LocalTime.now(ZoneId.of("Asia/Kolkata"));
		System.out.println("Indian Standard time  : "+todayIST);
		
		LocalTime todayMST = LocalTime.now(ZoneId.of("America/Denver"));
		System.out.println("Mountain Standard time : "+todayMST);
		
		LocalTime todayEST = LocalTime.now(ZoneId.of("America/New_York"));
		System.out.println("Eastern Standard time : "+todayEST);
	}

	public void setLocalDateTime(){

		LocalDateTime localTime = LocalDateTime.now();
		System.out.println("Local time now : "+localTime);

		LocalDateTime specificTime = LocalDateTime.of(2018, Month.FEBRUARY, 1, 14, 20, 50, 80);
		System.out.println("Specific time : "+specificTime);	
	
		//Invalid input - Feb 28, 2018
		//LocalDate feb29_2018 = LocalDateTime.of(2018, Month.FEBRUARY, 29, 12, 20, 50, 80);

		LocalDateTime todayIST = LocalDateTime.now(ZoneId.of("Asia/Kolkata"));
		System.out.println("Indian Standard time  : "+todayIST);
		
		LocalDateTime todayMST = LocalDateTime.now(ZoneId.of("America/Denver"));
		System.out.println("Mountain Standard time : "+todayMST);

		LocalDateTime todayEST = LocalDateTime.now(ZoneId.of("America/New_York"));
		System.out.println("Eastern Standard time : "+todayEST);

		LocalDateTime anotherSpecificTime = specificTime.minusHours(4).minusMinutes(4).minusSeconds(4);
		System.out.println("anotherSpecificTime : "+anotherSpecificTime); 

		System.out.println("Checking compareTo() method of LocalDateTime"+(localTime.compareTo(specificTime) > 0?"First is more recent time":"Later is more recent time"));
		System.out.println("Checking isAfter() method of LocalDateTime : "+(localTime.isAfter(specificTime)? "First is after the second": "Second is after the first one"));
		System.out.println("Checking isBefore() method of LocalDateTime : "+(localTime.isBefore(specificTime)? "Second is after the first": "First is after the Second"));
	}

	

	public void displayAllTimeZones(){
		
		Set<String> zoneIdSet = ZoneId.getAvailableZoneIds();

		for(String zoneId : zoneIdSet){
			//System.out.printf("Zone Id : "+zoneId.getId());
			System.out.printf("\tZone : "+zoneId+"\n");
		}
	}

	public void format(){
		
		LocalDateTime localDateString = LocalDateTime.parse("2018-09-19T20:30:10");
		System.out.println("localDateString : "+localDateString);

		System.out.println("localDateString format yyyy/MM/dd : "+localDateString.format(DateTimeFormatter.ofPattern("yyyy/MM/dd")));	
		System.out.println("localDateString format dd-MM-yyyy : "+localDateString.format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));	
	}

	public static void main(String[] args){

		MyDateClass myDateClass = new MyDateClass();
		myDateClass.setLocalDate();	

		myDateClass.setLocalTime();
		
		myDateClass.setLocalDateTime();

		myDateClass.displayAllTimeZones();	
		
		myDateClass.format();
	}
}
