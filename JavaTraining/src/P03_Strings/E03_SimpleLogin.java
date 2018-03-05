package P03_Strings;

import java.util.Scanner;

public class E03_SimpleLogin {

	public static void main(String[] args) {
		
		// Opening Console Session with AutoClose
		try(Scanner inConsole = new Scanner(System.in)) {
			
			String validUser = "user";
			String validPass = "U$3r";
			
			// Printing info in the console with two new lines
			System.out.println("Login Simple\n");
			
			// Printing info in the console 
			System.out.print("Usuario: ");
			// Receiving String info from the user
			String user = inConsole.nextLine();
			
			// Printing info in the console 
			System.out.print("Contraseña: ");
			// Receiving String info from the user
			String pass = inConsole.nextLine();
			
			boolean authorizedUser = user.equalsIgnoreCase(validUser);
			boolean authorizedPass = pass.equals(validPass);
			
			// Printing info in the console the result
			System.out.println();
			System.out.println("Usuario Valido: " + authorizedUser);
			System.out.println("Contraseña Valida: " + authorizedPass);
						
		}
				
	}

}
