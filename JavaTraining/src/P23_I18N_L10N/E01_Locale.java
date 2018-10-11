package P23_I18N_L10N;

import java.util.Arrays;
import java.util.Locale;

public class E01_Locale {

	public static void main(String[] args) {
		
		Locale enLocale = Locale.ENGLISH;
		printLocale(enLocale);
		
		Locale esLocale = new Locale("es");
		printLocale(esLocale);
		
		Locale usLocale = Locale.US;
		printLocale(usLocale);
		
		Locale clLocale = new Locale("es","CL");
		printLocale(clLocale);
		
		Locale defaultLocale = Locale.getDefault();
		printLocale(defaultLocale);
		
		System.out.println();
		
		System.out.println("LANGUAGES");
		Arrays.asList(Locale.getISOLanguages()).forEach(System.out::println);
		
		System.out.println("COUNTRIES");
		Arrays.asList(Locale.getISOCountries()).forEach(System.out::println);
		
		System.out.println("LANGUAGES");
		Arrays.asList(Locale.getAvailableLocales()).forEach(E01_Locale::printLocale);
		
		System.out.println();
		
		Locale.setDefault(usLocale);
		printLocale(Locale.getDefault());
		
	}
	
	private static void printLocale(Locale locale) {
		String text = String.format("%s [%s] / %s [%s]", locale.getDisplayLanguage(), 
				                                         locale.getLanguage(),
				                                         locale.getDisplayCountry(),
				                                         locale.getCountry());
		System.out.println(text);
	}
	
}
