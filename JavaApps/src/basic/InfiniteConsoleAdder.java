package basic;

import java.util.Scanner;

public class InfiniteConsoleAdder {
	
	// Bucles (for/while)
	// Metodos / Funciones
	// Control (if/switch)
	
	public static void main(String[] args) {
		
		String num1, num2, result;
		
		Scanner console = new Scanner(System.in);
		
		System.out.println("Welcome to the super calculator");
		
		num1 = getNumber("First Number: ", console);
		num2 = getNumber("Second Number: ", console);
		
		result = add(num1,num2);
		System.out.println("Result: " + result);
				
		console.close();

	}
	
	// Suma 12 + 34 = 46
		/*  1 1     <- Lleva
		 *    1 2 + <- Primer Número
		 *    9 9   <- Segundo Número
		 * ---------
		 *  1 1 1   <- Resultado
		 *  
		 * 1000011100
		 *  0123456790
		 *  0900004590
		 *  023460380
		 */
	
	static String add(String n1, String n2) {
		String r = "";
		int l = longest(n1,n2);
		n1 = putZeros(n1,l);
		n2 = putZeros(n2,l);
		
		int lleva = 0;
		for(int i = 0; i < l; i++) {
			int n1_int = toInt(n1, l-i-1);
			int n2_int = toInt(n2, l-i-1);
			int r_int = n1_int + n2_int + lleva;
			
			if(r_int > 9) {
				r = (r_int - 10) + r;
				lleva = 1;
			} else {
				r = r_int + r;
				lleva = 0;
			}
		}
		if(lleva == 1) {
			r = "1" + r;
		}
		return r;
	}
	
	static int longest(String n1, String n2) {
		if(n1.length() > n2.length()) {
			return n1.length();
		} else {
			return n2.length();
		}
	}
	
	static String putZeros(String n, int l) {
		String r = n;
		for(int i = 0; i < l - n.length(); i++) {
			r = "0" + r;
		}
		return r;
	}
	
	static String getNumber(String text, Scanner console){
		boolean valid;
		String num;
		do {
			System.out.print(text);
			num = console.nextLine(); // "1234567891234567892345678234567890"
			valid = validateNumber(num);
		} while(!valid);
		return num;
	}
	
	static boolean validateNumber(String num) {
		
		/*
		boolean valid = true;
		for(int i = 0; i < num.length(); i++) {
			try {
				toInt(num,i);
			} catch(NumberFormatException e) {
				System.out.println("Not valid Value");
				valid = false;
				break;
			} 
		}
		return valid;
		*/
		
		// https://regexr.com/
		return num.matches("^[0-9]+$");
	}
	
	static int toInt(String num, int i) throws NumberFormatException {
		return Integer.parseInt(String.valueOf(num.charAt(i)));
	}

}
