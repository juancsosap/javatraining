package SimpleCalculator;

import java.util.Scanner;

public class Calculator {
	
	public static final int OVER_VALUE = 1000000000;
	
	public static IntegerNumber getNumber(String text, Scanner console, NumberRegex regex){
		boolean valid;
		IntegerNumber num = new IntegerNumber();
		do {
			System.out.print(text);
			String value = console.nextLine();
			valid = IntegerNumber.isValid(value, regex);
			if(valid) {
				num.setNumber(value, regex);
			}
		} while(!valid);
		return num;
	}
	
	public static IntegerNumber getNumber(String text, Scanner console){
		return Calculator.getNumber(text, console, NumberRegex.UNSIGNED_INTEGER);
	}
	
	public static int longest(IntegerNumber num1, IntegerNumber num2) {
		if(num1.length() > num2.length()) {
			return num1.length();
		} else {
			return num2.length();
		}
	}
	
	// Initially only works with positive numbers
	public static IntegerNumber add(IntegerNumber num1, IntegerNumber num2) {
		IntegerNumber result = new IntegerNumber();
		int digits = longest(num1,num2);
		num1.addZeros(digits);
		num2.addZeros(digits);
		int over = 0;
		
		for(; digits > 0; digits -= 9) {
			int iIndex = 0;
			if(digits >= 9) { iIndex = digits - 9; }
			
			int num1_int = num1.toInt(iIndex, digits);
			int num2_int = num2.toInt(iIndex, digits);
			int result_int = num1_int + num2_int + over;
			
			if(result_int >= Calculator.OVER_VALUE) {
				over = 1;
				result_int -= Calculator.OVER_VALUE;
			} else {
				over = 0;
			}
			
			if(!result.isNull()) {
				result.setNumber(result_int + result.getNumber(false));
			} else {
				result.setNumber(result_int);
			}
		}
		
		if(over == 1) {
			result.setNumber(1 + result.getNumber(false));
		}
		return result;
	}
	
}
