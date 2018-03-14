package Strategy;

public class Employee {
	
	private String name;
	private String role;
	private double salary;
	
	protected RaiseStrategy.IRaisable raisePolicy;
	protected BonusStrategy.IBonusable bonusPolicy;
	
	public Employee(String name, String role, double salary) {
		this.name = name;
		this.role = role;
		this.salary = salary;
		
		this.raisePolicy = RaiseStrategy.BasicRaise;
		this.bonusPolicy = BonusStrategy.WithBonus;
	}
	
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	
	public String getRole() { return role; }
	public void setRole(String role) { this.role = role; }
	
	public double getSalary() { return salary; }
	public void setSalary(double salary) { this.salary = salary; }

	public void raise() { this.salary = this.raisePolicy.raise(this.salary); }
	
	public void payBonus() { this.salary += this.bonusPolicy.pay(this.salary); }
	
}
