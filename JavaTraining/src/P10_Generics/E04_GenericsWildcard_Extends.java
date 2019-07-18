package P10_Generics;

public class E04_GenericsWildcard_Extends {

	public static void main(String[] args) {
		
		for(int i=0; i<4; i++) {
			Printer.print(new Box<SuperClass>(new SuperClass()));
			Printer.print(new Box<SubClass>(new SubClass()));
		}
		
	}
	
	private static class Box<T> {
		
		private T value;
		
		public Box(T value) {
			this.value = value;
		}
		
		public T get() {
			return this.value;
		}
		
	}
	
	private static class SuperClass {
		
		private static int last_id = 0;
		protected int id;
		
		public SuperClass() {
			this.id = last_id++;
		}
		
		@Override
		public String toString() {
			return "SuperClass " + this.id;
		}

	}
	
	private static class SubClass extends SuperClass {

		@Override
		public String toString() {
			return "SubClass " + this.id;
		}
	
	}
	
	private static class Printer {
		
		public static void print(Box<? extends SuperClass> box) {
			SuperClass item = box.get();
			System.out.println(item);
		}
		
	}

}
