package Controler;

public class NameValidator implements Validable {

	@Override
	public boolean validate(String value) {
		String regex = "[a-zA-Z-' ]{3,20}";
		return value.matches(regex);
	}

}
