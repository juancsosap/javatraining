package P06_LoopBlocks;

import java.util.Scanner;

public class E06_InfiniteIntegerAdder {

    public static void main(String[] args) {
        
        try(Scanner scan = new Scanner(System.in)) {
            
            System.out.println("---- Infinite Adder ----");
            
            // Getting and Validating Numbers
            String num1S, num2S;
            
            do {
            	boolean valid = true;
                System.out.print("Number1 : ");
                num1S = scan.nextLine();
                for(char digit : num1S.toCharArray()) {
                    if(digit < '0' || digit > '9') {
                        valid = false;
                        break;
                    }
                }
                if(!valid) {
                    System.out.println("Invalid Number");
                    continue;
                }
                break;
            } while(true);
            
            do {
            	boolean valid = true;
                System.out.print("Number2 : ");
                num2S = scan.nextLine();
                for(char digit : num2S.toCharArray()) {
                    if(digit < '0' || digit > '9') {
                        valid = false;
                        break;
                    }
                }
                if(!valid) {
                    System.out.println("Invalid Number");
                    continue;
                }
                break;
            } while(true);
            
            StringBuilder num1 = new StringBuilder();
            num1.append(num1S);
            StringBuilder num2 = new StringBuilder();
            num2.append(num2S);
            
            // Appending Leading Zeros
            int num1L = num1S.length();
            int num2L = num2S.length();
            
            int largest = (num1L > num2L) ? num1L : num2L;
            
            for(int i=0; i<(largest - num1L); i++)
                num1.insert(0, "0");
            
            for(int i=0; i<(largest - num2L); i++)
                num2.insert(0, "0");

            System.out.println("----------------------------------------");

            System.out.println("Number1 :  " + num1);
            System.out.println("Number2 :  " + num2 + " +");
            
            System.out.println("----------------------------------------");

            // Adding Numbers
            StringBuilder result = new StringBuilder();
            int rest = 0;
            for(int i=(largest-1); i>=0; i--) {
                int num1D = Integer.parseInt(num1.charAt(i) + "");
                int num2D = Integer.parseInt(num2.charAt(i) + "");
                int resultD = (num1D + num2D + rest) % 10;
                rest = (num1D + num2D + rest) / 10;
                result.insert(0, resultD);
            }
            
            if(rest > 0) result.insert(0, rest);
            
            System.out.println("Result  : " + result.toString());
            
        }
        
    }
    
}