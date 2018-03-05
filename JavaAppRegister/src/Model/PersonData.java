package Model;

public class PersonData extends Person {
	
	private boolean isMale;
	public boolean isMale() { return isMale; }
	public void setMale() { this.isMale = true; }
	public void setFemale() { this.isMale = false; }

	private int age;
	public int getAge() { return age; }
	public void setAge(int age) { this.age = age; }

	private String country;
	public String getCountry() { return country; }
	public void setCountry(String country) { this.country = country; }

	private String email;
	public String getEmail() { return email; }
	public void setEmail(String email) { this.email = email; }

	private String address;
	public String getAddress() { return address; }
	public void setAddress(String address) { this.address = address; }
	
	public PersonData(String name, String surname, boolean isMale, int age, String country, String rut, String email, String address) {
		super(name, surname, rut);
		if(isMale) { this.setMale(); } else { this.setFemale(); }
		this.setAge(age);
		this.setCountry(country);
		this.setRut(rut);
		this.setEmail(email);
		this.setAddress(address);
	}
	public PersonData(Person person, boolean isMale, int age, String country, String email, String address) {
		this(person.getName(), person.getSurname(), isMale, age, country, person.getRut(), email, address);
	}
	public PersonData(String rut) {
		this("", "", true, 0, "Chile", rut, "", "");
	}

}

