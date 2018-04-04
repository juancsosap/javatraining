package basic;

import java.math.BigInteger;
import java.util.Scanner;

public class BigIntegerPrime {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
	    BigInteger n = in.nextBigInteger();
	    in.close();
	    String msg = n.isProbablePrime(1) ? "prime" : "not prime";
	    System.out.println(msg);
		
	}

}
