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
			char option = inConsole.nextLine().charAt(0);
			
			System.out.print("NUM1: ");
			double num1 = inConsole.nextDouble();
			
			System.out.print("NUM2: ");
			double num2 = inConsole.nextDouble();
			
			System.out.println();
			
			/*
			double result;
            if(option == '1' || option == 's' || option == 'S') result = num1 + num2;
            else if(option == '1' || option == 's' || option == 'S') result = num1 - num2;
            else if(option == '1' || option == 's' || option == 'S') result = num1 * num2;
            else if(option == '1' || option == 's' || option == 'S') result = num1 / num2;
            else result = null;
            System.out.println((result == null) ? "Opción no Valida" : "RESULT: " + result);
			*/

            /*
            System.out.println((option == '1' || option == 's' || option == 'S') ? "RESULT: " + (num1 + num2) :
                               (option == '2' || option == 'r' || option == 'R') ? "RESULT: " + (num1 - num2) :
                               (option == '3' || option == 'm' || option == 'M') ? "RESULT: " + (num1 * num2) :
                               (option == '4' || option == 'd' || option == 'D') ? "RESULT: " + (num1 / num2) : 
                                                                                   "Opción no Valida"));
            */
			
			// Only Integer values are supported (byte, short, int, long, char or enums)
			switch(option) {
				case '1': case 's': case 'S': 
					System.out.println("RESULT: " + (num1+num2));
					break;
				case '2': case 'r': case 'R':
					System.out.println("RESULT: " + (num1-num2));
					break;
				case '3': case 'm': case 'M':
					System.out.println("RESULT: " + (num1*num2));
					break;
				case '4': case 'd': case 'D':
					System.out.println("RESULT: " + (num1/num2));
					break;
				default:
					System.out.println("Opción no Valida");	
			}
			
		}
		
	}

}
