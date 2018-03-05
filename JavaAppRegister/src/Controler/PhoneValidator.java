package Controler;

public class PhoneValidator implements Validable {

	@Override
	public boolean validate(String value) {
		String regex = "([+]56)?[1-9][0-9]{8}";
		return value.matches(regex);
	}

}
