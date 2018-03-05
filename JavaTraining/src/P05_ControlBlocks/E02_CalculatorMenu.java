package P05_ControlBlocks;

import java.util.Scanner;

public class E02_CalculatorMenu {

	public static void main(String[] args) {
		
		try(Scanner inConsole = new Scanner(System.in)) {
			
			// Printing info in the console with two new lines
			System.out.println("Calculadora Básica\n");
			
			System.out.println("Seleccione la operación a realizar:");
			System.out.println("1. Suma");
			System.out.println("2. Resta");
			System.out.println("3. Multiplicación");
			System.out.println("4. División");
			
			System.out.println();
			
			System.out.print("Opción: ");
			int option = inConsole.nextInt();
			
			if(option > 0 && option < 5) {
				
				System.out.print("NUM1: ");
				double num1 = inConsole.nextDouble();
				
				System.out.print("NUM2: ");
				double num2 = inConsole.nextDouble();
				
				System.out.println();
				
				switch(option) {
					case 1:
						num1 += num2;
						break;
					case 2:
						num1 -= num2;
						break;
					case 3:
						num1 *= num2;
						break;
					case 4:
						num1 /= num2;
						break;
				}
				
				System.out.println("RESULT: " + num1);
				
			} else {
				System.out.println("Opción no Valida");
			}
			
		}
		
	}

}
