package Strategy;

public class _Program {

	public static void main(String[] args) {
		Employee[] employees = { new Employee("Juan Sosa", "Engineer", 1000),
				                 new Worker  ("José Peña", "Builder",  500),
				                 new Manager ("Luis Sanz", "Manager",  2000),
				                 new Director("Pepe Fito", "CTO",      5000) };
				
		for(Employee e : employees) {
			e.raise();
			e.payBonus();
			
			System.out.printf("%-18s : %-10s - %-10s : USD %,.2f%n", e.getClass().getName(), e.getName(), e.getRole(), e.getSalary());
		}
	}

}
