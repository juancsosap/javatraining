package Generator;

public abstract class BiGenerator extends AbstractGenerator {

	public BiGenerator(int seed) {
		super(seed);
	}
	
	@Override
	public int generate() {
		this.value += 2;
		return this.value;
	}
	
}
