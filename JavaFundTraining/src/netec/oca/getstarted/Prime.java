package netec.oca.getstarted;

import java.util.Scanner;

public class Prime {

	public static void main(String[] args) {

		try(Scanner console =  new Scanner(System.in)){
			
			System.out.println("Prime Verification");
			
			System.out.print("Number: ");
			int num = console.nextInt();
			
			System.out.println(isPrime(num) ? "It's Prime" : "It isn't Prime");
			
			getPrimes(num);
			
		}
		
	}
	
	public static boolean isPrime(int num) {
		
		if(num <= 1) return false;
		
		for(int i=2; i<num; i++)
			if(num % i == 0) return false;
		
		return true;
	}
	
	public static void getPrimes(int num) {
		
		if(num <= 1) return;
		
		for(int i=2; i<=num; i++)
			if(isPrime(i))
				System.out.println(i + " ");	
		
	}

}
