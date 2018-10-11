package P16_Streams;

import java.util.Arrays;
import java.util.List;

public class E09_SortingStream {

	public static void main(String[] args) {
		
		List<Person> people = Arrays.asList(new Person("Juan", 30, "Chile"),
				                          new Person("Carlos", 40, "Colombia"),
				                          new Person("Maria", 20, "Peru"),
				                          new Person("Andres", 20, "Argentina"));
		
		people.stream().sorted().forEach(System.out::println);
		
		System.out.println();
		
		people.stream().sorted((d1, d2) -> d2.compareTo(d1)).forEach(System.out::println);
		
		System.out.println();
		
		people.stream().sorted((d1, d2) -> d1.place.compareTo(d2.place)).forEach(System.out::println);
		
	}
	
	private static class Person implements Comparable<Person> {
		
		public String name;
		public Integer age;
		public String place;
		
		public Person(String name, Integer age, String place) {
			this.name = name; this.age = age; this.place = place;
		}

		@Override
		public int compareTo(Person other) {
			return this.name.compareTo(other.name);
		}
		
		@Override
		public String toString() {
			return this.name + " (" + this.age + ") - " + this.place;
		}
		
	}

}
