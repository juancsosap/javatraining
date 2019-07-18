package Memento;

public class FibonacciGenerator implements IGenerator {

	private int value1 = 0;
	private int value2 = 1;
	
	private boolean first = true;
	
	@Override
	public int generate() {
		int currentValue;
		if(this.first) {
			currentValue = this.value1;
			this.first = false;
		}
		else {
			currentValue = this.value2;
			
			int newValue = this.value1 + this.value2;
			this.value1 = this.value2;
			this.value2 = newValue;
		}
		return currentValue;
	}
	
}
