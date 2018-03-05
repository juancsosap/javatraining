package P06_LoopBlocks;

import java.util.Scanner;

public class E04_NumberVerification {

	public static void main(String[] args) {
		
		final int _0CODE = '0';
		final int _9CODE = '9';
		
		// Opening Console Session with AutoClose
		try(Scanner inConsole = new Scanner(System.in)) {
			
			// Printing info in the console with two new lines
			System.out.println("Verificar Número Entero Positivo\n");
			
			String value = "";
			// Validation with loop while
			do {
				// Printing info in the console 
				System.out.println("Valor: ");
				// Receiving String info from the user
				value = inConsole.nextLine();
			} while(value.isEmpty());
			
			boolean valid = true;			
			for(int digit : value.toCharArray()) {
				if(digit >= _0CODE && digit <= _9CODE)
					continue;
				valid = false;
				break;
			}
			
			if(valid)
				System.out.println("Número Valido");
			else
				System.out.println("Número Invalido");
									
		}
		
	}

}
