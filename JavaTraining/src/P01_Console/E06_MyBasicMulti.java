package P01_Console;

import java.util.Scanner;

public class E06_MyBasicMulti {

	public static void main(String[] args) {
		
		// Opening Console Session with AutoClose
		try(Scanner inConsole = new Scanner(System.in)) {
			
			// Printing info in the console with two new lines
			System.out.println("Multiplicador Básico\n");
			
			// Printing info in the console 
			System.out.print("Primer Número: ");
			// Receiving Integer info from the user
			Double num1 = inConsole.nextDouble();
			
			// Printing info in the console 
			System.out.print("Segundo Número: ");
			// Receiving Integer info from the user
			Double num2 = inConsole.nextDouble();
						
			// Printing info in the console with two new lines
			System.out.printf("%nResultado: %.2f%n",num1 * num2);
			
			// Printing info in the console with two new lines
			System.out.println("\nPara más información sobre formatos favor referirse al link:");	
			System.out.println("\u25BA https://docs.oracle.com/javase/tutorial/java/data/numberformat.html");
						
		}
				
	}

}
