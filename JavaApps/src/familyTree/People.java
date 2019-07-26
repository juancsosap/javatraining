package familyTree;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

public class People {
	private Set<Person> people;
	
	public People() {
		this.people = new HashSet<>();
	}
	
	public People(Stream<Person> peopleStream) {
		this();
    	peopleStream.forEach(p -> this.people.add(p));
	}
	
	public void add(Person person) {
		this.people.add(person);
	}
		
	public Set<Person> set() {
		return new HashSet<>(this.people);
	}
	
	public Stream<Person> stream() {
		return this.set().stream();
	}
	
    public People getSiblings() {
    	Stream<Person> peopleStream = this.getType(RelType.PARENT)
    			                          .getType(RelType.CHILD)
    			                          .stream()
    						   		      .filter(p -> !this.set().contains(p));
    	return new People(peopleStream);
    }
    
    public People getType(RelType type) {
    	Stream<Person> peopleStream = this.people.stream()
    	                                  .flatMap(p -> p.getType(type).stream());
    	return new People(peopleStream);
    }
    
    public People males() {
    	Stream<Person> peopleStream = this.people.stream()
    	                                  .filter(p -> p.getGender() == Gender.MALE);
    	return new People(peopleStream);
    }

    public People females() {
    	Stream<Person> peopleStream = this.people.stream()
    	                                  .filter(p -> p.getGender() == Gender.FEMALE);
    	return new People(peopleStream);
    }

    public String toString() {
		StringBuilder sb = new StringBuilder();
		for(Person person : this.people) {
			sb.append(person + "\n");
		}
		return sb.toString();
	}
}
