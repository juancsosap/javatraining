package Builder;

public class _Program {
	
	public static void main(String[] args) {
		Person person = Person.builder()
				.setName("Juan")
				.setSurname("Sosa")
				.setAge(35)
				.setWeight(115.0)
				.build();
		
		System.out.println(person);
	}

}
