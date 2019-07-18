package P14_DesignPatterns;

public class E01_Singleton {

	public static void main(String[] args) {
		
		Box caja0 = Box.getInstance();
		System.out.println(caja0);
		System.out.println(caja0.getValue());
		System.out.println();
		
		Box caja1 = Box.getInstance();
		System.out.println(caja1);
		caja1.setValue("SOMETHING");
		System.out.println(caja1.getValue());
		System.out.println();
		
		Box caja2 = Box.getInstance();
		System.out.println(caja2);
		caja2.setValue("SOMETHING ELSE");
		System.out.println(caja2.getValue());
		System.out.println();
		
	}
	
	private static class Box {
		
		private Object value;
		
		private static Box instance = null;
		
		private Box() {
			this.value = null;
		}
		
		public static Box getInstance() {
			if(instance == null)
				instance = new Box();
			return instance;
		}

		public Object getValue() {
			return value;
		}

		public void setValue(Object value) {
			this.value = value;
		}
		
	}

}
