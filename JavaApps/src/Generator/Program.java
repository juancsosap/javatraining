package Generator;

import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		
		try(Scanner scan = new Scanner(System.in)) {
			System.out.print("Quantity: ");
			int quantity = scan.nextInt();
			
			System.out.println();
			System.out.println("Abstract Class Generator");
			System.out.printf("Result: %s\n", Adder.add(quantity, new SecuentialGenerator()));
			System.out.printf("Result: %s\n", Adder.add(quantity, new EvenGenerator()));
			System.out.printf("Result: %s\n", Adder.add(quantity, new OddGenerator()));
			
			System.out.println();
			System.out.println("Lambda Generator");
			System.out.printf("Result: %s\n", Adder.add(quantity, Generators.SecuentialGenerator));
			System.out.printf("Result: %s\n", Adder.add(quantity, Generators.EvenGenerator));
			System.out.printf("Result: %s\n", Adder.add(quantity, Generators.OddGenerator));
		}
		
	}
	
}
