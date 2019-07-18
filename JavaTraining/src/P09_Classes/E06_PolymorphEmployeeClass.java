package P09_Classes;

public class E06_PolymorphEmployeeClass {

	public static void main(String[] args) {
		
		Person employee = new Employee("Juan", "Sosa", 123456, "Engineer", 3520.45, true); 
		System.out.println("EMPLOYEE");
		System.out.println(employee.getDescription());
		
		Person manager = new Manager(new Employee("Carlos", "Peña", 234561, "General Manager", 7575.55, true), new Employee[] { (Employee) employee }) ; 
		System.out.println("\nMANAGER");
		System.out.println(manager.getDescription());
		
		Person customer = new Customer("Luis", "Perez", 101);
		System.out.println("\nCUSTOMER");
		System.out.println(customer.getDescription());
		
	}

}