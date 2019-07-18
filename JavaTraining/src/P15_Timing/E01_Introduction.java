package P15_Timing;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;

public class E01_Introduction {

	public static void main(String[] args) {
		
		LocalDate date = LocalDate.now();
		System.out.println(date);
		
		LocalTime time = LocalTime.now();
		System.out.println(time);
		
		LocalDateTime dateTime = LocalDateTime.now();
		System.out.println(dateTime);
		
	}

}
