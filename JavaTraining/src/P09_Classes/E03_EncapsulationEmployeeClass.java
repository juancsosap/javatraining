package P09_Classes;

public class E03_EncapsulationEmployeeClass {

	public static void main(String[] args) {
		
		EmployeeIII[] employees = new EmployeeIII[5]; 
		
		employees[0] =  new EmployeeIII(123456, "Juan", "Sosa", "Engineer", 3520.45, true);
		employees[1] =  new EmployeeIII(234561, "José", "Pita", "Mussitian", 2450.33, false);
		employees[2] =  new EmployeeIII(345612, "Luis", "Ossa", "Doctor", 4561.38, true);
		employees[3] =  new EmployeeIII(456123, "Pepe", "Sanz", "Nurse", 1532.55, false);
		employees[4] =  new EmployeeIII(561234, "Tito", "Fiza", "Journalist", 2532.45, true);
		
		for(EmployeeIII e : employees) {
			System.out.println("-------------------------");
			System.out.println("ID: " + e.getId());
			System.out.println("Nombre: " + e.getName());
			System.out.println("Apellido: " + e.getSurname());
			System.out.println("Cargo: " + e.getRole());
			System.out.println("Salario: " + e.getSalary() + "USD");
			System.out.println("Activo: " + e.isActive());
			System.out.println("-------------------------");
		}
		
	}

}

class EmployeeIII {
	
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

	public EmployeeIII(int id, String name, String surname, String role, double salary, boolean active) {
		setId(id); 
		setName(name); 
		setSurname(surname); 
		setRole(role); 
		setSalary(salary); 
		setActive(active);
	}
	public EmployeeIII(EmployeeIII e) { this(e.getId(), e.getName(), e.getSurname(), e.getRole(), e.getSalary(), e.isActive()); }
	
}
