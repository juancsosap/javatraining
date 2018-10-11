package P11_Interfaces;

import java.util.Scanner;

public class E01_OperationInterface {

	public static void main(String[] args) {
		
		try(Scanner console = new Scanner(System.in)) {
			
			System.out.print("NUM1 : ");
			double num1 = Double.parseDouble(console.nextLine());
			System.out.print("NUM2 : ");
			double num2 = Double.parseDouble(console.nextLine());
			
			IOperation[] operations = new IOperation[4];
			
			operations[0] = new Addition();
			operations[1] = new Substraction();
			operations[2] = new Multiplication();
			operations[3] = new Division();
			
			for(IOperation oper : operations) {
				String oper_name = oper.getClass().getName().split("[.]")[1];
				System.out.println(oper_name + " : " + oper.calculate(num1, num2));
			}
			
		}
		
	}

}

interface IOperation {
	
	public double calculate(double num1, double num2);
	
}

class Addition implements IOperation {

	@Override
	public double calculate(double num1, double num2) {
		return num1 + num2;
	}
	
}

class Substraction implements IOperation {

	@Override
	public double calculate(double num1, double num2) {
		return num1 - num2;
	}
	
}

class Multiplication implements IOperation {

	@Override
	public double calculate(double num1, double num2) {
		return num1 * num2;
	}
	
}

class Division implements IOperation {

	@Override
	public double calculate(double num1, double num2) {
		return num1 / num2;
	}
	
}

