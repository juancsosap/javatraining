package InfiniteMath;

public class Main {

	public static void main(String[] args) {
		PositiveNotNullInfiniteInteger pepe = new PositiveNotNullInfiniteInteger();
		
		InfiniteInteger[] a = new InfiniteInteger[5];
		a[0] = new InfiniteInteger();
		a[1] = new PositiveInfiniteInteger();
		a[2] = new PositiveNotNullInfiniteInteger();
		a[3] = new InfiniteInteger();
		a[4] = new InfiniteInteger();
				
		a[0].setValue("123");
		System.out.println(a[0].getValue());
		a[0].putZeros(10);
		System.out.println(a[0].getValue());
		
		((PositiveNotNullInfiniteInteger) a[2]).message();
		
		System.out.println(pepe.getValue());
		try {
			pepe.setValue(123453445676L);
			System.out.println(pepe.getValue());
		} catch(Exception e) {
			System.out.println("valor ingresado no valido : " + 
					e.getMessage());
		}

		String str = "123456";
		
		System.out.println(str.concat("1").concat("1").concat("1").concat("1").concat("1"));
	}

}
