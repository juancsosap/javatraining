package netec.oca.getstarted;

import java.util.function.BiFunction;

public class Operator {

	public static void main(String[] args) {
		double result = Operator.calculate(new Operator.Division(), 1.0, 2.0, 3.0, 4.0);
		System.out.println(result);
	}
	
	public static double calculate(UnaryBiOperator operation, double ... values) throws IllegalArgumentException {
		if(values.length < 2) {
			throw new IllegalArgumentException("As minimum 2 values must be provided,");
		} else {
			double result = values[0];
			for(int i=1; i<values.length; i++) {
				result = operation.apply(result, values[i]);
			}
			return result;
		}
	}
	
	public static interface UnaryBiOperator extends BiFunction<Double, Double, Double> {}
	
	public static final UnaryBiOperator Addition = (v1, v2) -> v1 + v2;
	public static final UnaryBiOperator Substraction = (v1, v2) -> v1 - v2;
	public static final UnaryBiOperator Multiplication = (v1, v2) -> v1 * v2;
	
	public static class Division implements UnaryBiOperator {

		@Override
		public Double apply(Double v1, Double v2) {
			if(v2 == 0) {
				return null;
			} else {
				return v1 / v2;
			}
		}
		
	}
	

}
