package InfiniteMath;

public class PositiveNotNullInfiniteInteger extends PositiveInfiniteInteger {

	public void setValue(String value) throws IllegalArgumentException {
		if(value.matches("^[0]*[1-9][0-9]*$")) {
			super.setValue(value);
		} else {
			throw new IllegalArgumentException("los valores deben ser solo numericos, positivos y no nulos");
		}
	}
	
	public void message() {
		System.out.println("This is a Not Null Positive Infinite Integer");
	}
	
}
