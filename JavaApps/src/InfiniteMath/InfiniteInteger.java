package InfiniteMath;

public class InfiniteInteger {
	
	private String value;
	protected int lenght;
	
	public InfiniteInteger() {
		this.value = "0";
	}
	
	public InfiniteInteger(String value) {
		this.setValue(value);
	}
	
	public InfiniteInteger(int value) {
		this.setValue(value);
	}
	
	public InfiniteInteger(long value) {
		this.setValue(value);
	}
	
	public void setValue(String value) throws IllegalArgumentException {
		if(value.matches("^-?[0-9]+$")) {
			this.value = value;
		} else {
			throw new IllegalArgumentException("los valores deben ser solo numericos");
		}
	}
	
	public void setValue(int value) {
		this.value = String.valueOf(value);
	}
	
	public void setValue(long value) {
		this.value = String.valueOf(value);
	}
	
	public String getValue() {
		return this.value;
	}
	
	public int toInt() {
		return Integer.parseInt(this.value);
	}
	
	public void putZeros(int l) {
		String r = this.value;
		for(int i = 0; i < l - this.value.length(); i++) {
			r = "0" + r;
		}
		this.value = r;
	}
	
}


// private - red square - solo accesible desde la clase
// public - green circle
// protected - yellow diamond
// package - default - blue triangle

// static - S
// final - F
// abstract - A