package Builder;

public class _Program {
	
	public static void main(String[] args) {
            Person person1 = Person.builder().name("Juan").age(35).build();
            Person person2 = new Person("Juan", "Sosa", 37, 95.0);
		
            System.out.println(person1);
            System.out.println(person2);
	}

}
