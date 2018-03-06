package P09_Classes;

public class E01_BasicEmployeeClass {

	public static void main(String[] args) {
		
		EmployeeI e1 =  new EmployeeI();
		
		e1.id = 123456;
		e1.name = "Juan";
		e1.surname = "Sosa";
		e1.role = "Engineer";
		e1.salary = 3520.45;
		e1.active = true;
		
		System.out.println("ID: " + e1.id);
		System.out.println("Nombre: " + e1.name);
		System.out.println("Apellido: " + e1.surname);
		System.out.println("Cargo: " + e1.role);
		System.out.println("Salario: " + e1.salary + "USD");
		System.out.println("Activo: " + e1.active);
		
	}

}

class EmployeeI {
	
	public int id;
	public String name;
	public String surname;
	public String role;
	public double salary;
	public boolean active;
	
}
