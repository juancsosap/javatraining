package Builder;

public class Person {
	
	private String name;
	private String surname;
	private Integer age;
	private Double weight;
	
	public void setName(String name) { this.name = name; }
	public String getName() { return name; }
	
	public void setSurname(String surname) { this.surname = surname; }
	public String getSurname() { return surname; }
	
	public void setAge(Integer age) { this.age = age; }
	public Integer getAge() { return age; }
	
	public void setWeight(Double weight) { this.weight = weight; }
	public Double getWeight() { return weight; }
	
	public static PersonBuilder builder() {
		return new PersonBuilder();
	}
	
	public String toString() {
		return this.name + ", " + this.surname.toUpperCase() +
				" - " + this.age + " años y " + this.weight + " Kgs";
	}

}
