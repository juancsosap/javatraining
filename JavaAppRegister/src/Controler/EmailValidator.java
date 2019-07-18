package Controler;

public class EmailValidator implements Validable {

	@Override
	public boolean validate(String value) {
		String userRegex = "[a-z][a-z0-9_.-]+[a-z0-9]";
		String domainRegex = "[a-z0-9]{2,}([.][a-z0-9]{2,}){1,2}";
		String regex = userRegex + "[@]" + domainRegex;
		return value.toLowerCase().matches(regex);
	}

}
