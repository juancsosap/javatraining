package netec.oca.getstarted;

import java.util.Scanner;

public class SchoolAccess {

	public static void main(String[] args) {
		
		SimpleTest.test();
		
	}

}

class SimpleTest {
	
	public static void test() {
		
		try(Scanner console = new Scanner(System.in)){
			
			System.out.print("Level: ");
			int level = console.nextInt();
			System.out.print("Age: ");
			int age = console.nextInt();
			
			if( (age < 6 || age > 13) || (level < 1 || level > 8) ) {
				System.out.println("Age or Level invalid");
				return;
			}
			
			String access = (age >= level + 5) ? "Permited" : "Denied";
			String msg = "The access to the school in this level is " + access;
			System.out.println("\n" + msg);
			
		}

	}
	
}

class CompleteTest {
	
	public static void test() {
		
		try(Scanner console = new Scanner(System.in)){
			
			System.out.print("Age: ");
			int age = console.nextInt();
			
			System.out.println();
			
			Levels minLevel, maxLevel;
			if(age < 4) {
				System.out.println("Must wait to enter to the school system");
				return;
			} else if(age >= 20) {
				System.out.println("Too old to enter to the regular school system");
				return;
			} else {
				minLevel = age < 6 ? Levels.PREKINDER : Levels.values()[age - 6];
				maxLevel = age > 17 ? Levels.CUARTO_MEDIO : Levels.values()[age - 4];
			}
			
			System.out.println("The minimum level that could be accessed is " + minLevel);
			System.out.println("The maximum level that could be accessed is " + maxLevel);
			
		}

	}
	
}

enum Levels { PREKINDER, KINDER, 
	          PRIMERO_BASICO, SEGUNDO_BASICO, TERCERO_BASICO, 
	          CUARTO_BASICO, QUINTO_BASICO, SEXTO_BASICO, 
	          SEPTIMO_BASICO, OCTAVO_BASICO, PRIMERO_MEDIO, 
	          SEGUNDO_MEDIO, TERCERO_MEDIO, CUARTO_MEDIO }  