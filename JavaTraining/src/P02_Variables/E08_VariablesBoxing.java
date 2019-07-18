package P02_Variables;

public class E08_VariablesBoxing {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		
		int native_int = 5;
		Integer wrapper_int = Integer.valueOf(5);
		int outboxing_int = Integer.valueOf(5);
		Integer autoboxing_int = 5;
		
		double native_double = 5.0;
		Double wrapper_double = Double.valueOf(5.0);
		double unboxing_double = Double.valueOf(5.0);
		Double boxing_double = 5.0;

	}

}
