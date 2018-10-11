package P23_I18N_L10N;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class E02_NumberFormat {

	public static void main(String[] args) throws ParseException {
		
		System.out.println("Instance");
		print("Default: ", NumberFormat.getInstance(), 12345678.12345678);
		print("US Locale: ", NumberFormat.getInstance(Locale.US), 12345678.12345678);
		System.out.println();
		
		System.out.println("Currency Instance");
		print("Default: ", NumberFormat.getCurrencyInstance(), 12345678.12345678);
		print("UK Locale: ", NumberFormat.getCurrencyInstance(Locale.UK), 12345678.12345678);
		System.out.println();

		System.out.println("Integer Instance");
		print("Default: ", NumberFormat.getIntegerInstance(), 12345678.12345678);
		print("FRANCE Locale: ", NumberFormat.getIntegerInstance(Locale.FRANCE), 12345678.12345678);
		System.out.println();

		System.out.println("Number Instance");
		print("Default: ", NumberFormat.getNumberInstance(), 12345678.12345678);
		print("CHINA Locale: ", NumberFormat.getNumberInstance(Locale.CHINA), 12345678.12345678);
		System.out.println();

		System.out.println("Percentage Instance");
		print("Default: ", NumberFormat.getPercentInstance(), 0.12345678);
		print("FRANCE Locale: ", NumberFormat.getPercentInstance(Locale.FRANCE), 0.12345678);
		System.out.println();
		
		System.out.println("Default Config");
		printConfig(NumberFormat.getInstance());
		System.out.println();
		
		System.out.println("Custom Config");
		NumberFormat nf = setConfig(NumberFormat.getInstance(), 3, 2, 4, 2);
		printConfig(nf);
		print("Configured MAX: ", nf, 12345678.12345678);
		print("Configured MIN: ", nf, 0.1);
			
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
	
	private static NumberFormat setConfig(NumberFormat nf, 
			                              int maxInt, int minInt, 
			                              int maxFrac, int minFrac) {
		nf.setMaximumIntegerDigits(maxInt);
		nf.setMinimumIntegerDigits(minInt);
		nf.setMaximumFractionDigits(maxFrac);
		nf.setMinimumFractionDigits(minFrac);
		return nf;
	}
	
	private static void printConfig(NumberFormat nf) {
		System.out.println("---------------------------");
		System.out.println("Max Int: " + nf.getMaximumIntegerDigits());
		System.out.println("Min Int: " + nf.getMinimumIntegerDigits());
		System.out.println("Max Frac: " + nf.getMaximumFractionDigits());
		System.out.println("Min Frac: " + nf.getMinimumFractionDigits());
		System.out.println("---------------------------");
	}
	
}
