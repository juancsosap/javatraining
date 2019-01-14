package Generator;

public abstract class AbstractGenerator {

	protected int value;
	
	public AbstractGenerator(int seed) {
		this.value = seed;
	}
	
	public abstract int generate();
	
}
