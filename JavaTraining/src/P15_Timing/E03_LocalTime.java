package P15_Timing;

import java.time.Clock;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class E03_LocalTime {

	public static void main(String[] args) {
		
		List<LocalTime> times = new ArrayList<>(); 
		
		times.add(LocalTime.now());
		times.add(LocalTime.now(Clock.systemDefaultZone()));
		times.add(LocalTime.now(ZoneId.of("America/Santiago")));
		
		times.add(LocalTime.of(10, 15));
		times.add(LocalTime.of(21, 5, 15));
		times.add(LocalTime.of(21, 10, 15, 111));
		times.add(LocalTime.ofSecondOfDay(10_000));
		times.add(LocalTime.ofNanoOfDay(100_000_000));
		
		times.add(LocalTime.parse("12:30:25.550"));
		
		times.add(LocalTime.now().plusHours(10));
		times.add(LocalTime.now().plusMinutes(10));
		times.add(LocalTime.now().plusSeconds(10));
		times.add(LocalTime.now().plusNanos(10));
		times.add(LocalTime.now().plus(10, ChronoUnit.HOURS));
		
		times.add(LocalTime.now().minusHours(10));
		times.add(LocalTime.now().minusMinutes(10));
		times.add(LocalTime.now().minusSeconds(10));
		times.add(LocalTime.now().minusNanos(10));
		times.add(LocalTime.now().minus(10, ChronoUnit.HOURS));
		
		times.forEach(System.out::println);
		System.out.println();
		
		LocalTime now = LocalTime.now();
		
		System.out.println(now.getHour());
		System.out.println(now.getMinute());
		System.out.println(now.getSecond());
		System.out.println(now.getNano());
		
		System.out.println(now.toNanoOfDay());
		
		LocalTime oneMoment = LocalTime.of(20, 5, 8);
		
		System.out.println(now.isAfter(oneMoment));
		System.out.println(now.isBefore(oneMoment));
		
		oneMoment = oneMoment.withHour(10);
		oneMoment = oneMoment.withMinute(20);
		oneMoment = oneMoment.withSecond(30);
		oneMoment = oneMoment.withNano(40);
		
		System.out.println(oneMoment);
		
		LocalDateTime oneMomentToday = oneMoment.atDate(LocalDate.now());
		
		System.out.println(oneMomentToday);
		
	}

}
