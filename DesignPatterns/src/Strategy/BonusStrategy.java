package Strategy;

public class BonusStrategy {

	public interface IBonusable {
		public double pay(double salary);		
	}
	
	public static final IBonusable WithoutBonus = s -> 0;
	public static final IBonusable WithBonus    = s -> s * 0.20;
	
}
