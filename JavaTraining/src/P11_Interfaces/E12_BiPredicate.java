package P11_Interfaces;

import java.util.Scanner;
import java.util.function.BiPredicate;

public class E12_BiPredicate {

	public static void main(String[] args) {
		
		try(Scanner console = new Scanner(System.in)) {
			
			System.out.print("Initial Age: ");
			int initial_age = Integer.parseInt(console.nextLine());
			
			System.out.print("Final Age: ");
			int final_age = Integer.parseInt(console.nextLine());
			
			if(Inside.test(initial_age, final_age))
				System.out.println("Valid Ages Range");
			
			if(Outside.test(initial_age, final_age))
				System.out.println("Invalid Ages Range");
			
		}
		
	}
	
	private static final BiPredicate<Integer, Integer> Inside  = (i1, i2) -> (i1 > 0 && i1 < 120) && (i2 > 0 && i2 < 120);
	private static final BiPredicate<Integer, Integer> Outside  = (i1, i2) -> !((i1 > 0 && i1 < 120) && (i2 > 0 && i2 < 120));
	
}
