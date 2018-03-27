package basic;

import java.math.BigInteger;
import java.util.Scanner;

public class BigIntegerCalc {

	public static void main(String[] args) {
		
		Scanner console = new Scanner(System.in);
		
		String a = console.nextLine();
		String b = console.nextLine();
		
		BigInteger A = new BigInteger(a);
		BigInteger B = new BigInteger(b);
		
		BigInteger RS = A.add(B);
		BigInteger RM = A.multiply(B);
		
		System.out.println(RS);
		System.out.println(RM);
		
		console.close();
		
	}

}
