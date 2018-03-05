package Validators;

public class PhoneValidator {

	public static void main(String[] args) {
		
		if(args.length == 1) {
			String phone = args[0];
			
			if(isPhone(phone)) {
				System.out.println("Telefono Valido");
			} else {
				System.out.println("Telefono Invalido");
			}
						
		} else {
			System.out.println("Sintaxis: phonevalidator.jar <telefono>");
			System.out.println("Description: Valida si el Telefono es valido");
		}

	}
	
	public static boolean isPhone(String phone) {
		String regex = "([+]56)?[1-9][0-9]{8}";
		return phone.matches(regex);
	}

}
