package P09_Classes;

public class E13_OverridingOverload {

	public static void main(String[] args) {
		Box box1 = new Box(5);
		System.out.println(box1.get());
		System.out.println(box1.getStr());
		
		System.out.println();
		
		Box box2 = new TenBox(5);
		System.out.println(box2.get());
		System.out.println(box2.getStr());
		// System.out.println(box2.get(3)); // Not accesible
		
		System.out.println();
		
		TenBox box3 = new TenBox(5);
		System.out.println(box3.get());
		System.out.println(box3.getStr());
		System.out.println(box3.get(3));
	}
	
	private static class Box {
		
		private int value;
		
		public Box(int v) {
			this.value = v;
		}
		
		public int get() {
			return this.value;
		}
		
		public String getStr() {
			return get() + " str";
		}
		
	}
	
	private static class TenBox extends Box {
		
		public TenBox(int v) {
			super(v);
		}
		
		@Override
		public int get() {
			return super.get() * 10;
		}

		public int get(int m) {
			return super.get() * m * 10;
		}
		
	}

}


