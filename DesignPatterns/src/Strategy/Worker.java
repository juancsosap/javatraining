package Strategy;

public class Worker extends Employee {

	public Worker(String name, String role, double salary) {
		super(name, role, salary);
		
		this.raisePolicy = RaiseStrategy.BasicRaise;
		this.bonusPolicy = BonusStrategy.WithoutBonus;
	}
	
}
