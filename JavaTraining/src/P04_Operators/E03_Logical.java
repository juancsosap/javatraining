package P04_Operators;

import java.util.Scanner;

public class E03_Logical {

	public static void main(String[] args) {
		
		// Opening Console Session with AutoClose
		try(Scanner inConsole = new Scanner(System.in)) {
			
			// Printing info in the console with two new lines
			System.out.println("Logica Básicas");
			
			boolean myTrue = true;
			boolean myFalse = false;
			
			// Printing Operations in the console
			System.out.printf("\n----> or  (||)");
			System.out.printf("\n'false' 'false': %b", myFalse || myFalse);
			System.out.printf("\n'false' 'true' : %b", myFalse || myTrue);
			System.out.printf("\n'true'  'false': %b", myTrue || myFalse);
			System.out.printf("\n'true'  'true' : %b", myTrue || myTrue);
			
			System.out.println();
			
			System.out.printf("\n----> and (&&)");
			System.out.printf("\n'false' 'false': %b", myFalse && myFalse);
			System.out.printf("\n'false' 'true' : %b", myFalse && myTrue);
			System.out.printf("\n'true'  'false': %b", myTrue && myFalse);
			System.out.printf("\n'true'  'true' : %b", myTrue && myTrue);
			
			System.out.println();
			
			System.out.printf("\n----> not (!)");
			System.out.printf("\n'false'        : %b", !myFalse);
			System.out.printf("\n'true'         : %b", !myTrue);
						
		}

	}

}
