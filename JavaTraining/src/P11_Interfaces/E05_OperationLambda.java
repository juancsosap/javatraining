package P11_Interfaces;

import java.util.Scanner;

public class E05_OperationLambda {

	public static void main(String[] args) {

		try(Scanner console = new Scanner(System.in)) {
			
			System.out.print("NUM1 : ");
			double num1 = Double.parseDouble(console.nextLine());
			System.out.print("NUM2 : ");
			double num2 = Double.parseDouble(console.nextLine());
			
			IOperation[] operations = new IOperation[4];
			
			operations[0] = (n1, n2) -> n1 + n2;
			operations[1] = (n1, n2) -> n1 - n2;
			operations[2] = (n1, n2) -> n1 * n2;
			operations[3] = (n1, n2) -> n1 / n2;
			
			for(IOperation oper : operations) {
				System.out.println(oper.calculate(num1, num2));
			}
			
		}

	}
	
	@FunctionalInterface
	interface IOperation {
		
		public double calculate(double num1, double num2);
				
	}
	
}

