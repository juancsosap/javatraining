package P09_Classes;

public class E08_Static {

	public static void main(String[] args) {
		System.out.println("Starting Program");
		
		Test t1;
		
		System.out.println(Test.i2);
		
		System.out.println("Waiting");
		
		t1 = new Test();
		System.out.println(t1.i1);
		System.out.println(t1.i2);
		
		System.out.println("Ending Program");
	}

}

class Test {
	
	public final double i1;
	
	public final static int i2;
	
	Test() {
		i1 = Math.random();
		System.out.println("Calling Test()");
	}
	
	static {
		i2 = 20;
		System.out.println("Calling Static Constructor");
	}
	
}
