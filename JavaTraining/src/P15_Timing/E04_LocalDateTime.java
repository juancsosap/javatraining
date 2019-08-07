package P15_Timing;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

public class E04_LocalDateTime {

	public static void main(String[] args) {
		
		LocalDateTime dateTime = LocalDateTime.now();
				
		System.out.println(dateTime.toLocalDate());
		System.out.println(dateTime.toLocalTime());
		
		System.out.println(dateTime.format(DateTimeFormatter.ofPattern("dd/MMMM/yyyy")));
		
		System.out.println(dateTime.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL).withLocale(Locale.FRANCE)));
		System.out.println(dateTime.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL).withLocale(Locale.ITALY)));
		System.out.println(dateTime.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL).withLocale(Locale.US)));
	}

}
