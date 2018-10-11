package P15_Timing;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class E06_Period {

	public static void main(String[] args) {
		
		LocalDate now = LocalDate.now();
				
		System.out.println(now);
		
		LocalDate later = now.plus(Period.ofMonths(10));
		
		System.out.println(Period.between(now, later).getMonths());
		System.out.println(ChronoUnit.DAYS.between(now, later));
		
	}

}
