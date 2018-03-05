package Testing;

public class TestingAssert {

	public static void main(String args[]) {
		UnsignedInteger value = new UnsignedInteger(-4);
		value.print();
    }
	
}

class UnsignedInteger {

	private int value;
	
	public UnsignedInteger(int num) {
		setValue(num);		
    }
	
	private void setValue(int num) {
		if(num > 0)
			value = num;
		assert (value > 0) : "Value must be positive not (" + value + ")";
	}
	
	public void print() {
		System.out.println(value);
	}
    
}
