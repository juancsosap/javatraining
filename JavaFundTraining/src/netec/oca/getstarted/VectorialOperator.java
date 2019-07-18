package netec.oca.getstarted;

import java.util.Scanner;

/* 
 * INPUT -> length
 *          vectorA
 *          vectorB
 *          operation
 * 
 * vectorA = {10, 20, 30, 40, 50}
 * vectorB = {2, 4, 6, 8, 10}
 * 
 * 
 * OUTPUT
 * 
 * vectorS = {12, 24, 36, 48, 60}
 * vectorR = {8, 16, 24, 32, 40}
 * vectorM = {20, 80, 180, 320, 500}
 * vectorD = {5, 5, 5, 5, 5}
 * 
 */

public class VectorialOperator {

	public static void main(String[] args) {
		
		try(Scanner console = new Scanner(System.in)){
			
			System.out.println("Vectorial Operator\n");
			
			int size = loadPossitiveInt(console, "Vector Length", 1);
			
			System.out.println("\n-> Vector A");
			double[] vectorA = loadVector(console, size);
			printVector(vectorA, "VectorA");
			
			System.out.println("\n-> Vector B");
			double[] vectorB = loadVector(console, size);
			printVector(vectorB, "VectorB");
			
			String menu = "A. Addition \nS. Substraction \nM. Multiplication \nD. Divition";
			char operation = loadOption(console, "Operation", menu, new char[] {'A', 'S', 'M', 'D'});
			
			double[] result = vectorA.clone();
			switch(operation) {
				case 'A':
					result = vectorAddition(vectorA, vectorB);
					break;
				case 'S':
					result = vectorSubstraction(vectorA, vectorB);
					break;
				case 'M':
					result = vectorMultiplication(vectorA, vectorB);
					break;
				case 'D':
					result = vectorDivition(vectorA, vectorB);
					break;
			}
			
			printVector(result, "Result");
			
		}
		
	}
	
	private static int loadPossitiveInt(Scanner console, String msg, int minValue) {
		int value;
		do {
			System.out.print(msg + ": ");
			String input = console.nextLine();
			if(input.isEmpty()) continue;
			try {
				value = Integer.parseInt(input);
				if(value >= minValue) return value;
			} catch(Exception e) {}
			System.out.println("Error: Invalid Value");
		} while(true);
	}
	
	private static double[] loadVector(Scanner console, int size) {
		double[] vector = new double[size];
		for(int i=0; i<size; i++) {
			String input;
			do {
				System.out.printf("%3d: ", i);
				input = console.nextLine();
				try {
					double value = Double.parseDouble(input);
					vector[i] = value;
				} catch(Exception e) {
					System.out.println("Error: Invalid Value");
					input = "";
				}
			} while(input.isEmpty());
		}
		return vector;
	}
	
	private static void printVector(double[] vector, String name) {
		System.out.print(name + ": {");
		for(double val : vector)
			System.out.print(val + ", ");
		System.out.println("}");
	}

	private static char loadOption(Scanner console, String msg, String menu, char[] options) {
		char option;
		
		System.out.println("\n" + menu + "\n");
		do {
			System.out.print("Option: ");
			String input = console.nextLine();
			if(input.isEmpty()) continue;
			option = input.charAt(0);
			for(char opt : options)
				if(option == opt)
					return option;
			System.out.println("Error: Invalid Option");
		} while(true);
	}
	
	private static double[] vectorAddition(double[] v1, double[] v2) {
		double[] result = v1.clone();
		for(int i=0; i<v1.length; i++)
			result[i] += v2[i];
		return result;
	}
	
	private static double[] vectorSubstraction(double[] v1, double[] v2) {
		double[] result = v1.clone();
		for(int i=0; i<v1.length; i++)
			result[i] -= v2[i];
		return result;
	}

	private static double[] vectorMultiplication(double[] v1, double[] v2) {
		double[] result = v1.clone();
		for(int i=0; i<v1.length; i++)
			result[i] *= v2[i];
		return result;
	}

	private static double[] vectorDivition(double[] v1, double[] v2) {
		double[] result = v1.clone();
		for(int i=0; i<v1.length; i++)
			result[i] /= v2[i];
		return result;
	}

}
