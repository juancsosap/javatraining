package pooBasicDirectory;

public class Person {
	private String name;
	private boolean isMale;
	private byte age;
	
	public Person(String name, String gender, int age) {
		setName(name);
		setGender(gender);
		setAge(age);
	}
	
	public void setName(String name) throws IllegalArgumentException {
		if(name.matches("^[-a-zA-Z' ]+$")) {
			this.name = name;
		} else {
			throw new IllegalArgumentException();
		}
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setGender(String gender) throws IllegalArgumentException {
		if(gender.toUpperCase().matches("^[MF]$")) {
			if(gender.toUpperCase() == "M") { this.isMale = true; } 
			else { this.isMale = false; }
		} else {
			throw new IllegalArgumentException();
		}
	}
	
	public String getGender() {
		if(this.isMale) { return "M"; }
		else { return "F"; }
	}
	
	public void setAge(int age) throws NumberFormatException {
		if(age >= 0 && age < 125) {
			this.age = (byte) age;
		} else {
			throw new NumberFormatException();
		}
	}
	
	public byte getAge() {
		return this.age;
	}
	
}