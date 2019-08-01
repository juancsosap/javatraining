package netec.oca.getstarted;

public abstract class Person {

	public static void main(String[] args) {
		
		Person luis = new Employee("Luis", "Vendedor");
		Person pepe = new Client("Luis", "Coca Cola");;
		
		System.out.println(luis);
		System.out.println(pepe);
		
		System.out.println(Person.getCounter());
		
		System.out.println(luis.getDescription());
		System.out.println(pepe.getDescription());
		
	}
	
	private static int last_id;
	
	private int id; 
	private String name;
	
	static {
		Person.last_id = 0;
	}
	
	public Person(String name) {
		this.name = name;
		this.id = ++Person.last_id;
	}
	// public Person() { this(""); }
	
	public static int getCounter() {
		return Person.last_id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) throws Exception {
		if(name.length() > 3) {
			this.name = name;
		} else {
			throw new Exception("El nombre debe tener m�s de 3 caracteres");
		}
	}
	
	public int getId() {
		return this.id;
	}
	
	@Override
	public String toString() {
		return this.id + " : " + this.name;
	}
	
	public abstract String getDescription();

}

class Employee extends Person {

	private String role;
	
	public Employee(String name, String role) {
		super(name);
		this.setRole(role);
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	public String toString() {
		return super.toString() + " - " + this.role;
	}

	@Override
	public String getDescription() {
		return "Employee: " + this.toString();
	}
	
}

class Client extends Person {

	private String company;
	
	public Client(String name, String company) {
		super(name);
		this.setCompany(company);
	}

	public String getCompany() {
		return this.company;
	}

	public void setCompany(String company) {
		this.company = company;
	}
	
	public String toString() {
		return super.toString() + " - " + this.company;
	}

	@Override
	public String getDescription() {
		return "Client: " + this.toString();
	}

}

