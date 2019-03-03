package P07_Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class E06_MatrixAdder {

    public static void main(String[] args) {
        
        try(Scanner scan = new Scanner(System.in)) {
            System.out.println("Matrix Adder");
        
            System.out.print("Number of Rows: ");
            int rows = scan.nextInt();
            System.out.print("Number of Columns: ");
            int columns = scan.nextInt();
            
            int[][] matrix1 = new int[rows][columns];
            int[][] matrix2 = new int[rows][columns];
            
            System.out.println("Matrix #1");
            for(int i=0; i<rows; i++) {
                for(int j=0; j<columns; j++) {
                    System.out.print("Value (" + (i+1) + "," + (j+1) + "): ");
                    matrix1[i][j] = scan.nextInt();
                }
            }

            System.out.println("Matrix #2");
            for(int i=0; i<rows; i++) {
                for(int j=0; j<columns; j++) {
                    System.out.print("Value (" + (i+1) + "," + (j+1) + "): ");
                    matrix2[i][j] = scan.nextInt();
                }
            }
            
            int[][] result = new int[rows][columns];
            
            for(int i=0; i<rows; i++) {
                for(int j=0; j<columns; j++) {
                    result[i][j] = matrix1[i][j] + matrix2[i][j];
                }
            }
            
            System.out.println("Matrix #1 : ");
            for(int[] row : matrix1) {
                System.out.println(Arrays.toString(row));
            }
            System.out.println("Matrix #2 : ");
            for(int[] row : matrix2) {
                System.out.println(Arrays.toString(row));
            }
            System.out.println("Result    : ");
            for(int[] row : result) {
                System.out.println(Arrays.toString(row));
            }
            
        }
        
    }
    
}