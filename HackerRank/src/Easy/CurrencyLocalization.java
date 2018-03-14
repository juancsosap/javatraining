package Easy;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class CurrencyLocalization {

	public static void main(String[] args) {
		try(Scanner scanner = new Scanner(System.in)){
			double payment = scanner.nextDouble();
			
			Locale usLocale = Locale.US;
			Locale inLocale = new Locale("en", "in");
			Locale chLocale = Locale.CHINA;
			Locale frLocale = Locale.FRANCE;
			
			String us = NumberFormat.getCurrencyInstance(usLocale).format(payment);
			String india = NumberFormat.getCurrencyInstance(inLocale).format(payment);
			String china = NumberFormat.getCurrencyInstance(chLocale).format(payment);
			String france = NumberFormat.getCurrencyInstance(frLocale).format(payment);
			
			System.out.println("US: " + us);
	        System.out.println("India: " + india);
	        System.out.println("China: " + china);
	        System.out.println("France: " + france);
		}
	}

}
