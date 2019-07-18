package netec.oca.getstarted;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Locale;

public class Reloj {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		
		Date d1 = new Date();
		
		LocalDate d2 = LocalDate.now();
		System.out.println(d2);
		
		LocalTime t1 = LocalTime.now();
		System.out.println(t1);
	
		LocalDateTime dt1 = LocalDateTime.now();
		System.out.println(dt1);
		
		LocalDateTime dt2 = LocalDateTime.now(ZoneId.of("Asia/Tokyo"));
		System.out.println(dt2);
		
		LocalDate d3 = LocalDate.ofYearDay(2005, 150);
		System.out.println(d3);
		
		LocalDate d4 = LocalDate.of(2018, 05, 15);
		System.out.println(d4);
		
		LocalDate d5 = LocalDate.of(2018, Month.JULY, 15);
		System.out.println(d5);
		
		LocalDate d6 = LocalDate.parse("2018-06-16");
		System.out.println(d6);
		
		System.out.println(d6.getDayOfWeek());
		System.out.println();
		
		LocalDate d7 = d6.minus(10, ChronoUnit.WEEKS);
		System.out.println(d7);
		
		LocalTime t10 = LocalTime.now();
		
		LocalDateTime dt = LocalDateTime.now();
		
		System.out.println(dt.format(DateTimeFormatter.ofPattern("dd/MM/yyyy", Locale.FRANCE)));
		
	}

}
