package P10_Generics;

public class E06_Types {

	@SuppressWarnings({ "unused", "rawtypes" })
	public static void main(String[] args) {

		Printer<String> A;
		
		Printer<Integer> B;
		
		Printer<Person> C;
		
		Printer<Cloneable> D;
		
		Printer<Printable> E;
		
		Printer<Size> F;
		
		Printer<Object> G;
		
		Printer H; // Use Object as default
		
		// Printer<int> I; // Not valid
		
	}
	
	private abstract class Printer<T>{
		public abstract void print(T dato);
	}
	
	private class Person {}
	
	private interface Printable {}
	
	private enum Size { BIG, NORMAL, SMALL }

}
