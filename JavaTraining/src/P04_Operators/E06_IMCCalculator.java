package P04_Operators;

import java.util.Scanner;

public class E06_IMCCalculator {

	public static void main(String[] args) {
		
		try(Scanner scan = new Scanner(System.in)) {
            
			System.out.println(" IMC Calculator ");
			System.out.println("----------------\n");
            
            System.out.print("Peso (Kg) : ");
            int peso = Integer.parseInt(scan.nextLine());
            
            System.out.print("Altura (cm): ");
            double altura = Integer.parseInt(scan.nextLine()) / 100.0;
            
            double imc = peso / (altura * altura);
            
            System.out.println("\n----------------");
            System.out.printf("Su IMC es %.2f\n", imc);
            
        }

	}

}
