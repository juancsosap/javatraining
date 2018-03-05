package P05_ControlBlocks;

import java.util.Scanner;

public class E01_AgeValidator {

	public static void main(String[] args) {
		
		try(Scanner inConsole = new Scanner(System.in)) {
			
			// Printing info in the console with two new lines
			System.out.println("Información Básica\n");
			
			System.out.print("Favor suministre una edad a verificar: ");
			int age = inConsole.nextInt();
			
			System.out.println();
			
			if(age < 0) {
				System.out.println("ERROR: Las edades no pueden ser negativas.");
			} else if(age > 150) {
				System.out.println("ERROR: Dudamos que exista una persona con tantos años.");
			} else {
				
				if(age < 2)
					System.out.println("Esta edad corresponde a un bebe.");
				else if(age < 12)
					System.out.println("Esta edad corresponde a un niño.");
				else if(age < 20)
					System.out.println("Esta edad corresponde a un adolecente.");
				else if(age < 40)
					System.out.println("Esta edad corresponde a un adulto.");
				else if(age < 70)
					System.out.println("Esta edad corresponde a un adulto mayor.");
				else {
					System.out.println("Esta edad corresponde a un anciano.");
					
					if(age > 90)
						System.out.println("Cuidate y disfruta lo que te queda, que no es mucho.");
				}
					
			}
			
		}
		
	}

}