package P02_Variables;

public class E04_MyIntegerCasting {

	public static void main(String[] args) {
		
		short BYTEVALUES = -((short) Byte.MIN_VALUE)*2;
		int SHORTVALUES = -((int) Short.MIN_VALUE)*2;
		long INTEGERVALUES = -((long) Integer.MIN_VALUE)*2;
		
		// Assigning native 'byte' value from new Byte Wrapper Object
		// The integer value must be casted to 'byte' for the Wrapper Object Creation
		byte myByte = new Byte((byte) 100);
		System.out.printf("The Byte value %,d%n", myByte);
		short myShortByte = myByte;
		System.out.printf("Promoted to Short: %,d %n", myShortByte);
		int myIntegerByte = myByte;
		System.out.printf("Promoted to Integer: %,d %n", myIntegerByte);
		long myLongByte = myByte;
		System.out.printf("Promoted to Long: %,d %n%n", myLongByte);
		
		// Assigning native 'short' value from new Short Wrapper Object
		// The integer value must be casted to 'short' for the Wrapper Object Creation
		short myShort = new Short((short) 10000);
		System.out.printf("The Short value %,d%n", myShort);
		byte myByteShort = (byte) myShort;
		System.out.printf("Casted to Byte: %,d (%,d * %,d + %,d)%n", 
				myByteShort, myShort/BYTEVALUES, BYTEVALUES, myByteShort);
		int myIntegerShort = myShort;
		System.out.printf("Promoted to Integer: %,d %n", myIntegerShort);
		long myLongShort = myShort;
		System.out.printf("Promoted to Long: %,d %n%n", myLongShort);
		
		// Assigning native 'int' value from new Integer Wrapper Object
		// The integer value doesn't require casting for the Wrapper Object Creation
		int myInteger = new Integer(1000000000);
		System.out.printf("The Integer value %,d%n", myInteger);
		byte myByteInteger = (byte) myInteger;
		System.out.printf("Casted to Byte: %,d (%,d * %,d + %,d)%n", 
				myByteInteger, myInteger/BYTEVALUES, BYTEVALUES, myByteInteger);
		short myShortInteger = (short) myInteger;
		System.out.printf("Casted to Short: %,d (%,d * %,d + %,d)%n", 
				myShortInteger, myInteger/SHORTVALUES, SHORTVALUES, myShortInteger);
		long myLongInteger = myInteger;
		System.out.printf("Promoted to Long: %,d %n%n", myLongInteger);
		
		// Assigning native 'long' value from new Long Wrapper Object
		// The long value doesn't require casting for the Wrapper Object Creation
		long myLong = new Long(1000000000000000000L);
		System.out.printf("The Long value %,d%n", myLong);
		byte myByteLong = (byte) myLong;
		System.out.printf("Casted to Byte: %,d (%,d * %,d + %,d)%n", 
				myByteLong, myLong/BYTEVALUES, BYTEVALUES, myByteLong);
		short myShortLong = (short) myLong;
		System.out.printf("Casted to Short: %,d (%,d * %,d + %,d)%n", 
				myShortLong, myLong/SHORTVALUES, SHORTVALUES, myShortLong);
		int myIntegerLong = (int) myLong;
		System.out.printf("Casted to Integer: %,d (%,d * %,d + %,d)%n", 
				myIntegerLong, myLong/INTEGERVALUES, INTEGERVALUES, myIntegerLong);
		
	}

}
