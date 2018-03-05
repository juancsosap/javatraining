package P07_Arrays;

import java.util.Scanner;

public class E02_SquareList {

	public static void main(String[] args) {

		try(Scanner inConsole = new Scanner(System.in)) {
			
			// Printing info in the console with two new lines
			System.out.println("Elevador al Cuadrado de Valores\n");
			
			// Requesting the amount of values to be storage
			System.out.print("Número de Valores: ");
			int count = inConsole.nextInt();
		
			// defining the array with the right space
		    int[] values = new int[count];
		    
		    // Requesting each value and storing them in the array
		    System.out.println();
		    for(int i = 0; i < count; i++) {
		    	System.out.print("Valor #" + (i+1) + ": ");
		    	values[i] = inConsole.nextInt();
		    }
		    
		    // Printing the result
		    System.out.println("\nEl cuadrado de los números suministrados es: ");
		    for(int value : values)
		    	System.out.println(value + " : " + value * value);
		
		}

	}

}
