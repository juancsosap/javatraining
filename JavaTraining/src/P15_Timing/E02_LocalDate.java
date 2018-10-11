package P15_Timing;

import java.time.Clock;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class E02_LocalDate {

	public static void main(String[] args) {
		
		List<LocalDate> dates = new ArrayList<>(); 
		
		dates.add(LocalDate.now());
		dates.add(LocalDate.now(Clock.systemDefaultZone()));
		dates.add(LocalDate.now(ZoneId.of("America/Santiago")));
		
		ZoneId.getAvailableZoneIds().stream().filter(z -> z.startsWith("America")).forEach(System.out::println);
		System.out.println();
		
		dates.add(LocalDate.of(2000, 1, 1));
		dates.add(LocalDate.of(2010, Month.MARCH, 15));
		dates.add(LocalDate.ofYearDay(1950, 100));
		
		dates.add(LocalDate.parse("1999-09-09"));
		
		dates.add(LocalDate.now().plusYears(10));
		dates.add(LocalDate.now().plusMonths(10));
		dates.add(LocalDate.now().plusWeeks(10));
		dates.add(LocalDate.now().plusDays(10));
		dates.add(LocalDate.now().plus(10, ChronoUnit.DAYS));
		
		dates.add(LocalDate.now().minusYears(10));
		dates.add(LocalDate.now().minusMonths(10));
		dates.add(LocalDate.now().minusWeeks(10));
		dates.add(LocalDate.now().minusDays(10));
		dates.add(LocalDate.now().minus(10, ChronoUnit.DAYS));
		
		dates.forEach(System.out::println);
		System.out.println();
		
		LocalDate today = LocalDate.now();
		
		System.out.println(today.getDayOfWeek());
		System.out.println(today.getDayOfMonth());
		System.out.println(today.getDayOfYear());
		
		System.out.println(today.getMonthValue());
		System.out.println(today.getMonth());
		
		System.out.println(today.getYear());
		
		System.out.println(today.isLeapYear());
		
		LocalDate oneDay = LocalDate.of(2018, 5, 8);
		
		System.out.println(today.isAfter(oneDay));
		System.out.println(today.isBefore(oneDay));
		
		oneDay = oneDay.withDayOfMonth(5);
		oneDay = oneDay.withMonth(10);
		oneDay = oneDay.withYear(2015);
		
		System.out.println(oneDay);
		
		LocalDateTime oneDayStarting = oneDay.atStartOfDay();
		
		System.out.println(oneDayStarting);
		
		System.out.println(oneDay.atTime(10, 20));
		System.out.println(oneDay.atTime(10, 20, 30));
		System.out.println(oneDay.atTime(10, 20, 30, 40));
		
		System.out.println(oneDay.lengthOfMonth());
		System.out.println(oneDay.lengthOfYear());
		
	}

}
