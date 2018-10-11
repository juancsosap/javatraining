package P14_DesignPatterns;

public class E02_Builder {

	public static void main(String[] args) {
		
		Employee juan = new Employee.Builder()
				                    .id(1)
				                    .name("Juan Sosa")
				                    .role("Trainer")
				                    .build();
		
		System.out.println(juan);
		
	}
	
	private static class Employee {
		
		public int id;
		public String name;
		public String role;
		
		@Override
		public String toString() {
			return this.id + " : " + this.name + " - " + this.role;
		}
		
		public static class Builder {
			
			private Employee emp;
			
			public Builder() {
				this.emp = new Employee();
			}
			
			public Builder id(int id) {
				this.emp.id = id;
				return this;
			}
			
			public Builder name(String name) {
				this.emp.name = name;
				return this;
			}
			
			public Builder role(String role) {
				this.emp.role = role;
				return this;
			}
			
			public Employee build() {
				return this.emp;
			}
			
		}
		
	}

}
