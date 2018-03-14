package DataAccessObject_DAO;

public class _Program {

	public static void main(String[] args) {
		
		IDAO<Person> personDAO = new MemoryDAO<Person>();
		
		personDAO.create(new Person(1, "Juan Sosa", 35));
		personDAO.create(new Person(2, "Ana Prada", 35));
		personDAO.create(new Person(3, "Sarah Sosa", 6));
		personDAO.create(new Person(4, "Jadash Sosa", 4));
		personDAO.create(new Person(5, "Beatriz Perez", 63));
		personDAO.create(new Person(5, "Beatriz Perez", 63));
		
		System.out.println("Retrived All People");
		for(Person p : personDAO.retriveAll())
			System.out.println(p);
		System.out.println();
		
		System.out.println("Retrived Person");
		Person person = personDAO.retrive(new Person(5, "", 0));
		System.out.println(person);
		System.out.println();
		
		System.out.println("Update Person");
		person.setAge(65);
		personDAO.update(person);
		System.out.println(personDAO.retrive(new Person(5, "", 0)));
		System.out.println();
		
		System.out.println("Delete Person");
		personDAO.delete(person);
		for(Person p : personDAO.retriveAll())
			System.out.println(p);
		System.out.println();
		
	}

}
