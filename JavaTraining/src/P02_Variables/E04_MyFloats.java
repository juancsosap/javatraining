package P02_Variables;

public class E04_MyFloats {

	public static void main(String[] args) {
		
		Float minFloat = Float.MIN_VALUE;
		float maxFloat = Float.MAX_VALUE;
		System.out.printf("The Float value could be from %,f to %,f%n", minFloat, maxFloat);
		System.out.println("The Float ocupate 4 Byte in memory");
		float myFloat = 123456789012345678901234567890123456789.000001F;
		System.out.printf("The value: %,f is a Float%n%n", myFloat);
		
		Double minDouble = Double.MIN_VALUE;
		double maxDouble = Double.MAX_VALUE;
		System.out.printf("The Double value could be from %,f to %,f%n", minDouble, maxDouble);
		System.out.println("The Double ocupate 8 Byte in memory");
		double myDouble = 12345678901234567890123456789012345678901234567890.0;
		System.out.printf("The value: %,f is a Double%n%n", myDouble);
		
	}

}
