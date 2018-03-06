package P09_Classes;

public class E04_HeritageEmployeeClass {

	public static void main(String[] args) {
		
		EmployeeIV[] employees = new EmployeeIV[5]; 
		
		employees[0] =  new EmployeeIV(123456, "Juan", "Sosa", "Engineer", 3520.45, true);
		employees[1] =  new EmployeeIV(234561, "José", "Pita", "Mussitian", 2450.33, false);
		employees[2] =  new EmployeeIV(345612, "Luis", "Ossa", "Doctor", 4561.38, true);
		employees[3] =  new EmployeeIV(456123, "Pepe", "Sanz", "Nurse", 1532.55, false);
		employees[4] =  new EmployeeIV(561234, "Tito", "Fiza", "Journalist", 2532.45, true);
		
		EmployeeIV employee = new EmployeeIV(1234, "Andrez", "Gutierrez", "General Manager", 7525.15, true);
		ManagerIV manager = new ManagerIV(employee, employees);
		
		System.out.println("---------------------------------------");
		System.out.println("ID: " + manager.getId());
		System.out.println("Nombre: " + manager.getName());
		System.out.println("Apellido: " + manager.getSurname());
		System.out.println("Cargo: " + manager.getRole());
		System.out.println("Salario: " + manager.getSalary() + "USD");
		System.out.println("Activo: " + manager.isActive());
		System.out.println("---------------------------------------");
		
		for(EmployeeIV e : manager.getDependents()) {
			System.out.println(e.getId() + " : " + e.getName() + " " + e.getSurname() + " - " + e.getRole());
		}
		System.out.println("---------------------------------------");
		
	}

}

class EmployeeIV {
	
	private int id = 0;
	public int getId() { return id; }
	public void setId(int id) { this.id = id > 0 ? id : getId(); }

	private String name = "";
	public String getName() { return name; }
	public void setName(String name) { this.name = name.length() > 3 ? name : getName(); }

	private String surname = "";
	public String getSurname() { return surname; }
	public void setSurname(String surname) { this.surname = surname.length() > 3 ? surname : getSurname(); }

	private String role = "No Asignado";
	public String getRole() { return role; }
	public void setRole(String role) { this.role = role.length() > 3 ? role : getRole(); }

	private double salary = 0.0;
	public double getSalary() { return salary; }
	public void setSalary(double salary) { this.salary = salary > 0.0 ? salary : getSalary(); }

	private boolean active = false;
	public boolean isActive() { return active; }
	public void setActive(boolean active) { this.active = active; }

	public EmployeeIV(int id, String name, String surname, String role, double salary, boolean active) {
		setId(id); 
		setName(name);
		setSurname(surname);
		setRole(role); 
		setSalary(salary); 
		setActive(active);
	}
	public EmployeeIV(EmployeeIV e) { this(e.getId(), e.getName(), e.getSurname(), e.getRole(), e.getSalary(), e.isActive()); }
	
}

class ManagerIV extends EmployeeIV {
	
	private EmployeeIV[] dependents = null;
	public EmployeeIV[] getDependents() { return dependents.clone(); }
	public void setDependents(EmployeeIV[] dependents) { this.dependents = (dependents instanceof EmployeeIV[]) ? dependents : getDependents(); }
	
	public ManagerIV(EmployeeIV employee, EmployeeIV[] dependents) {
		super(employee);
		
		setDependents(dependents);
	}
	
}