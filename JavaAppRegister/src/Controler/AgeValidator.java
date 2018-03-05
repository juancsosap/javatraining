package Controler;

public class AgeValidator implements Validable {

	@Override
	public boolean validate(String value) {
		String regex = "[0-9]{1,3}";
		if(value.matches(regex)) {
			return Integer.parseInt(value) < 200 ? true : false;
		} else {
			return false;
		}
	}

}
