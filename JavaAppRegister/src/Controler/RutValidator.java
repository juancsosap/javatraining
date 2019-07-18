package Controler;

public class RutValidator implements Validable {

	@Override
	public boolean validate(String value) {
		
		String regex = "[1-9][0-9]?([.]?[0-9]{3}){2}[-][0-9k]";
		if(value.matches(regex)) {
			// 12.345.678-9
			String rutWP = value.replaceAll("[.]", "");
			// 12345678-9
			String[] rutSplit = rutWP.split("[-]");
			// {"12345678","9"}
			return VDCalc(rutSplit[0]).equals(rutSplit[1]) ? true : false;
		} else {
			return false;
		}
		
	}
	
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

}
