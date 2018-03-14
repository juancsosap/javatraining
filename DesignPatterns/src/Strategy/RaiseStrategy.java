package Strategy;

public class RaiseStrategy {

	public interface IRaisable {
		public double raise(double salary);		
	}
	
	public static final IRaisable BasicRaise   = s -> s * 1.05;
	public static final IRaisable PlusRaise  = s -> s * 1.10;
	
}
