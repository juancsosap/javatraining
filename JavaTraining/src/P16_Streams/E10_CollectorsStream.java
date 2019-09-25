package P16_Streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class E10_CollectorsStream {

	public static void main(String[] args) {
		
		List<Person> people = getPeople(); 
				
		List<Person> filterPeople = people.stream().filter(p -> p.age < 30)
				                                   .collect(Collectors.toList());
		filterPeople.forEach(System.out::println);
		
		System.out.println();
		
		people.stream().collect(Collectors.groupingBy(p -> ((Person) p).place))
		               .forEach((k,v) -> System.out.println(k + " : " + v));
		
		System.out.println();
		
		System.out.println(people.stream().map(p -> p.name)
				                          .collect(Collectors.joining(" - ")));
		
		System.out.println();
		
		people.stream().map(p -> p.name.toLowerCase())
		               .flatMap(n -> Stream.of(n.split("")))
		               .collect(Collectors.groupingBy(c -> c))
		               .forEach((k,v) -> System.out.println(k + " : " + v.size()));
		
		System.out.println();
		System.out.println();
		
		System.out.println(people.stream().collect(Collectors.averagingInt(p -> p.age)).toString());
		
		System.out.println();
		
		System.out.println(people.stream().collect(Collectors.groupingBy(p -> ((Person)p).place))
				          .keySet().stream().collect(Collectors.counting()).toString());
		
		System.out.println();
		
		System.out.println(people.stream().map(p -> p.name.toLowerCase())
                       .flatMap(n -> Stream.of(n.split("")))
                       .collect(Collectors.groupingBy(c -> c, Collectors.counting())));
		
		System.out.println();
		
		System.out.println(people.stream().map(p -> p.name.toLowerCase()).collect(new LetterCountCollector()));
		
		System.out.println();
		
		System.out.println(people.stream().collect(new GrouppingCountCollector<Person>(p -> p.name, "")));
		
		System.out.println();
		
		System.out.println(people.stream().collect(new GrouppingCountCollector<Person>(p -> p.name, true)));

	}
	
	private static List<Person> getPeople() {
		return Arrays.asList(new Person("Juan Carlos Sosa Peña", 30, "Chile"),
                             new Person("Carlos Antonio Perez Alvarez", 40, "Argentina"),
                             new Person("Maria José Prada Sosa", 20, "Chile"),
                             new Person("Andres José Sosa Lopez", 20, "Argentina"));
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
	
	private static class LetterCountCollector implements Collector<String, Integer, String> {

		@Override
		public Supplier<Integer> supplier() {
			return () -> 0;
		}

		@Override
		public BiConsumer<Integer, String> accumulator() {
			return (data, in) -> data += in.length();
		}

		@Override
		public BinaryOperator<Integer> combiner() {
			return (data1, data2) -> {
				data1 += data2;
				return data1;
			};
		}

		@Override
		public Function<Integer, String> finisher() {
			return (data) -> data + "";
		}

		@Override
		public Set<Characteristics> characteristics() {
			Set<Characteristics> c = new HashSet<>();
			
			c.add(Characteristics.CONCURRENT); 
			c.add(Characteristics.UNORDERED);
			
			return c;
		}
		
	}
	
	private static class GrouppingCountCollector<T>
	               implements Collector<T, 
	                                    List<String>, 
	                                    Map<String, Long>> {

		private boolean cs;
		private String regex;
		private Function<T, String> selector;
		
		public GrouppingCountCollector(Function<T, String> selector, String regex, boolean caseSencitive) {
			this.cs = caseSencitive;
			this.regex = regex;
			this.selector = selector;
		}
		public GrouppingCountCollector(Function<T, String> selector, String regex) { this(selector, regex, false); }
		public GrouppingCountCollector(Function<T, String> selector, boolean caseSencitive) { this(selector, "[ ]", caseSencitive); }
		
		@Override
		public Supplier<List<String>> supplier() {
			return ArrayList::new;
		}

		@Override
		public BiConsumer<List<String>, T> accumulator() {
			return (data, in) -> {
				data.addAll(Stream.of(selector.apply(in).split(regex))
					.map(c -> (cs) ? c : ((String) c).toLowerCase()).collect(Collectors.toList()));
			};
		}

		@Override
		public BinaryOperator<List<String>> combiner() {
			return (data1, data2) -> {
				data1.addAll(data2);
				return data1;
			};
		}

		@Override
		public Function<List<String>, Map<String, Long>> finisher() {
			return (data) -> data.stream().collect(Collectors.groupingBy(c -> c, Collectors.counting()));
		}
		
		@Override
		public Set<Characteristics> characteristics() {
			Set<Characteristics> c = new HashSet<>();
			
			c.add(Characteristics.CONCURRENT); 
			c.add(Characteristics.UNORDERED);
			
			return c;
		}

	}
	
}
