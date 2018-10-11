package P11_Interfaces;

import java.util.Scanner;
import java.util.function.Consumer;

public class E07_Consumer {

	public static void main(String[] args) {
		
		try(Scanner console = new Scanner(System.in)) {
			
			String text = console.nextLine();
			
			Consumer<String> printer;
			
			printer = new CapitalizePrinter();
			printer.accept(text);
			
			printer = LowerCasePrinter;
			printer.accept(text);
			
			printer = EnterPrinter;
			printer.accept(text);
			
			printer = UpperCasePrinter;
			printer.accept(text);
			
		}
		
	}
	
	private static class CapitalizePrinter implements Consumer<String> {

		@Override
		public void accept(String text) {
			System.out.print(text.substring(0,1).toUpperCase());
			System.out.println(text.substring(1));
		}
		
	}
	
	private static Consumer<String> LowerCasePrinter = new Consumer<String>() {

		@Override
		public void accept(String text) {
			System.out.println(text.toLowerCase());
		}
		
	};

	private static final Consumer<String> UpperCasePrinter  = t -> System.out.println(t.toUpperCase());
	
	private static final Consumer<String> EnterPrinter  = __ -> System.out.println();

}
