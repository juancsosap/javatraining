package P04_Operators;

import java.util.Scanner;

public class E04_Binary {

	public static void main(String[] args) {
		
		// Opening Console Session with AutoClose
		try(Scanner inConsole = new Scanner(System.in)) {
			
			// Printing info in the console with two new lines
			System.out.println("Relaciones Básicas\n");
			
			// Printing info in the console 
			System.out.print("Primer Número: ");
			// Receiving Integer info from the user
			Integer num1 = inConsole.nextInt();
			// Printing number in binary
			System.out.println("Primer Número en Binario:  " + Integer.toBinaryString(num1));
			
			// Printing info in the console 
			System.out.print("Segundo Número: ");
			// Receiving Integer info from the user
			Integer num2 = inConsole.nextInt();
			// Printing number in binary
			System.out.println("Segundo Número en Binario: " + Integer.toBinaryString(num2));
						
			// Printing Operations in the console
			System.out.printf("\nNro 1 OR  (|) Nro 2: %d (%s)", num1 | num2, 
					Integer.toBinaryString(num1 | num2));
			System.out.printf("\nNro 1 AND (&) Nro 2: %d (%s)", num1 & num2,
					Integer.toBinaryString(num1 & num2));
			System.out.printf("\nNro 1 XOR (^) Nro 2: %d (%s)", num1 ^ num2,
					Integer.toBinaryString(num1 ^ num2));
			
			System.out.println();
			
			// Printing Operations in the console
			System.out.printf("\nNro 1 Desplazado a la Izquierda 1 posición (<<)          : %d (%s)", num1 << 1, 
					Integer.toBinaryString(num1 << 1));
			System.out.printf("\nNro 1 Desplazado a la Derecha 1 posición (>>)            : %d (%s)", num1 >> 1, 
					Integer.toBinaryString(num1 >> 1));
			System.out.printf("\nNro 1 Desplazado a la Derecha 1 posición sin signo (>>>) : %d (%s)", num1 >>> 1, 
					Integer.toBinaryString(num1 >>> 1));
			System.out.printf("\nComplemento de Nro 1 (~)                                 : %d (%s)", ~num1, 
					Integer.toBinaryString(~num1));			
						
		}

	}

}
