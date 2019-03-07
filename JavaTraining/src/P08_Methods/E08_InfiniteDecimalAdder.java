package P08_Methods;

import java.util.Scanner;

public class E08_InfiniteDecimalAdder {

	private static String isDecimal(String num) {
		boolean hasDot = false;
        for(char digit : num.toCharArray()) {
        	if(digit == '.' && !hasDot) {
        		hasDot = true;
        		continue;
        	}
            if(digit < '0' || digit > '9') {
                return null;
            }
        }
        if(!hasDot) num += ".0";
        return num;
	}
	
	public static StringBuilder getDecimal(String msg, Scanner scan) {
		StringBuilder num = new StringBuilder();
		String numS;
		do {
        	System.out.print(msg);
            numS = scan.nextLine();
            numS = isDecimal(numS);
            if(numS != null) break;
            System.out.println("Invalid Number");
        } while(true);
        num.append(numS);
        return num;
	}
	
	private static int addZeros(StringBuilder ... nums) {
		// number length
		int lenI = 0;
		int lenD = 0;
		for(StringBuilder num : nums) {
			int numDot = num.indexOf(".");
			lenI = (numDot > lenI) ? numDot : lenI;
			int decimalSize = num.length() - numDot - 1;
			lenD = (decimalSize > lenD) ? decimalSize : lenD;
		}
        
		// Appending Zeros
		for(StringBuilder num : nums) {
			int numDot = num.indexOf(".");
			for(int i=0; i<(lenI - numDot); i++) num.insert(0, "0");
			int decimalSize = num.length() - numDot - 1;
			for(int i=0; i<(lenD - decimalSize); i++) num.append("0");
		}
		
		return lenD;
	}
	
	private static StringBuilder addNumbers(StringBuilder ... nums) {
        StringBuilder result = new StringBuilder();
        int rest = 0;
        if(nums.length > 0) {
        	for(int i=(nums[0].length()-1); i>=0; i--) {
        		int resultNum = rest;
        		for(StringBuilder num : nums) {
        			resultNum += Integer.parseInt(num.charAt(i) + "");
        		}
        		int resultD = resultNum % 10;
                rest = resultNum / 10;
                result.insert(0, resultD);
            }
            result.insert(0, (rest > 0) ? rest : " ");
            return result;
        }
        return null;
	}
	
    public static void main(String[] args) {
        
        try(Scanner scan = new Scanner(System.in)) {
            
            System.out.println("---- Infinite Adder ----");
            
            // Getting and Validating Numbers
            StringBuilder num1 = getDecimal("Number1 : ", scan);
            StringBuilder num2 = getDecimal("Number2 : ", scan);
            
            int decimals = addZeros(num1, num2);            
            int len = num1.length();
            
            System.out.println("----------------------------------------");

            System.out.println("Number1 :  " + num1);
            System.out.println("Number2 :  " + num2 + " +");
            
            System.out.println("----------------------------------------");
            
            // Removing Dots
            num1.deleteCharAt(len - decimals - 1);
            num2.deleteCharAt(len - decimals - 1);
    		
            // Adding Numbers
            StringBuilder result = addNumbers(num1, num2);
            
            // Including Dot
            result.insert(result.length() - decimals, ".");
            
            System.out.println("Result  : " + result.toString());
            
        }
        
    }
    
}