package P12_Collections;

import java.util.Set;
import java.util.TreeSet;

public class E08_TreeSet {

	public static void main(String[] args) {
		
		Set<String> names = new TreeSet<>();
		
		names.add("Pepe");
		names.add("Juan");
		names.add("Luis");
		names.add("Juan");
		names.add("Luis");
		
		for(String name : names) {
			System.out.println(name);
		}
		
		Set<Person> users = new TreeSet<>();
		
		users.add(new Person("Juan", 10));
		users.add(new Person("Pepe", 20));
		users.add(new Person("Ana", 20));
		users.add(new Person("Maria", 40));
                users.add(new Person("Juan", 10));
		
		for(Person user : users) {
			System.out.println(user.nombre + " : " + user.edad);
		}
		
		
	}
	
	private static class Person implements Comparable<Person> {
		
		public String nombre;
		public int edad;
		
		public Person(String nombre, int edad) {
			this.nombre = nombre;
			this.edad = edad;
		}

		@Override
		public int compareTo(Person o) {
			return this.edad > o.edad  ? -1 : this.edad < o.edad ? 1 : this.nombre.compareTo(o.nombre);
		}
		
	}

}
