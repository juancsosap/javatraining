package test;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Functional {

	public static void main(String[] args) {
		Printable p1 = new Printer();
		System.out.println(p1.getClass().getName());
		p1.print("P1");
		
		Printable p2 = new Printable() {

			@Override
			public void print(String msg) {
				System.out.println("Printable" + msg);
			}
			
		};
		System.out.println(p2.getClass().getName());
		p2.print("P2");
		
		Printable p3 = (m) -> System.out.println("Lambda" + m);
		System.out.println(p3.getClass().getName());
		p3.print("P3");
		
		Predicate<String> p = (s) -> s.length() > 5;
		p.test("Juan Carlos");
		
		Supplier<String> s = () -> { 
			return "Info";
		};
		s.get();
		
		Consumer<String> c = (String t) -> System.out.println(t);
		c.accept("Hola");
		
		Function<String, Integer> f = ns -> ns.length();
		f.apply("hola");
	}
	
	static interface Printable {
		public void print(String msg);
	}
	
	static class Printer implements Printable {

		@Override
		public void print(String msg) {
			System.out.println("Printer" + msg);
		}
		
	}

}
