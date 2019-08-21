package test;

public class StaticTest {

	public static void main(String[] args) {
		System.out.println("Testing Program");
		
		new Person();
		
		System.out.println("Testing Program");
		
		System.out.println(Person.val);

		System.out.println("Testing Program");
	}
	
	static class Person {
		
		public static String val;
		
		static {
			val = "Hola";
			System.out.println("Calling Static Constructor");
		}
		
	}

}
