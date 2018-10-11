package netec.oca.getstarted;

import java.util.Scanner;

public class Calc {

	public static void main(String[] args) {
		
		try(Scanner console = new Scanner(System.in)){
		
			try {
				System.out.print("Number A: ");
				String strA = console.nextLine();
				int intA = Integer.parseInt(strA);
				
				System.out.print("Number B: ");
				String strB = console.nextLine();
				int intB = Integer.parseInt(strB);
				
				if(intB % 2 != 0)
					throw new OddNumberException();
					
				int intC = intA / intB;
				
				System.out.println("Result: " + intC);
			} catch(Exception ex) {
				System.out.println(ex.getClass());
				System.out.println("Error: " + ex.getMessage());
			} 
			
		}
		
	}

}

@SuppressWarnings("serial")
class OddNumberException extends ArithmeticException {
	
	public OddNumberException() {
		super("Odd number are not valid");
	}
	
}
