package JavaFXTemplates;

public class Person{
	
	private String name;
	public String getName() { return this.name; }
	public void setName(String name) { this.name = name; }
	
	private String surname;
	public String getSurname() { return this.surname; }
	public void setSurname(String surname) { this.surname = surname; }
	
	private int age;
	public int getAge() { return this.age; }
	public void setAge(int age) { this.age = age; }
	
	public Person() { this("", "", 0); }
	public Person(String name, String surname, int age) {
		this.setName(name);
		this.setSurname(surname);
		this.setAge(age);
	}
	
}