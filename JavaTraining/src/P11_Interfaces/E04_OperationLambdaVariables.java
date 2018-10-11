package P11_Interfaces;

import java.util.Scanner;

public class E04_OperationLambdaVariables {

	public static void main(String[] args) {

		try(Scanner console = new Scanner(System.in)) {
			
			System.out.print("NUM1 : ");
			double num1 = Double.parseDouble(console.nextLine());
			System.out.print("NUM2 : ");
			double num2 = Double.parseDouble(console.nextLine());
			
			IOperation[] operations = new IOperation[4];
			
			operations[0] = Addition;
			operations[1] = Substraction;
			operations[2] = Multiplication;
			operations[3] = Division;
			
			for(IOperation oper : operations) {
				System.out.println(oper.getClass().getName());
				System.out.println(oper.calculate(num1, num2));
			}
			
		}

	}
	
	@FunctionalInterface
	interface IOperation {
		
		public double calculate(double num1, double num2);
				
	}

	static IOperation Addition = (num1, num2) -> num1 + num2;
	static IOperation Substraction = (num1, num2) -> num1 - num2;
	static IOperation Multiplication = (num1, num2) -> num1 * num2;
	static IOperation Division = (num1, num2) -> num1 / num2;
	
}

