package P23_I18N_L10N;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Currency;
import java.util.Locale;

public class E03_NumberFormatCurrency {

	public static void main(String[] args) throws ParseException {
		
		System.out.println("Currency Instance");
		NumberFormat nf = NumberFormat.getCurrencyInstance();
		print("Default: ", nf, 12345678.12345678);
		System.out.println();

		System.out.println("Default Currency");
		Currency cur = nf.getCurrency();
		System.out.println("Currency Code: " + cur.getCurrencyCode());
		System.out.println("Currency Symbol: " + cur.getSymbol(Locale.getDefault()));
		System.out.println("Currency Display Name: " + cur.getDisplayName());
		System.out.println("Currency Fraction Digits: " + cur.getDefaultFractionDigits());
		System.out.println();
		
		nf.setCurrency(Currency.getInstance("USD"));
		print("US Currency: ", nf, 12345678.12345678);
		System.out.println();
		
		System.out.println("Currency Available List");
		Currency.getAvailableCurrencies().forEach(System.out::println);
			
	}
	
	private static void print(String text, NumberFormat nf, double value) throws ParseException {
		System.out.println("---------------------------");
		System.out.println("* " + text);
		String format = nf.format(value);
		System.out.println(">>> Format: " + format);
		Number num = nf.parse(format);
		System.out.println(">>> Parse: " + num);
		System.out.println("---------------------------");
	}
	
}
