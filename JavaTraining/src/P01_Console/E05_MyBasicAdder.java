package P01_Console;

import java.util.Scanner;

public class E05_MyBasicAdder {

	public static void main(String[] args) {
		
		// Opening Console Session with AutoClose
		try(Scanner inConsole = new Scanner(System.in)) {
			
			// Printing info in the console with two new lines
			System.out.println("Sumadora Básica\n");
			
			// Printing info in the console 
			System.out.print("Primer Número: ");
			// Receiving Integer info from the user
			Integer num1 = inConsole.nextInt();
			
			// Printing info in the console 
			System.out.print("Segundo Número: ");
			// Receiving Integer info from the user
			Integer num2 = inConsole.nextInt();
						
			// Printing info in the console with two new lines
			System.out.print("\nResultado: ");
			// Printing info calculated in the console 
			System.out.println(num1 + num2);
						
		}
				
	}

}
