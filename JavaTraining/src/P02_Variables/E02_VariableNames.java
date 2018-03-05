package P02_Variables;

public class E02_VariableNames {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		
		// Invalid variables names
		// Not start with numbers
		// int 0my = 0;
		
		// Only letters upper and lower case, numbers and '$' or '_' are valid characters
		// int my-num = 123;
		
		// Valid variable names
		int myone = 1;
		int my_ten = 10;
		int my100 = 100;
		int myThousand = 1000;
		
		boolean _my_true = true;
		boolean $myFalse = false;
		
		// the type of value could not be changed
		int num = 1;
		// num = "1";
		// num = 1.0;
		// num = true;
		
		// Native variable types
		byte mybyte = 100;
		short myshort = 10000;
		int myint = 1000000000;
		long mylong = 1000000000000000000L;
		
		char mycharcode = 65;
		char mycharvalue = 'A';
		System.out.println(mycharcode + mycharvalue);
		
		float myfloat = 1.111111F;
		double mydouble = 1.11111111111;
		
	}

}
