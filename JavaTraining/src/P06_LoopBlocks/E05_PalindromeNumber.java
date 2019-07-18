package P06_LoopBlocks;

import java.util.Scanner;

public class E05_PalindromeNumber {

	public static void main(String[] args) {
		
		try(Scanner scan = new Scanner(System.in)) {
			
			System.out.println("Palindrome Number Verification");
			
			boolean valid;
			String strNum;
			
			do {
				
				System.out.print("Number: ");
				strNum = scan.nextLine();
				
				if(strNum.length()<10) {
					valid = true;
					for(int i=0; i<strNum.length(); i++) {
						char c = strNum.charAt(i);
						if(c >= '0' && c <= '9') continue;
						valid = false;
						System.out.println("Is not a Number!!!!");
						break;
					}
				} else {
					System.out.println("Number to long!!!!");
					valid = false;
				}
				
			} while (!valid);
			
			int num = Integer.parseInt(strNum);
			
			double tmpNum = num;
			
			int revNum = 0;
			
			while(tmpNum > 0) {
				revNum *= 10;
				tmpNum /= 10;
				revNum += Math.round((tmpNum - (int) tmpNum) * 10);
				tmpNum = (int) tmpNum;
			}
			
			System.out.println(revNum == num ? "Palindrome" : "Not Palindrome");
			
		}
		
	}

}
