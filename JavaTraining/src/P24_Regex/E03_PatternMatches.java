package P24_Regex;

import java.util.regex.Pattern;

public class E03_PatternMatches {

	public static void main(String[] args) {
		
		// https://regexr.com/
		
		String pattern1 = "[0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5]";
		validate("1", pattern1);
		validate("10", pattern1);
		validate("100", pattern1);
		validate("200", pattern1);
		validate("300", pattern1);
		validate("250", pattern1);
		validate("256", pattern1);
		
		System.out.println();
		
		String pattern2 = "([0-1][0-9]|2[0-3]):([0-5][0-9])";
		validate("10:23", pattern2);
		validate("15:50", pattern2);
		validate("23:00", pattern2);
		validate("05:55", pattern2);
		validate("24:00", pattern2);
		validate("22:65", pattern2);

		System.out.println();
		
		String pattern3 = "(0?[1-9]|[1-2][0-9]|3[0-1])/(0?[1-9]|1[0-2])/[0-9]{4}";
		validate("10/01/1980", pattern3);
		validate("25/2/2015", pattern3);
		validate("7/10/1999", pattern3);
		validate("31/01/2015", pattern3);
		validate("31/02/2015", pattern3);
		validate("10/25/2000", pattern3);
		validate("25/10/82", pattern3);

		System.out.println();
		
		String pattern4 = "([0-9]{1,2}\\.?)?([0-9]{3}\\.?){0,2}-?[0-9k]";
		validate("12.123.123-1", pattern4);
		validate("12.123.123-k", pattern4);
		validate("12123123-1", pattern4);
		validate("123.123-3", pattern4);
		validate("123-2", pattern4);
		validate("123123123-2", pattern4);
		validate("99.999.999-k", pattern4);
		validate("99999999k", pattern4);
		validate("09.009.009-k", pattern4);
		
	}
	
	private static void validate(String value, String pattern) {
		String message = Pattern.matches(pattern, value) ? "Valid" : "Invalid";
		System.out.println(message);
	}

}
