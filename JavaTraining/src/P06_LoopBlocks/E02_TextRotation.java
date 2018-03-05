package P06_LoopBlocks;

import java.util.Scanner;

public class E02_TextRotation {

	public static void main(String[] args) {
		
		// Opening Console Session with AutoClose
		try(Scanner inConsole = new Scanner(System.in)) {
			
			// Printing info in the console with two new lines
			System.out.println("Inversión de Texto\n");
			
			String value = "";
			// Validation with loop while
			do {
				// Printing info in the console 
				System.out.println("Texto: ");
				// Receiving String info from the user
				value = inConsole.nextLine();
			} while(value.isEmpty());
			
			int maxIndex = value.length() - 1;
			String reverseText = "";
			
			for(int i = 0; i <= maxIndex; i++)
				reverseText += value.charAt(maxIndex - i);
			
			System.out.println("Invertido: ");
			System.out.println(reverseText);	
									
		}
		
	}

}
