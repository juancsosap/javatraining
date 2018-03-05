package Validators;

public class ConsoleValidatorArgs {

	public static void main(String[] args) {
		
		if(args.length == 2) {
			// --email --phone --rut
			String option = args[0];
			String dato = args[1];
			String valid;
			
			switch(option) {
				case "--email":
					valid = EmailValidator.isEmail(dato) ? "Valido" : "Invalido";
					System.out.println("Email " + valid);
					break;
				case "--rut":
					valid = RUTValidator.isRut(dato) ? "Valido" : "Invalido";
					System.out.println("Rut " + valid);
					break;
				case "--phone":
					valid = PhoneValidator.isPhone(dato) ? "Valido" : "Invalido";
					System.out.println("Phone " + valid);
					break;
				default:
					sintax();
			}
						
		} else {
			sintax();
		}

	}
	
	private static void sintax() {
		System.out.println("Sintaxis: validator.jar "
		         + "[--email <email>] | "
		         + "[--phone <phone>] | "
		         + "[--rut <rut>]");
		System.out.println("Description: Valida si el dato es valido");
	}

}
