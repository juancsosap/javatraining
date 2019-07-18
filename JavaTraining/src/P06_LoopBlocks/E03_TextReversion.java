package P06_LoopBlocks;

import java.util.Scanner;

public class E03_TextReversion {

	public static void main(String[] args) {
		
		// Opening Console Session with AutoClose
		try(Scanner inConsole = new Scanner(System.in)) {
			
			// Printing info in the console with two new lines
			System.out.println("Rotación de Texto\n");
			
			String value = "";
			// Validation with loop while
			do {
				// Printing info in the console 
				System.out.println("Texto: ");
				// Receiving String info from the user
				value = inConsole.nextLine();
			} while(value.isEmpty());
			
			int maxIndex = value.length() - 1;
			
			for(int i = 0; i < maxIndex; i++) {
				value = value.charAt(maxIndex) + value.substring(0, maxIndex);
				System.out.println(value);
			}
									
		}
		
	}

}
