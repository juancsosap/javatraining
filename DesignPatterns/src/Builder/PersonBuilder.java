package Builder;

public class PersonBuilder {

	private Person person;
	
	public PersonBuilder() { this.person = new Person(); }
	
	public PersonBuilder setName(String name) { 
		this.person.setName(name);
		return this;
	}
	
	public PersonBuilder setSurname(String surname) { 
		this.person.setSurname(surname);
		return this;
	}
	
	public PersonBuilder setAge(Integer age) { 
		this.person.setAge(age);
		return this;
	}
	
	public PersonBuilder setWeight(Double weight) { 
		this.person.setWeight(weight);
		return this;
	}
	
	public Person build() { return this.person; }
	
}
