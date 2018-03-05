package Validators;

public class RUTValidator {

	public static void main(String[] args) {
		
		if(args.length == 1) {
			String rut = args[0];
			
			if(isRut(rut)) {
				// 12.345.678-9
				// 12345678-9
				
				String rutWP = rut.replaceAll("[.]", "");
				rutWP = rutWP.substring(0, rutWP.length()-2);
				String VD = rut.substring(rut.length()-1);
				String msg = VDCalc(rutWP).equals(VD) ? "Valido" : "Invalido";
				System.out.println("Rut " + msg);
			} else {
				System.out.println("Rut Invalido");
			}
						
		} else {
			System.out.println("Sintaxis: rutvalidator.jar <rut>");
			System.out.println("Description: Valida si el RUT es valido");
		}

	}
	// 01234567
	// 76543210
	// 12345678      8
	// 10543210
	// 32765432
	
	// 15 / 6 = 2 .. 3
	// 15 / 6 = 2
	// 15 % 6 = 3
	
	// 6 / 6 = 1 .. 0
	
	// 10 543 210
	// 76 543 210
	// 32 765 432
	// 01 234 567  ---> i
	// 12.345.678
	
	// solo los digitos a la izquierda del guion
	// sin puntos
	private static String VDCalc(String rut) {
		final int[] serie = {2, 3, 4, 5, 6, 7};
		int result = 0;
		for(int i=rut.length()-1; i>=0; i--) {
			int digit = Integer.parseInt(rut.substring(i, i+1));
			int index = (rut.length()-1-i) % 6;
			result += digit * serie[index];
		}
		result = 11 - (result % 11);
		if(result == 11) { return "0"; }
		else if(result == 10) { return "k"; }
		else { return result + ""; }
	}
	
	public static boolean isRut(String rut) {
		String regex = "[1-9][0-9]?([.]?[0-9]{3}){2}[-][0-9k]";
		return rut.matches(regex);
	}

}
