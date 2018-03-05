package BasicPooShape;

import java.util.*;

@SuppressWarnings({"unused","deprecation"})
public class Family {

	public static void main(String[] args) {
		int var1 = 5;
		int var2 = 7;
		int var3 = var1;
		var3 = 10;
		
		System.out.println(var1);
		System.out.println(var2);
		System.out.println(var3);
		
		Integer varI1 = 5;
		Integer varI2 = 7;
		Integer varI3 = varI1;
		varI3 = 10;
		
		System.out.println(varI1);
		System.out.println(varI2);
		System.out.println(varI3);
		
		Person user1 = new Person("Juan","Sosa");
		Person user2 = new Person();
		user2.setName("Juan");
		Person user3 = user1;
		user3.setName("Pepe");
		user3.setSurname("Perez");
		Person user4 = new Person(user2);
		
		System.out.println(user1.toString());
		System.out.println(user2);
		System.out.println(user3);
		System.out.println(user4);
		
		Person user5p = new Person("Maria","Lopez");
		Client user5 = new Client("ABJ12345", user5p);
		System.out.println(user5);
		
		Person user6 = new Client("ABJ65432", 
				new Person("Andres", "Maldonado"));
		Person user7 = new Employee("Engineer", 
				new Person("Andrea", "Mayo"));
		Person user8 = new Person("Amin", "Mijao");
		
		System.out.println(user6.getClass());
		
		if(user6 instanceof Client) {
			Client client6 = (Client) user6;
			client6.getId();
		} else if(user6 instanceof Employee) {
			Employee employee6 = (Employee) user6;
			employee6.getRole();
		}
		
		System.out.println(((Employee) user7).getRole());
		
		if(user4.equals(user2)) {
			System.out.println("Iguales");
		}
		
		System.out.println(user6.toString());
		System.out.println(user7.toString());
		System.out.println(user8.toString());
		
		Object[] array = new Object[6];
		array[0] = 1;
		array[1] = "1";
		array[2] = 1.2;
		array[3] = new Person();
		array[4] = new Person();
		array[5] = new Person();
		
		ArrayList<Integer> x = new ArrayList<Integer>();
		x.add(0, 1);
		x.add(1, 10);
		x.add(2, 10);
		x.add(3, 10);
		x.add(4, 10);
		x.add(5, 10);
		x.add(6, 10);
		x.add(7, 10);
		
		x.get(0);
		
		String str = "1234567890";
		
		String dd = "a"; // "a"
		for(int i=0; i<10000; i++) {
			dd = dd + "b";
		}
		
		StringBuilder ddd = new StringBuilder("a");
		for(int i=0; i<10000; i++) {
			ddd.append("b");
		}
		System.out.println(ddd.toString());
		
		Date fecha = new Date();
		fecha.getDay();
	}

}

class Person {
	
	private String name;
	private String surname;
	private int age;
	private boolean state;
	
	public boolean equals(Object obj) {
		Person person = (Person) obj;
		if(this.name.equals(person.getName()) &&
		   this.surname.equals(person.getSurname()) &&
		   this.age == person.getAge() &&
		   this.state == person.getState()) {
			return true;
		}
		return false;
	}
	
	
	public boolean getState() {
		return this.state;
	}
	
	public void setName(String name) {
		if(name.length() > 4) {
			this.name = name;
		}
	}
	
	public void setSurname(String surname) {
		if(surname.length() > 4) {
			this.surname = surname;
		}
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getSurname() {
		return this.surname;
	}
	
	public String getFullName() {
		return this.name + ", " + this.surname.toUpperCase();
	}
	
	public Person() {
		this("","");
	}
	
	public Person(String name, String surname) {
		this.name = name;
		this.surname = surname;
		this.age = 0;
		this.state = false;
	}
	
	public Person(Person person) {
		this.name = person.getName();
		this.surname = person.getSurname();
		this.age = person.getAge();
		this.state = person.getState();
	}
	
	public String toString(){
		return super.toString() + ":" + this.name;
	}

	public int getAge() {
		return this.age;
	}

	public void setAge(int age) {
		if(age >= 0 && age < 1000) {
			this.age = age;
		}
	}

}

class Client extends Person {
	
	private String id;
	
	public String getId() {
		return this.id;
	}
	
	public Client(String id, Person person) {
		super(person);
		this.id = id;
	}
	
	public String toString() {
		return this.id + " : " + this.getFullName();
	}
	
}

class Employee extends Person {
	
	private String role;

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	public Employee(String role, Person person) {
		super(person);
		this.role = role;
	}
	
}