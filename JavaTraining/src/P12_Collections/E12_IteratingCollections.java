package P12_Collections;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;


public class E12_IteratingCollections {

	public static void main(String[] args) {
		
		List<Employee> employees = new ArrayList<>();
		
		employees.add(new Employee(1, "Juan Sosa", "Trainer"));
		employees.add(new Employee(2, "Carlos Concha", "Operation"));
		employees.add(new Employee(3, "Manuel Perez", "Sales"));
		employees.add(new Employee(4, "Maria Fernandez", "IT"));
		employees.add(new Employee(5, "Laura Gomez", "Trainer"));
		
		System.out.print("FIRST: ");
		System.out.println(employees.stream().findFirst().get());
		
		System.out.println("\nTRAINERS: ");
		employees.stream().filter(Employee.TRAINERS).forEach(Employee.PRINT);
		
		System.out.println("\nSALES: ");
		employees.stream().filter(Employee.SALES).forEach(Employee.PRINT_NAME);
		
	}
	
	private static class Employee {

		public int id;
		public String name;
		public String role;
		
		public Employee(int id, String name, String role) {
			this.id = id;
			this.name = name;
			this.role = role;
		}
		
		public void printName() {
			System.out.println(this.name);
		}
		
		@Override
		public String toString() {
			return this.id + " : " + this.name + " - " + this.role;
		}
		
		public static final Predicate<Employee> TRAINERS = e -> e.role.equals("Trainer"); 
		public static final Predicate<Employee> SALES = e -> e.role.equals("Sales"); 
		
		public static final Consumer<Employee> PRINT = e -> System.out.println(e);
		public static final Consumer<Employee> PRINT_NAME = Employee::printName;
	}

}
