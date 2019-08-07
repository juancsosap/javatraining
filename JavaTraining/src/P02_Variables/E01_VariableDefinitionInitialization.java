package P02_Variables;

public class E01_VariableDefinitionInitialization {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		
		// Definition
		int myvarint;
		// Initialization
		myvarint = 10;
		
		// Definition and Initialization
		boolean myvarboolean = true;
		
		// Multiple Definition
		int num1, num2, num3;
		// Multiple Initialization
		num1 = 10; num2 = 20; num3 = 30;
		System.out.println(num1 + " - " + num2 + " - " + num2);
		
		// Multiple Definition and Initialization
		int num4 = 10, num5 = 20, num6 = 30;
		System.out.println(num4 + " - " + num5 + " - " + num6);
		
		// Multiple Assignation
		num1 = num2 = num3 = 40;
		System.out.println(num1 + " - " + num2 + " - " + num2);
		
	}

}
