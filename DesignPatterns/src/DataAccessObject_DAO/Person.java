package DataAccessObject_DAO;

public class Person {

	private int id;
	private String name;
	private int age;
	
	public int getId() { return id; }
	public void setId(int id) { this.id = id; }
	
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	
	public int getAge() { return age; }
	public void setAge(int age) { this.age = age; }
	
	public Person(int id, String name, int age) {
		this.setId(id);
		this.setName(name);
		this.setAge(age);
	}
	
	@Override
	public boolean equals(Object other) {
		return this.getId() == ((Person) other).getId();
	}
	
	@Override
	public String toString() {
		return this.getId() + " : " + this.getName() + " : " + this.getAge();
	}
	
	
}
