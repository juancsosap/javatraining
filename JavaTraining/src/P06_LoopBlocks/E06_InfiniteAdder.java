package P06_LoopBlocks;

import java.util.Scanner;

public class E06_InfiniteAdder {

    public static void main(String[] args) {
        
        try(Scanner scan = new Scanner(System.in)) {
            
            System.out.println("---- Infinite Adder ----");
            
            // Getting and Validating Numbers
            boolean valid;
            String num1, num2;
            
            do {
            	valid = true;
                System.out.print("Number1 : ");
                num1 = scan.nextLine();
                for(char digit : num1.toCharArray()) {
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
            	valid = true;
                System.out.print("Number2 : ");
                num2 = scan.nextLine();
                for(char digit : num2.toCharArray()) {
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
            
            // Appending Leading Zeros
            int len1 = num1.length();
            int len2 = num2.length();
            int maxLen = (len1 > len2) ? len1 : len2;
            
            int zerosLen = Math.abs(len1 - len2);
            String zeros = "";
            for(int i=0; i<zerosLen; i++) { zeros += "0"; }
            
            if(len1 < maxLen) num1 = zeros + num1; 
            else num2 = zeros + num2;

            System.out.println("------------------------");

            // Adding Numbers
            int rest = 0;
            String result = "";
            for(int i=maxLen; i>0; i--) {
            	int digit1 = Integer.parseInt(num1.charAt(i-1) + "");
            	int digit2 = Integer.parseInt(num2.charAt(i-1) + "");
            	int digit = (digit1 + digit2 + rest) % 10;
            	rest = (digit1 + digit2 + rest) / 10;
                result = digit + result; 
            }
            if(rest > 0) result = rest + result;
            
            System.out.println("Result  : " + result);
        }
        
    }
    
}