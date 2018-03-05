package basic;

import java.util.Scanner;

public class SimpleEmailValidator {

	public static void main(String[] args) {
		
		Scanner console = new Scanner(System.in);
		
		System.out.println("Escribe tu email:");
		String email = console.nextLine();
		
		// nick@domain.com
		// nickdomain.com
		// nick@domaincom
		// n@domsdrtfgbhnjmklkdmvdfjcgnxdkjfgnbkdjfcnbkxjnbcjhdfain.com
		// @ndomain.com
		// 012345678901
		
		int atIndex = email.indexOf('@');
		
		boolean valid = true;
		
		if(!(atIndex > 0)) {
			valid = false;
			System.out.println("ERROR: Debe tener una @");
		}
		
		String part2 = email.substring(atIndex + 1);
				
		int dotIndex = part2.indexOf('.');
		
		if(dotIndex == -1) {
			valid = false;
			System.out.println("ERROR: el dominio debe incluir al menos un punto");
		} else if(dotIndex == part2.length() - 1) {
			valid = false;
			System.out.println("ERROR: el dominio no debe incluir un punto al final");
		}
		
		if(valid) {
			System.out.println("EMAIL Valido");
		} else {
			System.out.println("EMAIL Invalido");
		}
		
		console.close();

	}

}
