package P01_Console;

import java.util.Scanner;

public class E04_MyMicroSurvey {

	public static void main(String[] args) {
		
		// Opening Console Session with AutoClose
		try(Scanner inConsole = new Scanner(System.in)) {
			
			// Printing info in the console with two new lines
			System.out.println("Encuesta General\n");
			
			// Printing info in the console 
			System.out.print("Nombre Completo: ");
			// Receiving String info from the user
			String name = inConsole.nextLine();
			
			// Printing info in the console 
			System.out.print("Edad (años): ");
			// Receiving String info from the user
			Integer age = inConsole.nextInt();
			
			// Printing info in the console 
			System.out.print("Altura (cm): ");
			// Receiving String info from the user
			Double height = inConsole.nextDouble();
			
			// Printing info in the console with two new lines
			System.out.println("\nGracias por la información suministrada");
			// Printing info saved in the console with TABs 
			System.out.println(name + "\t" + age + " años\t" + height + " cm");
						
		}
				
	}

}
