package SimpleCalculator;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner console = new Scanner(System.in);
		
		IntegerNumber num1 = Calculator.getNumber("1st Number: ",console);
		IntegerNumber num2 = Calculator.getNumber("2nd Number: ",console);
		
		System.out.println(getCurrentTimeStamp());
		
		IntegerNumber result = Calculator.add(num1, num2);
		
		System.out.println("Result: " + result.getNumber());
		
		System.out.println(getCurrentTimeStamp());
		
		console.close();

	}
	
	public static String getCurrentTimeStamp() {
	    return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date());
	}

}
