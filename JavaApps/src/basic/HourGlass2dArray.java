package basic;

import java.util.*;

public class HourGlass2dArray {

	private static int arr[][] = new int[6][6];
			
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        loadMatrix(in);
        printMatrix();
        printHourglasses();
        printSumHourglasses();
        in.close();
    }
    
    public static void loadMatrix(Scanner in) {
        for(int i=0; i < 6; i++){
            for(int j=0; j < 6; j++){
                arr[i][j] = in.nextInt();
            }
        }    	
    }

    public static void printMatrix() {
        for(int i=0; i < 6; i++){
            for(int j=0; j < 6; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void printHourglasses() {
        for(int i=1; i < 5; i++){
            for(int j=1; j < 5; j++){
                System.out.print(arr[i-1][j-1] + " ");
                System.out.print(arr[i-1][j] + " ");
                System.out.println(arr[i-1][j+1]);
                System.out.println("  " + arr[i][j]);
                System.out.print(arr[i+1][j-1] + " ");
                System.out.print(arr[i+1][j] + " ");
                System.out.println(arr[i+1][j+1]);
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void printSumHourglasses() {
        for(int i=1; i < 5; i++){
            for(int j=1; j < 5; j++){
            	int sum = 0;
            	sum += arr[i-1][j-1] + arr[i-1][j] + arr[i-1][j+1];
            	sum += arr[i][j];
            	sum += arr[i+1][j-1] + arr[i+1][j] + arr[i+1][j+1];
            	
                System.out.println(sum);
            }
            System.out.println();
        }
        System.out.println();
    }

}