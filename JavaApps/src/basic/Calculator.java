package basic;

import java.util.Locale;
import java.util.Scanner;
import java.text.NumberFormat;

public class Calculator {
	
	private static String formatInteger(long value) {
		return NumberFormat.getNumberInstance(Locale.GERMANY).format(value);
	}

	private static boolean isInteger(String value) {
		try {
    		Integer.parseInt(value);
    		return true;
    	} catch (NumberFormatException nfe){
    		return false;
    	}
	}
	
	private static String requestData(String dataLabel, String regex, Scanner console) {
		String data = "";
		while(true) {
			System.out.print(dataLabel + ": ");
			data = console.nextLine();
			if(data.matches(regex)) {
				return data;
			} else {
				System.out.println("Invalid " + dataLabel);
			}
		}		
	}
	
	public static void main(String[] args) {
		
		System.out.println("Welcome to the Calculator");
		
		System.out.println("Choose the Operation:");
		System.out.println("(1) Addition");
		System.out.println("(2) Substraction");
		System.out.println("(3) Multiplication");
		System.out.println("(4) Divition");
		
		Scanner console = new Scanner(System.in);
		
		String option = requestData("Option","^([1-4])$",console);
		
		String regex = "^([0-9]+)$";
		String number1_str = requestData("1st Number",regex,console);
		if(option.equals("4")) { regex = "^([1-9][0-9]*)$"; }
		String number2_str = requestData("2nd Number",regex,console);
		
		console.close();
		
		if(isInteger(number1_str) && isInteger(number2_str)) {
			int number1 = Integer.parseInt(number1_str);
			int number2 = Integer.parseInt(number2_str);

			long result = 0;
			switch(option) {
				case "1":
					result = (long)number1 + (long)number2;
					break;
				case "2":
					result = (long)number1 - (long)number2;
					break;
				case "3":
					result = (long)number1 * (long)number2;
					break;
				case "4":
					result = number1 / number2;
					break;
			}
			System.out.println("Result: " + formatInteger(result));
		} else {
			System.out.println("Out of Range Error - Too Big Number");
		}
	
	}

}
