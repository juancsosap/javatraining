package P04_Operators;

import java.util.Scanner;

public class E02_Relational {

	public static void main(String[] args) {
		
		// Opening Console Session with AutoClose
		try(Scanner inConsole = new Scanner(System.in)) {
			
			// Printing info in the console with two new lines
			System.out.println("Relaciones Básicas\n");
			
			// Printing info in the console 
			System.out.print("Primer Número: ");
			// Receiving Integer info from the user
			Integer num1 = inConsole.nextInt();
			
			// Printing info in the console 
			System.out.print("Segundo Número: ");
			// Receiving Integer info from the user
			Integer num2 = inConsole.nextInt();
						
			// Printing Operations in the console
			System.out.printf("\n¿Nro 1 es mayor (>) que Nro 2? %b", num1 > num2);
			System.out.printf("\n¿Nro 1 es mayor o igual (>=) que Nro 2? %b", num1 >= num2);
			System.out.printf("\n¿Nro 1 es menor (<) que Nro 2? %b", num1 < num2);
			System.out.printf("\n¿Nro 1 es menor o igual (<=) que Nro 2? %b", num1 <= num2);
			System.out.printf("\n¿Nro 1 es igual (==) que Nro 2? %b", num1 == num2);
			System.out.printf("\n¿Nro 1 es diferente (!=) que Nro 2? %b", num1 != num2);
						
		}

	}

}
