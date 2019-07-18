package P07_Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class E05_ArraysAdder {

    public static void main(String[] args) {
        
        try(Scanner scan = new Scanner(System.in)) {
        	
            System.out.println("Vector Adder");
        
            System.out.print("Size: ");
            int size = scan.nextInt();
            
            int[] vector1 = new int[size];
            int[] vector2 = new int[size];
            
            System.out.println("Vector #1");
            for(int i=0; i<size; i++) {
                System.out.print("Value #" + (i+1) + ": ");
                vector1[i] = scan.nextInt();
            }

            System.out.println("Vector #2");
            for(int i=0; i<size; i++) {
                System.out.print("Value #" + (i+1) + ": ");
                vector2[i] = scan.nextInt();
            }
            
            int[] result = new int[size];
            
            for(int i=0; i<size; i++) {
                result[i] = vector1[i] + vector2[i];
            }
            
            System.out.println("Vector #1 : " + Arrays.toString(vector1));
            System.out.println("Vector #2 : " + Arrays.toString(vector2));
            System.out.println("Result    : " + Arrays.toString(result));
            
        }
        
    }
    
}