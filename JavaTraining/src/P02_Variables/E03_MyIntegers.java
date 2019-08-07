package P02_Variables;

public class E03_MyIntegers {

	public static void main(String[] args) {
		
		// Defining a Byte Wrapper Object
		Byte minByte = Byte.MIN_VALUE;
		// Defining a native 'byte' value
		byte maxByte = Byte.MAX_VALUE;
		System.out.printf("The Byte value could be from %,d to %,d%n", minByte, maxByte);
		System.out.println("The Byte ocupate 1 Byte in memory");
		byte myByte = 100;
		System.out.printf("The value: %,d is a Byte%n%n", myByte);
		
		// Defining a Short Wrapper Object
		Short minShort = Short.MIN_VALUE;
		// Defining a native 'short' value
		short maxShort = Short.MAX_VALUE;
		System.out.printf("The Short value could be from %,d to %,d%n", minShort, maxShort);
		System.out.println("The Short ocupate 2 Byte in memory");
		short myShort = 10_000;
		System.out.printf("The value: %,d is a Byte and a Short%n", myByte);
		System.out.printf("The value: %,d is a Short but not a Byte%n%n", myShort);
		
		// Defining a Integer Wrapper Object
		Integer minInteger = Integer.MIN_VALUE;
		// Defining a native 'int' value
		int maxInteger = Integer.MAX_VALUE;
		System.out.printf("The Integer value could be from %,d to %,d%n", minInteger, maxInteger);
		System.out.println("The Integer ocupate 4 Byte in memory");
		int myInteger = 1_000_000_000;
		System.out.printf("The value: %,d is a Byte, a Short, and an Integer%n", myByte);
		System.out.printf("The value: %,d is a Short, an Integer but not a Byte%n", myShort);
		System.out.printf("The value: %,d is an Integer but not a Byte or a Short%n%n", myInteger);
		
		// Defining a Long Wrapper Object
		Long minLong = Long.MIN_VALUE;
		// Defining a native 'long' value
		long maxLong = Long.MAX_VALUE;
		System.out.printf("The Long value could be from %,d to %,d%n", minLong, maxLong);
		System.out.println("The Long ocupate 8 Byte in memory");
		long myLong = 1_000_000_000_000_000_000L;
		System.out.printf("The value: %,d is a Byte, a Short, an Integer and a Long%n", myByte);
		System.out.printf("The value: %,d is a Short, an Integer and a Long but not a Byte%n", myShort);
		System.out.printf("The value: %,d is an Integer and a Long but not a Byte or a Short%n", myInteger);
		System.out.printf("The value: %,d is a Long but not a Byte or a Short or and Integer%n%n", myLong);
	
	}

}
