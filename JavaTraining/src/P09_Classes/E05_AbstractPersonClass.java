package P09_Classes;

public class E05_AbstractPersonClass {

	public static void main(String[] args) {
		
		Employee[] employees = new Employee[5]; 
		
		employees[0] =  new Employee("Juan", "Sosa", 101, "Engineer", 3520.45, true);
		employees[1] =  new Employee("José", "Pita", 102, "Mussitian", 2450.33, false);
		employees[2] =  new Employee("Luis", "Ossa", 103, "Doctor", 4561.38, true);
		employees[3] =  new Employee("Pepe", "Sanz", 104, "Nurse", 1532.55, false);
		employees[4] =  new Employee("Tito", "Fiza", 105, "Journalist", 2532.45, true);
		
		Employee employee = new Employee("Andrez", "Gutierrez", 201, "General Manager", 7525.15, true);
		Manager manager = new Manager(employee, employees);
		
		System.out.println("---------------------------------------------------------------");
		System.out.println(manager.getDescription());
		System.out.println("---------------------------------------------------------------");
		
		for(Employee e : manager.getDependents()) {
			System.out.println(" > " + e.getDescription());
		}
		System.out.println("---------------------------------------------------------------");
		
		Customer[] customers = new Customer[5]; 
		
		customers[0] =  new Customer("Anabel", "Prada", 111);
		customers[1] =  new Customer("María", "Perez", 222);
		customers[2] =  new Customer("Luisa", "Ortiz", 333);
		customers[3] =  new Customer("Gabriela", "Vergara", 444);
		customers[4] =  new Customer("Julieta", "Vizcaya", 555);
		
		System.out.println("---------------------------------------------------------------");
		
		for(Customer c : customers) {
			System.out.println(" > " + c.getDescription());
		}
		System.out.println("---------------------------------------------------------------");
		
		
	}

}

abstract class Person {
	
	private String name = "";
	public String getName() { return name; }
	public void setName(String name) { this.name = name.length() > 2 ? name : getName(); }

	private String surname = "";
	public String getSurname() { return surname; }
	public void setSurname(String surname) { this.surname = surname.length() > 2 ? surname : getSurname(); }
	
	public Person(String name, String surname) {
		setName(name);
		setSurname(surname);
	}
	
	public String getDescription() {
		return getName() + " " + getSurname().toUpperCase();
	}
	
	public abstract String toString();

}

class Employee extends Person {
	
	private int id = 0;
	public int getId() { return id; }
	public void setId(int id) { this.id = id > 0 ? id : getId(); }

	private String role = "No Asignado";
	public String getRole() { return role; }
	public void setRole(String role) { this.role = role.length() > 3 ? role : getRole(); }

	private double salary = 0.0;
	public double getSalary() { return salary; }
	public void setSalary(double salary) { this.salary = salary > 0.0 ? salary : getSalary(); }

	private boolean active = false;
	public boolean isActive() { return active; }
	public void setActive(boolean active) { this.active = active; }

	public Employee(String name, String surname, int id, String role, double salary, boolean active) {
		super(name, surname);
		
		setId(id); 
		setRole(role); 
		setSalary(salary); 
		setActive(active);
	}
	public Employee(Employee e) { this(e.getName(), e.getSurname(), e.getId(), e.getRole(), e.getSalary(), e.isActive()); }
	
	@Override
	public String toString() {
		return getId() + " : " + super.getDescription();
	}
	
	@Override
	public String getDescription() {
		String active = isActive() ? "ACTIVE  " : "INACTIVE";
		return this.toString() + " - " + active + " - " + getRole();
	}
	
}

class Manager extends Employee {
	
	private Employee[] dependents = null;
	public Employee[] getDependents() { return dependents.clone(); }
	public void setDependents(Employee[] dependents) { this.dependents = (dependents instanceof Employee[]) ? dependents : getDependents(); }
	
	public Manager(Employee employee, Employee[] dependents) {
		super(employee);
		
		setDependents(dependents);
	}
	
	@Override
	public String getDescription() {
		int count = getDependents().length;
		String people = count > 1 ? count + " People" : "1 Person";
		return super.getDescription() + " (" + people + ")";
	}
	
}

class Customer extends Person {

	private int id;
	public int getId() { return id; }
	public void setId(int id) { this.id = id > 0 ? id : getId(); }
		
	public Customer(String name, String surname, int id) {
		super(name, surname);
		
		setId(id);
	}
	
	@Override
	public String toString() {
		return getId() + " : " + super.getDescription();
	}
	
	@Override
	public String getDescription() {
		return this.toString();
	}

}