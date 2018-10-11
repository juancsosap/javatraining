package P02_Variables;

public class E06_MyFloatCasting {

	public static void main(String[] args) {
		
		// Assigning native 'float' value from new Float Wrapper Object
		// The float value doesn't require casting for the Wrapper Object Creation
		float myFloat = Float.valueOf(12345678901234567890.0123456789F);
		System.out.printf("The Float value %,f%n", myFloat);
		double myDoubleFloat = myFloat;
		System.out.printf("Promoted to Double: %,f %n%n", myDoubleFloat);
		
		// Assigning native 'double' value from new Double Wrapper Object
		// The double value doesn't require casting for the Wrapper Object Creation
		double myDouble = Double.valueOf(12345678901234567890.0123456789);
		System.out.printf("The Double value %,f%n", myDouble);
		float myFloatDouble = (float) myDouble;
		System.out.printf("Casted to Float: %,f%n", myFloatDouble); 
		
	}

}
