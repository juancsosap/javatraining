package basic;

import java.util.Scanner;

public class MatrixGen {

	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		
		System.out.print("Matrix Size: ");
		byte size = console.nextByte();
		
		printMatrix(genMatrix(size,0,100));
				
		console.close();
	}
	
	private static void printMatrix(int[][] matrix) {
		for(int[] row:matrix) {
			for(int item:row) {
				System.out.print(item + "\t");
			}
			System.out.println("");
		}
	}
	
	private static int[][] genMatrix(byte size, int minVal, int maxVal) {
		int[][] matrix = new int[size][size];
		
		for(int i = 0; i < size; i++) {
			for(int j = 0; j < size; j++) {
				matrix[i][j] = random(minVal,maxVal);
			}
		}
		
		return matrix; 
	}
	
	private static int random(int min, int max) {
		
		double minVal = (double) min;
		double maxVal = (double) max;
		
		int random;
		
		do {
			random = (int) (Math.random() * (maxVal - minVal + 1) + minVal);
		} while(random > maxVal);
		
		return random;
	}
	
}