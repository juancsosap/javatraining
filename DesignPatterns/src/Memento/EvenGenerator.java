package Memento;

public class EvenGenerator implements IGenerator {

	private int value = 0;
	
	@Override
	public int generate() {
		int currentValue = this.value;
		this.value += 2; 
		return currentValue;
	}
	
}
