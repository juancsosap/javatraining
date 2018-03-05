package P05_ControlBlocks;

import java.util.Scanner;

public class E03_AccessControl {

	public static void main(String[] args) {
		
		try(Scanner inConsole = new Scanner(System.in)) {
			
			// Printing info in the console with two new lines
			System.out.println("Control de Acceso\n");
			
			System.out.print("Nombre: ");
			String name = inConsole.nextLine();
			
			System.out.print("Edad: ");
			int age = inConsole.nextInt();
			
			System.out.println();
			
			String msg = age >= 18 ? "Acceso Permitido, " + name + " puedes entrar." : 
				                     "Acceso Restringido, " + name + " no puedes entrar.";
			
			System.out.println(msg);
					
		}
		
	}

}
