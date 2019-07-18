package InfiniteMath;

public class PositiveInfiniteInteger extends InfiniteInteger {
	
	public PositiveInfiniteInteger() {
		super();
	}
	
	public PositiveInfiniteInteger(String value) {
		this.setValue(value);
	}

	public void setValue(String value) throws IllegalArgumentException {
		if(value.matches("^[0-9]+$")) {
			super.setValue(value);
		} else {
			throw new IllegalArgumentException("los valores deben ser solo numericos y positivos");
		}
	}
	
	public void setValue(int value) throws IllegalArgumentException {
		if(value >= 0) {
			super.setValue(value);
		} else {
			throw new IllegalArgumentException("los valores no pueden ser negativos");
		}
	}
	
}
