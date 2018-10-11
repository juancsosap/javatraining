package P10_Generics;

public class E01_GenericBox {

	public static void main(String[] args) {
		
		Box<String> box1 = new Box<>("TEXT");
		
		System.out.println(box1.get());
		
		Box<Integer> box2 = new Box<>(5);
		
		System.out.println(box2.get());
		
		class Person {
			public String name;
		}
		
		Box<Person> box3 = new Box<>(new Person());
		
		box3.get().name = "Juan";
		
		System.out.println(box3.get().name);
		
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

}
