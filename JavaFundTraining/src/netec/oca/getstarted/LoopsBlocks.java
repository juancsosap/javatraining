package netec.oca.getstarted;

import java.util.Scanner;

public class LoopsBlocks {

	public static void main(String[] args) {
		
		// WhileTests.test();
		
		// WhileValidation.validate();
		
		// DoWhileValidation.validate();
		
		// ForTest.test();
		
		ForEachTest.test();
		
	}

}

class WhileValidation {
	
	public static void validate() {
		
		try(Scanner console = new Scanner(System.in)){
			
			while(true) {
				System.out.print("Age: ");
				int age = console.nextInt();
				
				if(age >= 0) break;
				
				System.out.println("Age invalid, only possitiva values are supported");
			}

			int edad = -1;
			while(edad < 0) {
				System.out.print("Edad: ");
				edad = console.nextInt();
				
				if(edad < 0)
					System.out.println("Age invalid, only possitiva values are supported");
			}
			
			System.out.print("Altura: ");
			double altura;
			while( (altura = console.nextDouble()) < 0 ) {
				 System.out.println("Altura invalida");
				 System.out.print("Altura: ");
			}
			System.out.println("La altura es: " + altura);
			
		}
		
	}
	
}

class DoWhileValidation {
	
	public static void validate() {
		
		try(Scanner console = new Scanner(System.in)){
			
			do {
				System.out.print("Age: ");
				int age = console.nextInt();
				
				if(age >= 0) break;
				
				System.out.println("Age invalid, only possitiva values are supported");
			} while(true);

			int edad;
			do {
				System.out.print("Edad: ");
				edad = console.nextInt();
				
				if(edad < 0)
					System.out.println("Age invalid, only possitiva values are supported");
			} while(edad < 0);
			
		}
		
	}
	
}

class WhileTests {
	
	public static void test() {
		
		int num1 = 10;
		while(true) {
			System.out.println("The number is: " + num1--);
			// Condicion de Salida
			if(num1 < 0)
				break;	
		}
		
		int num2 = 10;
		// Condicion de permanencia
		while(num2 >= 0) {
			System.out.println("The number is: " + num2--);
		}
				
	}
	
}

class ForTest {
	
	public static void test() {
		
		int num1 = 0;
		while(num1 <= 10) {
			System.out.print(num1 + " ");
			num1++;
		}
		
		System.out.println();
		
		int num2 = 0;
		do {
			System.out.print(num2 + " ");
			num2++;
		} while(num2 <= 10);
		
		System.out.println();
		
		int num3 = 0;
		for(;num3 <= 10;) {
			System.out.print(num3 + " ");
			num3++;
		}

		System.out.println();
		
		for(int num4=0; num4 <= 10;) {
			System.out.print(num4 + " ");
			num4++;
		}

		System.out.println();
		
		for(int num4=0; num4 <= 10; num4++) {
			System.out.print(num4 + " ");
		}
		
		System.out.println();
		
		try(Scanner console = new Scanner(System.in)){
			for(int edad=-1; edad < 0; printerror(edad < 0)) {
				System.out.print("Edad: ");
				edad = console.nextInt();
			}
			
			double altura;
			for(System.out.print("Altura: "); (altura = console.nextDouble()) < 0; System.out.print("Altura: ")) {
				 System.out.println("Altura invalida");
			}
			System.out.println("La altura es: " + altura);
		}
		
		
		for(int i=0; i<=10; i+=3) {
			System.out.print(i + " ");
		}
		
		for(int i=0; i<=10; i+=3) {
			System.out.print(i + " ");
		}

	}
	
	private static void printerror(boolean status) {
		if(status)
			System.out.println("Age invalid, only possitiva values are supported");
	}
	
}

class ForEachTest {
	
	public static void test() {
		
		int[] nums = {1, 2, 3, 4, 5, 6};
				
		for(int num : nums) {
			System.out.print(num + " ");
		}
	
		System.out.println();
		
		for(int i=0; i<nums.length; i++) {
			System.out.print(nums[i] + " ");
		}

		System.out.println();
		
		int[] row1 = {1, 2, 3};
		int[] row2 = {4, 5, 6};
		int[] row3 = {7, 8, 9};
		
		int[][] matrix = {row1, row2, row3};
		
		// int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
		
		/*
		int[][] matrix = {{1, 2, 3}, 
				          {4, 5, 6}, 
				          {7, 8, 9}};
		*/

		for(int[] row : matrix) {
			for(int val : row) {
				System.out.print(val + " ");
			}
			System.out.println();
		}
		
		System.out.println();

		for(int i=0; i<matrix.length; i++) {
			for(int j=0; j<matrix[i].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
		
		System.out.println();
		
		String[] nombres = {"Juan", "Carlos", "Luis"};
		int[] edades = {30, 40, 50};
		
		for(int i=0; i<nombres.length; i++) {
			System.out.println(nombres[i] + " " + edades[i]);
		}
		
		class Persona {
			String nombre;
			int edad;
			
			public Persona(String n, int e) {
				nombre = n;
				edad = e;
			}
		}
		
		System.out.println();
		
		Persona[] personas = {new Persona("Juan", 30), 
				              new Persona("Carlos", 40), 
				              new Persona("Luis", 50)};
		
		for(Persona p : personas) {
			System.out.println(p.nombre + " " + p.edad);
		}

	}
	
}