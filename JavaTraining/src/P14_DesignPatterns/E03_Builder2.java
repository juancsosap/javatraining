package P14_DesignPatterns;

public class E03_Builder2 {

	public static void main(String[] args) {
		printData(Person.builder().name("Juan").surname("Sosa").rut("12.234.567-8").age(35).authorized().build());
		printData(Person.builder().name("Juan").surname("Sosa").rut("12.234.567-8").age(35).build());
		printData(Person.builder().name("Juan").surname("Sosa").rut("12.234.567-8").build());
		printData(Person.builder().name("Juan").surname("Sosa").build());
		printData(Person.builder().name("Juan").build());
		printData(new Person());
	}
	
	private static void printData(Person per) {
		System.out.println("-----------------------------------");
		if(!per.getName().isEmpty()) System.out.println("Nombre: " + per.getName());
		if(!per.getSurname().isEmpty()) System.out.println("Apellido: " + per.getSurname());
		if(!per.getRut().isEmpty()) System.out.println("RUT: " + per.getRut());
		if(per.getAge() > 0) System.out.println("Edad: " + per.getAge());
		
		if(per.isAuthorized()) System.out.println("ACCESO AUTORIZADO");
		
		System.out.println("-----------------------------------\n");
	}

}

class Person {
	
	private String name;
	private String surname;
	private String rut;
	private int age;
	private boolean authorized;
	
	public Person() {
		name = "";
		surname = "";
		rut = "";
		age = 0;
		authorized = false;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getRut() {
		return rut;
	}

	public void setRut(String rut) {
		this.rut = rut;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public boolean isAuthorized() {
		return authorized;
	}

	public void setAuthorized(boolean authorized) {
		this.authorized = authorized;
	}
	
	public static PersonBuilder builder() {
		return new PersonBuilder();
	}
	
}

class PersonBuilder {
	
	private Person per;
	
	public PersonBuilder() {
		per = new Person();
	}
	
	public PersonBuilder name(String name) {
		per.setName(name);
		return this;
	}
	
	public PersonBuilder surname(String surname) {
		per.setSurname(surname);
		return this;
	}
	
	public PersonBuilder rut(String rut) {
		per.setRut(rut);
		return this;
	}
	
	public PersonBuilder age(int age) {
		per.setAge(age);
		return this;
	}
	
	public PersonBuilder authorized() {
		per.setAuthorized(true);
		return this;
	}
	
	public Person build() {
		return per;
	}
	
}