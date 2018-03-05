package P06_LoopBlocks;

import java.util.Scanner;

public class E01_UserInputValidation {

	public static void main(String[] args) {
		
		// Opening Console Session with AutoClose
		try(Scanner inConsole = new Scanner(System.in)) {
			
			// Printing info in the console with two new lines
			System.out.println("Encuesta General\n");
			
			String name = "";
			boolean validInput = false;
			// Validation with loop while
			while(!validInput) {
				// Printing info in the console 
				System.out.print("Nombre Completo: ");
				// Receiving String info from the user
				name = inConsole.nextLine();
				
				validInput = name.length() > 3;
				
				if(!validInput)
					System.out.println("Valor ingresado no valido");
			}
			
			Integer age = 0;
			// Validation with loop do/while
			do {
				// Printing info in the console 
				System.out.print("Edad (años): ");
				// Receiving String info from the user
				age = inConsole.nextInt();
				
				validInput = (age > 0 && age < 250);
				
				if(!validInput)
					System.out.println("Valor ingresado no valido");
			} while(!validInput);
			
			Double height = 0.0;
			// Validation with loop for
			for(validInput = false; !validInput; ) {
				// Printing info in the console 
				System.out.print("Altura (cm): ");
				// Receiving String info from the user
				height = inConsole.nextDouble();
				
				validInput = (height > 20 && height < 300);
				
				if(!validInput)
					System.out.println("Valor ingresado no valido");
			}
				
			// Printing info in the console with two new lines
			System.out.println("\nGracias por la información suministrada");
			// Printing info saved in the console with TABs 
			System.out.println(name + "\t" + age + " años\t" + height + " cm");
						
		}
		
	}

}
