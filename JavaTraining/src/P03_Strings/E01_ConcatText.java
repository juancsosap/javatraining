package P03_Strings;

public class E01_ConcatText {

	public static void main(String[] args) {
		
		// Assign a String directly
		String firstname = "Pedro";
		String lastname = "Perez";
		
		// Concat String using '+' operator
		String fullname = firstname + " " + lastname;
		
		System.out.println("Nombre    : " + fullname);
		
		String country = "Chile";
		String city = "Santiago ";
		String district = "Providencia. ";
		String street = "Salvador ";
		String number = 123 + ". ";
		
		// Concat String using 'concat()' method from the String class
		String address = street.concat(number).concat(district).concat(city).concat(country);
		
		System.out.println("Dirección : " + address);
		
		// Assign String using a new instance of the class String
		String phone = new String("+");
		phone = phone + 56 + " " + 9 + " " + 8765 + " " + 4321;
		
		System.out.println("Telefono  : " + phone);
		
		// Assign String from other value type using the 'valueOf' method of the String class
		String age = String.valueOf(35);
		
		System.out.println("Edad      : " + age + " años");
		
	}

}
