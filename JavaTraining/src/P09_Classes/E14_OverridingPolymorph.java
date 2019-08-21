package P09_Classes;

public class E14_OverridingPolymorph {

	public static void main(String[] args) {
		
		Employee p1 = new Employee();
		p1.describe();
		p1.type();
		
		Employee p2 = new Manager();
		p2.describe();
		p2.type();
		
	}
	
	static class Person {
		public void describe() {
			System.out.println("Person");
		}
	}
	

	static class Employee extends Person {
		public void describe() {
			System.out.println("Employee");
		}
		public void type() {
			System.out.print("Class ");
			describe();
		}
	}

	static class Manager extends Employee {
		public void describe() {
			System.out.println("Manager");
		}
	}

}
