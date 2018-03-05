package P05_ControlBlocks;

import java.util.Scanner;

public class E04_EmailValidator {

	public static void main(String[] args) {
		/*
		 * Email Validator
		 * Valid Email Format : local-part@domain-part
		 * 
		 * Rules:
		 * - Only one @
		 * - Only letter, numbers and some special symbols (#!$%&'*+-/=?^_`{}|~) are allowed in the local-part (NOT VERIFIED)
		 * - not numbers are allowed in the domain-part
		 * - not consecutive dots are allowed (NOT VERIFIED)
		 * - could not start with dot, dash or numbers 
		 * - almost one dot must be present in the domain part
		 * - almost 2 characters must be between dots in the domain-part
		 * - the last dot in the domain-part must be almost 2 characters away from the end
		 * - not numbers are allowed in the domain-par (NOT VERIFIED)
		 *  
  		 */
		
		final int _aCODE = (int) 'a';
		final int _zCODE = (int) 'z';
		final int _dotCODE = (int) '.';
		final int _atCODE = (int) '@';
		final int _underscoreCODE = (int) '_';
		
		
		try(Scanner inConsole = new Scanner(System.in)) {
			
			// Printing info in the console with two new lines
			System.out.println("Validador de Email\n");
			
			System.out.print("Favor suministre el email a verificar: ");
			String email = inConsole.nextLine();
			
			boolean isValid;
			
			// Removing spaces at the beginning or the end and transforming all to lower case
			email = email.trim().toLowerCase();
			
			// Only one @
			if(email.indexOf(_atCODE) == email.lastIndexOf(_atCODE) && email.indexOf(_atCODE) != -1) {
				int atIndex = email.indexOf(_atCODE);
				
				String localPart = email.substring(0, atIndex);
				String domainPart = email.substring(atIndex + 1);
				
				int firstCharCode = (int) localPart.charAt(0);
				
				// Only Start with letters
				boolean startWithLetter = firstCharCode >= _aCODE && firstCharCode <= _zCODE;  
				boolean startWithUderscore = firstCharCode == _underscoreCODE;
				
				// isValid = (startWithLetter || startWithUderscore) ? ( (domainPart.indexOf(_dotCODE) > 1) ? domainPart.indexOf(_dotCODE) < domainPart.length() - 2 : false ) : false;
				if( startWithLetter || startWithUderscore ) {
					
					// isValid = (domainPart.indexOf(_dotCODE) > 1) ? domainPart.indexOf(_dotCODE) < domainPart.length() - 2 : false;
					// Almost one dot must be present in the domain part
					if(domainPart.indexOf(_dotCODE) > 1) {

						// isValid = domainPart.indexOf(_dotCODE) < domainPart.length() - 2;
						// The last dot in the domain-part must be almost 2 characters away from the end
						if(domainPart.indexOf(_dotCODE) < domainPart.length() - 2) {
							isValid = true;
						} else {
							isValid = false;
						}
						
					} else {
						isValid = false;
					}
				
				} else {
					isValid = false;
				}
				
			} else {
				isValid = false;
			}
			
			String msg = isValid ? "Email Valido" : "Email Invalido";
			
			System.out.println("\n" + msg);
			
		}
		
	}

}
