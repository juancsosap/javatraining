package test;

public class EnumTest {

	public static void main(String[] args) {
		System.out.println("Testing Program");
		
		System.out.println(Gender.MALE);
		
		System.out.println("Testing Program");
		
		System.out.println(Gender.FEMALE);
		
		System.out.println("Testing Program");
		
		System.out.println(Gender.MALE);
		
		System.out.println("Testing Program");
		
		System.out.println(Gender.LGBTI);
		
		System.out.println("Testing Program");
		
	}
	
	static enum Gender {
		MALE("hombre"), FEMALE("mujer"), LGBTI("no se");
		
		public String name;
		
		private Gender(String name) {
			System.out.println("Creating" + this);
			this.name = name;
		}
		
		public String toString() {
			return this.name;
		}
	}

}
