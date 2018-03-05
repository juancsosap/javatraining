package P01_Console;

import java.util.Scanner;

public class E02_MyFirstGreeting {

	public static void main(String[] args) {
		
		// Opening Console Session
		Scanner inConsole = new Scanner(System.in);
			
		// Printing info in the console 
		System.out.print("Nombre Completo: ");
		// Receiving String info from the user
		String name = inConsole.nextLine();
		
		// Printing info in the console 
		System.out.print("Pais de Procedencia: ");
		
		// Printing info in the console with two new lines
		System.out.print("Gracias " + name + " de " + inConsole.nextLine() + 
				" por la información suministrada, seguiremos aprendiendo.");
		
		inConsole.close();
										
	}

}
