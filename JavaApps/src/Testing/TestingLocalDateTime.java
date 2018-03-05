package Testing;

import java.time.LocalDate;
import java.time.LocalTime;

import static java.time.temporal.TemporalAdjusters.*;
import static java.time.DayOfWeek.*;
import static java.lang.System.out;

import static java.time.temporal.ChronoUnit.*;


public class TestingLocalDateTime {

	public static void main(String[] args) {
		
		LocalDate today, bDate, nowPlusMonth, nextTues;
		today = LocalDate.now();
		out.println("Today: " + today);
		bDate = LocalDate.of(1995, 5, 23); // Java's Birthday
		out.println("Java's Bday: " + bDate);
		out.println("Is Java's Bday in the past? " + bDate.isBefore(today));
		out.println("Is Java's Bday in a leap year? " + bDate.isLeapYear());
		out.println("Java's Bday day of the week: " + bDate.getDayOfWeek());
		nowPlusMonth = today.plusMonths(1);
		out.println("The date a month from now: " + nowPlusMonth);
		nextTues = today.with(next(TUESDAY));
		out.println("Next Tuesday's date: " + nextTues);
		
		out.println();
		
		LocalTime now, nowPlus, nowHrsMins, lunch, bedtime;
	    now = LocalTime.now();
	    out.println("The time now is: " + now);
	    nowPlus = now.plusHours(1).plusMinutes(15);
	    out.println("What time is it 1 hour 15 minutes from now? " + nowPlus);
	    nowHrsMins = now.truncatedTo(MINUTES);
	    out.println("Truncate the current time to minutes: " + nowHrsMins);
	    out.println("It is the " + now.toSecondOfDay()/60 + "th minute");
	    lunch = LocalTime.of(12, 30);
	    out.println("Is lunch in my future? " + lunch.isAfter(now));
	    long minsToLunch = now.until(lunch, MINUTES);
	    out.println("Minutes til lunch: " + minsToLunch);
	    bedtime = LocalTime.of(21, 0);
	    long hrsToBedtime = now.until(bedtime, HOURS);
	    out.println("How many hours until bedtime? " + hrsToBedtime);

	}
  
}