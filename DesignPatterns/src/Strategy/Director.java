package Strategy;

public class Director extends Manager {

	public Director(String name, String role, double salary) {
		super(name, role, salary);
		
		this.raisePolicy = RaiseStrategy.PlusRaise;
		this.bonusPolicy = BonusStrategy.WithBonus;
	}
	
}
