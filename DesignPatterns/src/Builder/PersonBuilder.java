package Builder;

public class PersonBuilder {

	private Person person;
	
	public PersonBuilder() { this.person = new Person(); }
	
	public PersonBuilder name(String name) { 
		this.person.setName(name);
		return this;
	}
	
	public PersonBuilder surname(String surname) { 
		this.person.setSurname(surname);
		return this;
	}
	
	public PersonBuilder age(Integer age) { 
		this.person.setAge(age);
		return this;
	}
	
	public PersonBuilder weight(Double weight) { 
		this.person.setWeight(weight);
		return this;
	}
	
	public Person build() { return this.person; }
	
}
