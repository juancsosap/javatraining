package P03_Strings;

import java.util.Scanner;

public class E05_StringProcesing {

	public static void main(String[] args) {
		
		try(Scanner scan = new Scanner(System.in)) {
			
			System.out.print("Fecha de Cumpleaños (dd-mm-yyyy): ");
			String birth = scan.nextLine();
			
			System.out.print("Fecha de Hoy (dd-mm-yyyy): ");
			String today = scan.nextLine();
			
			int day = Integer.parseInt(birth.substring(0, birth.indexOf("-")));
			System.out.println("Dia: " + day);
			
			int month = Integer.parseInt(birth.substring(birth.indexOf("-") + 1, 
					                     birth.lastIndexOf("-")));
			System.out.println("Mes: " + month);
			
			int bYear = Integer.parseInt(birth.substring(birth.lastIndexOf("-") + 1, 
					                     birth.length()));
			System.out.println("Año: " + bYear);
			
			int tYear = Integer.parseInt(today.substring(today.lastIndexOf("-") + 1, 
					                     today.length()));
			
			int age = tYear - bYear;
			
			System.out.println("Edad: " + age);
			
		}
		
	}

}
