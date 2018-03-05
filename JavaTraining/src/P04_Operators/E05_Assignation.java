package P04_Operators;

import java.util.Scanner;

public class E05_Assignation {

	public static void main(String[] args) {
		
		// Opening Console Session with AutoClose
		try(Scanner inConsole = new Scanner(System.in)) {
			
			// Printing info in the console with two new lines
			System.out.println("Calculadora Básica\n");
			
			// Printing info in the console 
			System.out.print("Primer Número: ");
			// Receiving Integer info from the user
			Integer num1 = inConsole.nextInt();
			
			// Printing info in the console 
			System.out.print("Segundo Número: ");
			// Receiving Integer info from the user
			Integer num2 = inConsole.nextInt();
						
			// Printing Operations in the console
			Integer num3 = num1;
			System.out.printf("\nAsignación Simple (=)             : %,d", num3);
			
			System.out.printf("\nAsignación con Suma (+=)          : %,d", num3 += num2);
			System.out.printf("\nAsignación con Resta (-=)         : %,d", num3 -= num2);
			System.out.printf("\nAsignación con Multiplicación (*=): %,d", num3 *= num2);
			System.out.printf("\nAsignación con División (/=)      : %,d", num3 /= num2);
			System.out.printf("\nAsignación con Resto (%%=)         : %,d", num3 %= num2);
			
			System.out.println();
			
			System.out.printf("\nAsignación con XOR Binario (^=)   : %,d", num3 ^= num2);
			System.out.printf("\nAsignación con OR Binario (|=)    : %,d", num3 |= num2);
			System.out.printf("\nAsignación con AND Binario (&=)   : %,d", num3 &= num2);
			
			System.out.println();
			
			System.out.printf("\nPreIncremento (++X)               : %,d", ++num3);
			System.out.printf("\nPreDecremento (--X)               : %,d", --num3);
			System.out.printf("\nPostIncremento (X++)              : %,d", num3++);
			System.out.printf("\nPostDecremento (X--)              : %,d", num3--);
							
		}

	}

}
