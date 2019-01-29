package com.puneet.chugh;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.Duration;
import java.time.Period;
import java.time.ZoneId;
import java.util.Set;
public class MyDateTime{

	public static void main(String[] args){

		localDate();
		System.out.println("");
		localTime();	
		System.out.println("");
		localDateTime();
		System.out.println("");
		dateTimeFormatter();
		System.out.println("");
		extraDateTimeComponents();	
	}

	public static void localDate(){

		LocalDate now = LocalDate.now();
		System.out.printf("Local Date Now : %s\n", now);
		System.out.printf("Now minus 1 day : %s\n", now.minusDays(1));
		System.out.printf("Get dayOfWeek for Now : %s\n", now.getDayOfWeek());

		LocalDate date1 = LocalDate.parse("2015-08-23");
		System.out.printf("date1 : %s\n", date1);
		System.out.printf("date1 plus 1 year : %s\n", date1.plusYears(1));
		System.out.printf("Get dayOfYear for date1 : %d\n", date1.getDayOfYear());

		LocalDate date2 = LocalDate.of(1990, 8, 23);
		System.out.printf("date2 : %s\n", date2);
		System.out.printf("date2 plus 2 Week : %s\n", date2.plusWeeks(2));
		System.out.printf("date2 dayOfMonth for date2 : %d\n", date2.getDayOfMonth());

		//Using ChronoUnit
		System.out.printf("date2 after minus 1 month ChronoUnit : %s\n", date2.minus(1, ChronoUnit.MONTHS));
		
		System.out.println("is date2 before date1 : "+date2.isBefore(date1));
		System.out.println("is date1 a leap year : "+date1.isLeapYear());
	}

	public static void localTime(){
		
		LocalTime now = LocalTime.now();
		System.out.printf("LocalTime Now : %s\n", now);
		System.out.printf("Now minus 1 hour : %s\n", now.minusHours(1));
		System.out.printf("Get hour for Now : %s\n", now.getHour());
		
		LocalTime time1 = LocalTime.parse("19:23:50");
		System.out.printf("time1 : %s\n", time1);
		System.out.printf("time1 plus 24 seconds : %s\n", time1.plusSeconds(24));
		System.out.printf("time1 plus 67 minutes : %s\n", time1.plusMinutes(67));
		
		LocalTime time2 = LocalTime.of(12, 23, 55);
		System.out.printf("time2 : %s\n", time2);
		System.out.printf("time2 plus nano : %s\n", time2.plusNanos(4444));
		
		System.out.println("is time1 before time2 : "+time1.isBefore(time2));

		System.out.printf("time1 plus 4 hours ChoronoUnit : %s\n", time1.plus(1, ChronoUnit.HOURS));
	}

	public static void localDateTime(){
		
		LocalDateTime now = LocalDateTime.now();
		System.out.printf("LocalDateTime Now : %s",now);
		System.out.printf("Now plus 1 day : %s\n", now.plusDays(1));
		System.out.printf("Now minus 1 hour : %s\n", now.minusHours(1));
	}

	public static void dateTimeFormatter(){
		LocalDateTime now = LocalDateTime.now();
		
		System.out.printf("LocalDateTime Now : %s",now);
		System.out.printf("Now plus 1 day : %s\n", now.plusDays(1));
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy M dd hh:mm:ss.SS");
		DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("yyyy MM dd hh:mm:ss.SS");
		DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy MMM dd hh:mm:ss.SS");
		DateTimeFormatter formatter3 = DateTimeFormatter.ofPattern("yyyy LLL dd hh:mm:ss.SS");
		DateTimeFormatter formatter33 = DateTimeFormatter.ofPattern("yyyy MM dd HH:mm:ss.SS");
		
		System.out.printf("Now after formatting : %s\n", now.format(formatter));
		System.out.printf("Now after formatting : %s\n", now.format(formatter1));
		System.out.printf("Now after formatting : %s\n", now.format(formatter2));
		System.out.printf("Now after formatting : %s\n", now.format(formatter3));
		System.out.printf("Now after formatting : %s\n", now.format(formatter33));

		DateTimeFormatter formatter4 = DateTimeFormatter.BASIC_ISO_DATE;
		DateTimeFormatter formatter5 = DateTimeFormatter.ISO_DATE;
		DateTimeFormatter formatter6 = DateTimeFormatter.ISO_LOCAL_DATE;
		
		System.out.printf("Now after formatting : %s\n", now.format(formatter4));
		System.out.printf("Now after formatting : %s\n", now.format(formatter5));
		System.out.printf("Now after formatting : %s\n", now.format(formatter6));
	}

	//This will have period, instant, duration
	public static void extraDateTimeComponents(){
		
		LocalTime initialTime = LocalTime.of(17, 7, 56);
		LocalTime finalTime = initialTime.plus(Duration.ofSeconds(50));
		System.out.printf("local time : %s\n", finalTime);
		System.out.printf("duration between intialTime and localTime : %d\n", Duration.between(finalTime, initialTime).getSeconds());

		Set<String> allZoneIds = ZoneId.getAvailableZoneIds();
		
		ZoneId zoneId = ZoneId.of("Europe/Paris");
		ZoneId zoneId1 = ZoneId.of("Asia/Kolkata");
		
		LocalTime currentTimeInParis = LocalTime.now(zoneId);
		System.out.printf("Local time in Paris : %s\n", currentTimeInParis);

		LocalDate parisDate = LocalDate.now(zoneId);
		Period period = Period.ofDays(3);
		
		LocalDate here = LocalDate.now();
		Period period1 = Period.between(parisDate,here);
		System.out.printf("Period between paris and here dates is : %d\n", period1.getDays());

		
	}

	
}
