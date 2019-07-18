package P26_Reflexion;

import java.util.ArrayList;

public class E01_ClassName {

	public static void main(String[] args) {
		
		Printable printer;
		Class<?> printerClass;
		
		printer = new Hello();
		printer.print();
		printerClass = printer.getClass();
		System.out.println(printerClass.getName());		
		
		System.out.println();
		
		printer = new Bye();
		printer.print();
		printerClass = printer.getClass();
		System.out.println(printerClass.getName());
		
		System.out.println();
		
		System.out.println(ArrayList.class.getName());
		
	}
	
	public static class Bye implements Printable {

		@Override
		public void print() {
			System.out.println("Bye");
		}
		
	}

}

interface Printable {
	
	public void print();
	
}

class Hello implements Printable {

	@Override
	public void print() {
		System.out.println("Hello");
	}
	
}
