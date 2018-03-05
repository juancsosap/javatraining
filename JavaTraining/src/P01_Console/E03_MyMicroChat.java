package P01_Console;

import java.util.Scanner;

public class E03_MyMicroChat {

	public static void main(String[] args) {
		
		// Opening Console Session
		Scanner inConsole = new Scanner(System.in);
		
		// Printing info in the console with new line
		System.out.println("-> Mi nombre es Juan, es un placer conocerte");
		
		System.out.println("-> ¿Cual es tu nombre? ");
		
		// Printing info in the console without new line
		System.out.print("<- ");
		// Receiving String info from the user
		String name = inConsole.nextLine();
		
		System.out.println("-> Bienvenido " + name);
		
		System.out.println("-> ¿Qué edad tienes? ");
		
		System.out.print("<- ");
		// Receiving Integer info from the user
		Integer age = inConsole.nextInt();
		
		System.out.println("-> Que bueno. Yo tengo un año más que tu, es decir, " + (age+1) + " años");
		
		System.out.println("-> Gracias por venir... nos vemos luego... chao");
		
		// Closing Console Session
		inConsole.close();
		
	}

}
