package Memento;

public class OddGenerator implements IGenerator {

	private int value = 1;
	
	@Override
	public int generate() {
		int currentValue = this.value;
		this.value += 2; 
		return currentValue;
	}
	
}
