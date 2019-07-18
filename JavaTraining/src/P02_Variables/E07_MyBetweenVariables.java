package P02_Variables;

public class E07_MyBetweenVariables {

	public static void main(String[] args) {
		
		byte myByte = 123;
		short myShort = 12345;
		int myInteger = 1234567890;
		long myLong = 1234567890123456789L;
		
		System.out.printf("Byte to Float: %,f%n", (float) myByte);
		System.out.printf("Short to Float: %,f%n", (float) myShort);
		System.out.printf("Integer to Float: %,f%n", (float) myInteger);
		System.out.printf("Long to Float: %,f%n", (float) myLong);
		
		System.out.println();
		
		System.out.printf("Byte to Double: %,f%n", (double) myByte);
		System.out.printf("Short to Double: %,f%n", (double) myShort);
		System.out.printf("Integer to Double: %,f%n", (double) myInteger);
		System.out.printf("Long to Double: %,f%n", (double) myLong);
		
		char myChar = '1';
		
		System.out.println();
		
		System.out.printf("Char '1' to Integer: %d%n", (int) myChar);
		
		System.out.println();
		
		myByte = Byte.parseByte("123");
		System.out.printf("String to Byte: %,d%n", myByte);
		
		myShort = Short.parseShort("12345");
		System.out.printf("String to Short: %,d%n", myShort);
		
		myInteger = Integer.parseInt("1234567890");
		System.out.printf("String to Integer: %,d%n", myInteger);
		
		myLong = Long.parseLong("1234567890123456789");
		System.out.printf("String to Long: %,d%n", myLong);
		
		System.out.println();
		
		boolean myBooleanTrue = true;
		boolean myBooleanFalse = false;
		
		System.out.println("The Boolean Variables only accept '" + myBooleanTrue + "' and '" + 
		               myBooleanFalse + "' values");

	}

}
