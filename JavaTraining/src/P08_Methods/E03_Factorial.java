package P08_Methods;

import java.util.Scanner;

public class E03_Factorial {

	public static void main(String[] args) {
		
		// Opening Console Session with AutoClose
		try(Scanner inConsole = new Scanner(System.in)) {
			
			// Printing info in the console with two new lines
			System.out.println("Calculo de Factorial\n");
			
			// Printing info in the console 
			System.out.print("Número: ");
			// Receiving String info from the user
			int value = inConsole.nextInt();
			
			// Printing Result
			System.out.printf("\nResultado: %,d", factorial(value));
		}
				
	}
	
	// Recursive Method
	private static long factorial(long value) {
		return (value > 1) ? value * factorial(value - 1) : value;
	}

}
