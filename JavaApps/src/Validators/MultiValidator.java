package Validators;

public class MultiValidator {

	public static void main(String[] args) {
		
		if(args.length == 1) {
			String dato = args[0];
						
			if(EmailValidator.isEmail(dato)) {
				System.out.println("Email Valido");
			} else if(RUTValidator.isRut(dato)){
				System.out.println("Rut Valido");
			} else if(PhoneValidator.isPhone(dato)){
				System.out.println("Telefono Valido");
			} else {
				System.out.println("Dato Invalido");
			}
						
		} else {
			System.out.println("Sintaxis: validator.jar <dato>");
			System.out.println("Description: Valida si el dato es valido");
		}

	}

}
