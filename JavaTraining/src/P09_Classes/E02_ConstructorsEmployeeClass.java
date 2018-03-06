package P09_Classes;

public class E02_ConstructorsEmployeeClass {

	public static void main(String[] args) {
		
		EmployeeII[] employees = new EmployeeII[5]; 
		
		employees[0] =  new EmployeeII(123456, "Juan", "Sosa", "Engineer", 3520.45, true);
		employees[1] =  new EmployeeII(234561, "José", "Pita", "Mussitian", 2450.33, false);
		employees[2] =  new EmployeeII(345612, "Luis", "Ossa", "Doctor", 4561.38, true);
		employees[3] =  new EmployeeII(456123, "Pepe", "Sanz", "Nurse", 1532.55, false);
		employees[4] =  new EmployeeII(561234, "Tito", "Fiza", "Journalist", 2532.45, true);
		
		for(EmployeeII e : employees) {
			System.out.println("-------------------------");
			System.out.println("ID: " + e.id);
			System.out.println("Nombre: " + e.name);
			System.out.println("Apellido: " + e.surname);
			System.out.println("Cargo: " + e.role);
			System.out.println("Salario: " + e.salary + "USD");
			System.out.println("Activo: " + e.active);
			System.out.println("-------------------------");
		}
		
	}

}

class EmployeeII {
	
	public int id;
	public String name;
	public String surname;
	public String role;
	public double salary;
	public boolean active;
	
	public EmployeeII(int id, String name, String surname, String role, double salary, boolean active) {
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.role = role;
		this.salary = salary;
		this.active = active;
	}
	public EmployeeII(EmployeeII e) { this(e.id, e.name, e.surname, e.role, e.salary, e.active); }
	
}
