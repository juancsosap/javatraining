package P23_I18N_L10N;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

public class E04_DateFormatter {

	public static void main(String[] args) throws ParseException {
		
		LocalDateTime now = LocalDateTime.now();
		
		DateTimeFormatter formatter;
		
		System.out.println("From Pattern");
		
		formatter = DateTimeFormatter.ofPattern("dd/MMMM/yyyy");
		System.out.println(now.format(formatter));
		
		formatter = DateTimeFormatter.ofPattern("dd/MMM/yyyy");
		System.out.println(now.format(formatter));
		
		formatter = DateTimeFormatter.ofPattern("dd/MM/yy");
		System.out.println(now.format(formatter));
		
		formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
		System.out.println(now.format(formatter));
		
		formatter = DateTimeFormatter.ofPattern("dd/MM/yy HH:mm:ss");
		System.out.println(now.format(formatter));
		
		System.out.println("\nFrom Standard");
		
		formatter = DateTimeFormatter.BASIC_ISO_DATE;
		System.out.println(now.format(formatter));
		
		formatter = DateTimeFormatter.ISO_DATE;
		System.out.println(now.format(formatter));
		
		formatter = DateTimeFormatter.ISO_TIME;
		System.out.println(now.format(formatter));
		
		formatter = DateTimeFormatter.ISO_DATE_TIME;
		System.out.println(now.format(formatter));
		
		System.out.println("\nFrom Style");
		
		formatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL);
		System.out.println(now.format(formatter));
		
		formatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG);
		System.out.println(now.format(formatter));
		
		formatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM);
		System.out.println(now.format(formatter));
		
		formatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT);
		System.out.println(now.format(formatter));
		
		System.out.println("\nWith Locale");
		
		formatter = DateTimeFormatter.ofPattern("dd/MMMM/yyyy");
		formatter = formatter.withLocale(Locale.US);
		System.out.println(now.format(formatter));
		
		formatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL);
		formatter = formatter.withLocale(Locale.US);
		System.out.println(now.format(formatter));
		
		System.out.println("\nFrom String");
		
		DateTimeFormatter iFormatter = DateTimeFormatter.ofPattern("dd/MMMM/yyyy")
				                                        .withLocale(new Locale("es"));
		DateTimeFormatter oFormatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)
				                                        .withLocale(Locale.US);
		LocalDate born = LocalDate.parse("26/marzo/1982", iFormatter);
		System.out.println(born.format(oFormatter));
		
		formatter = DateTimeFormatter.ofPattern("dd/MMMM/yyyy HH:mm:ss");
		LocalDateTime time = LocalDateTime.parse("15/febrero/2018 18:36:15", formatter.withLocale(new Locale("es")));
		System.out.println(time.format(formatter.withLocale(Locale.US)));
	}
		
}
