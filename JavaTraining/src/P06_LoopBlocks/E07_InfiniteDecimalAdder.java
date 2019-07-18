package P06_LoopBlocks;

import java.util.Scanner;

public class E07_InfiniteDecimalAdder {

    public static void main(String[] args) {
        
        try(Scanner scan = new Scanner(System.in)) {
            
            System.out.println("---- Infinite Adder ----");
            
            // Getting and Validating Numbers
            String num1S, num2S;
            
            do {
            	boolean valid = true;
            	boolean hasDot = false;
                System.out.print("Number1 : ");
                num1S = scan.nextLine();
                for(char digit : num1S.toCharArray()) {
                	if(digit == '.' && !hasDot) {
                		hasDot = true;
                		continue;
                	}
                    if(digit < '0' || digit > '9') {
                        valid = false;
                        break;
                    }
                }
                if(!valid) {
                    System.out.println("Invalid Number");
                    continue;
                }
                if(!hasDot) num1S += ".0";
                break;
            } while(true);
            
            
            do {
            	boolean valid = true;
            	boolean hasDot = false;
                System.out.print("Number2 : ");
                num2S = scan.nextLine();
                for(char digit : num2S.toCharArray()) {
                	if(digit == '.' && !hasDot) {
                		hasDot = true;
                		continue;
                	}
                    if(digit < '0' || digit > '9') {
                        valid = false;
                        break;
                    }
                }
                if(!valid) {
                    System.out.println("Invalid Number");
                    continue;
                }
                if(!hasDot) num2S += ".0";
                break;
        	} while(true);
            
            // Splitting numbers
            String num1IS = num1S.split("[.]")[0];
            String num1FS = num1S.split("[.]")[1];
            String num2IS = num2S.split("[.]")[0];
            String num2FS = num2S.split("[.]")[1];
            
            // Appending Leading Zeros
            int num1IL = num1IS.length();
            int num2IL = num2IS.length();
            int num1FL = num1FS.length();
            int num2FL = num2FS.length();
            
            int numIL = (num1IL > num2IL) ? num1IL : num2IL;
            int numFL = (num1FL > num2FL) ? num1FL : num2FL;
            int numL = numIL + numFL;
            
            StringBuilder num1 = new StringBuilder();
            StringBuilder num2 = new StringBuilder();
            
            num1.append(num1S);
            num2.append(num2S);
            
            for(int i=0; i<(numIL - num1IL); i++) num1.insert(0, "0");
            for(int i=0; i<(numIL - num2IL); i++) num2.insert(0, "0");
            for(int i=0; i<(numFL - num1FL); i++) num1.append("0");
            for(int i=0; i<(numFL - num2FL); i++) num2.append("0");
            
            System.out.println("----------------------------------------");

            System.out.println("Number1 :  " + num1);
            System.out.println("Number2 :  " + num2 + " +");
            
            System.out.println("----------------------------------------");

            // Adding Numbers
            num1.deleteCharAt(numIL);
            num2.deleteCharAt(numIL);
            
            StringBuilder result = new StringBuilder();
            int rest = 0;
            for(int i=(numL-1); i>=0; i--) {
                int num1D = Integer.parseInt(num1.charAt(i) + "");
                int num2D = Integer.parseInt(num2.charAt(i) + "");
                int resultD = (num1D + num2D + rest) % 10;
                rest = (num1D + num2D + rest) / 10;
                result.insert(0, resultD);
            }
            
            result.insert(numIL, ".");
            if(rest > 0) result.insert(0, rest);
            
            System.out.println("Result  : " + result.toString());
            
        }
        
    }
    
}