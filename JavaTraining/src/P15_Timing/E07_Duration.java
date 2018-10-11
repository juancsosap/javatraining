package P15_Timing;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class E07_Duration {

	public static void main(String[] args) {
		
		LocalDateTime now = LocalDateTime.now();
				
		System.out.println(now);
		
		LocalDateTime later = now.plus(Duration.ofHours(10));
		
		System.out.println(Duration.between(now, later).toMinutes());
		System.out.println(ChronoUnit.HOURS.between(now, later));
		
	}

}
