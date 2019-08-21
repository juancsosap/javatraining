package test;

import java.util.Scanner;

public class ScannerTest {

	public static void main(String[] args) {
		
		try(Scanner scan = new Scanner(System.in)){
		
			System.out.print("Nombre: ");
			String name = scan.nextLine();
			
			System.out.print("Edad  : ");
			int age = scan.nextInt();
			
			scan.nextLine();
			
			System.out.print("Ciudad: ");
			String city = scan.nextLine();
			
			System.out.println(name + age + city);
			
			int a = 10;
			
			if(a > 10)
				System.out.println("grande");
			else if(a > 5)
				System.out.println("mediano");
			else if(a > 2)
				System.out.println("pequeño");
			else
				System.out.println("diminuto");
		
			String n;
			do {
				
				System.out.println("Number:");
				n = scan.nextLine();
				
				try {
					Double.parseDouble(n);
					break;
				} catch(Exception e) {}
				
			} while (true);
			
			System.out.println(Double.parseDouble(n) + 1);
			
			
			
			
			
		}
		
	}

}
