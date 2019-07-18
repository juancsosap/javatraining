package P10_Generics;

public class E02_GenericDoubleBox {

	public static void main(String[] args) {
		
		Box<String, String> box1 = new Box<>("Name", "Juan");
		
		System.out.println(box1.getKey() + " : " + box1.getValue());
		
		Box<Integer, String> box2 = new Box<>(1, "Carrots");
		
		System.out.println(box2.getKey() + " : " + box2.getValue());
		
		class Person {
			public String name;
		}
		
		Box<String, Person> box3 = new Box<>("President", new Person());
		
		box3.getValue().name = "Juan";
		
		System.out.println(box3.getKey() + " : " + box3.getValue().name);
		
	}
	
	private static class Box<T1,T2> {
		
		private T1 key;
		private T2 value;
		
		public Box(T1 key, T2 value) {
			this.key = key;
			this.value = value;
		}
		
		public T1 getKey() {
			return this.key;
		}

		public T2 getValue() {
			return this.value;
		}

	}

}
