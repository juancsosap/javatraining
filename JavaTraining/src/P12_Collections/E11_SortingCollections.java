package P12_Collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class E11_SortingCollections {

	public static void main(String[] args) {

		System.out.println("COMPARABLE BY ID (DEFAULT) (AUTO) - TREESET");
		
		Set<Employee> employees = new TreeSet<>();
		
		employees.add(new Employee(3, "Juan Sosa", "Trainer"));
		employees.add(new Employee(4, "Carlos Concha", "Operation"));
		employees.add(new Employee(2, "Manuel Perez", "Sales"));
		employees.add(new Employee(5, "Maria Fernandez", "IT"));
		employees.add(new Employee(1, "Laura Gomez", "Trainer"));
		
		for(Employee emp : employees) {
			System.out.println(emp);
		}
		
		System.out.println("\nCOMPARABLE BY ID (DEFAULT) - ARRAYLIST");
		
		List<Employee> empls = new ArrayList<>();
		
		empls.add(new Employee(3, "Juan Sosa", "Trainer"));
		empls.add(new Employee(4, "Carlos Concha", "Operation"));
		empls.add(new Employee(2, "Manuel Perez", "Sales"));
		empls.add(new Employee(5, "Maria Fernandez", "IT"));
		empls.add(new Employee(1, "Laura Gomez", "Trainer"));
		
		Collections.sort(empls);
		
		for(Employee emp : empls) {
			System.out.println(emp);
		}
		
		System.out.println("\nCOMPARATOR BY ID");
		
		Collections.sort(empls, Employee.BY_ID);
		
		for(Employee emp : empls) {
			System.out.println(emp);
		}

		System.out.println("\nCOMPARATOR BY NAME");
		
		Collections.sort(empls, Employee.BY_NAME);
		
		for(Employee emp : empls) {
			System.out.println(emp);
		}

		System.out.println("\nCOMPARATOR BY ROLE");
		
		Collections.sort(empls, Employee.BY_ROLE);
		
		for(Employee emp : empls) {
			System.out.println(emp);
		}
	}
	
	private static class Employee implements Comparable<Employee> {

		public int id;
		public String name;
		public String role;
		
		public Employee(int id, String name, String role) {
			this.id = id;
			this.name = name;
			this.role = role;
		}
		
		@Override
		public int compareTo(Employee other) {
			return (this.id > other.id) ? 1 : (this.id < other.id) ? -1 : 0;
		}
		
		@Override
		public String toString() {
			return this.id + " : " + this.name + " - " + this.role;
		}
		
		public static final Comparator<Employee> BY_ID = new EmployeeIdComparator();
		private static class EmployeeIdComparator implements Comparator<Employee> {

			@Override
			public int compare(Employee e1, Employee e2) {
				return e1.compareTo(e2);
			}
			
		};
		
		public static final Comparator<Employee> BY_NAME = new Comparator<Employee>() {

			@Override
			public int compare(Employee e1, Employee e2) {
				return e1.name.compareTo(e2.name);
			}
			
		};
		
		//public static final Comparator<Employee> BY_ID = (e1, e2) -> e1.compareTo(e2);
		//public static final Comparator<Employee> BY_NAME = (e1, e2) -> e1.name.compareTo(e2.name);
		public static final Comparator<Employee> BY_ROLE = (e1, e2) -> e1.role.compareTo(e2.role);
		
		
	}

}
