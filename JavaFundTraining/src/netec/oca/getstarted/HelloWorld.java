package netec.oca.getstarted;

import java.util.Scanner;

public class HelloWorld {

	public static void main(String[] args) {
		
		// Create Scanner with standard console input
		Scanner console = new Scanner(System.in); // OK
		
		/* Esta es un comentario
		 * de muchas lineas
		 * con algo de informacion
		 * que no sirve para nada
		 */
		
		System.out.print("Write something: ");
		
		String message = console.nextLine();
		
		System.out.println(message);
		
		console.close();
		
	}

}
