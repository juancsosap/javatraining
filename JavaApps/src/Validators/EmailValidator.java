package Validators;

public class EmailValidator {

	public static void main(String[] args) {
		
		if(args.length == 1) {
			String email = args[0];
			
			if(isEmail(email)) {
				System.out.println("Email Valido");
			} else {
				System.out.println("Email Invalido");
			}
						
		} else {
			System.out.println("Sintaxis: emailvalidator.jar <email>");
			System.out.println("Description: Valida si el email es valido");
		}

	}
	
	public static boolean isEmail(String email) {
		String userRegex = "[a-z][a-z0-9_.-]+[a-z0-9]";
		String domainRegex = "[a-z0-9]{2,}([.][a-z0-9]{2,}){1,2}";
		String regex = userRegex + "[@]" + domainRegex;
		return email.toLowerCase().matches(regex);
	}

}
