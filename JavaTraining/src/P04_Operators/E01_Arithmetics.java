package P04_Operators;

import java.util.Scanner;

public class E01_Arithmetics {

	public static void main(String[] args) {
		
		// Opening Console Session with AutoClose
		try(Scanner inConsole = new Scanner(System.in)) {
			
			// Printing info in the console with two new lines
			System.out.println("Calculadora Básica\n");
			
			// Printing info in the console 
			System.out.print("Primer Número: ");
			// Receiving Integer info from the user
			Integer num1 = inConsole.nextInt();
			
			// Printing info in the console 
			System.out.print("Segundo Número: ");
			// Receiving Integer info from the user
			Integer num2 = inConsole.nextInt();
						
			// Printing Operations in the console
			System.out.printf("\nResultado Suma (+): %,d", num1 + num2);
			System.out.printf("\nResultado Resta (-): %,d", num1 - num2);
			System.out.printf("\nResultado Multiplicación (*): %,d", num1 * num2);
			System.out.printf("\nResultado División Entera (/): %,d", num1 / num2);
			System.out.printf("\nResultado Resto Entero (%%): %,d", num1 % num2);
			System.out.printf("\nResultado División Decimal (/): %,.4f", (double) num1 / num2);
						
		}

	}

}
