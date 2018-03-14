package Strategy;

public class Manager extends Employee {

	public Manager(String name, String role, double salary) {
		super(name, role, salary);
		
		this.raisePolicy = RaiseStrategy.PlusRaise;
		this.bonusPolicy = BonusStrategy.WithBonus;
	}
	
}
