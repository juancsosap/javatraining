package P12_Collections;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class E07_HashSet {

	public static void main(String[] args) {
		
		Set<String> names = new HashSet<>();
		
		names.add("Pepe");
		names.add("Juan");
		names.add("Luis");
		names.add("Juan");
		names.add("Luis");
		
		for(String name : names) {
			System.out.println(name);
		}
		
		Set<Person> clients = new HashSet<>();
		
		clients.add(new Person("Juan", 10));
		clients.add(new Person("Pepe", 20));
		clients.add(new Person("Ana", 20));
		clients.add(new Person("Maria", 40));
		clients.add(new Person("Juan", 10));
		
		for(Person client : clients) {
			System.out.println(client.nombre + " : " + client.edad);
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
