package P11_Interfaces;

import java.util.Scanner;
import java.util.function.Predicate;

public class E06_Predicate {

	public static void main(String[] args) {
		
		try(Scanner console = new Scanner(System.in)) {
			
			String text = console.nextLine();
			
			Predicate<String> validator;
			
			validator = new UpperCaseLetterValidator();
			if(validator.test(text))
				System.out.println("UpperCase Letter Text");
			
			validator = LowerCaseLetterValidator;
			if(validator.test(text))
				System.out.println("LowerCase Letter Text");
			
			validator = NumberValidator;
			if(validator.test(text))
				System.out.println("Number Text");
			
		}
		
	}
	
	private static class UpperCaseLetterValidator implements Predicate<String> {

		@Override
		public boolean test(String text) {
			return text.matches("^[A-Z]+$") ? true : false;
		}
		
	}
	
	private static final Predicate<String> LowerCaseLetterValidator  = new Predicate<String>() {

		@Override
		public boolean test(String text) {
			return text.matches("^[a-z]+$") ? true : false;
		}
		
	};

	private static final Predicate<String> NumberValidator  = t -> t.matches("^[0-9]+$");
	
}
