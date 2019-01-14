package Generator;

public class SecuentialGenerator extends AbstractGenerator {

	public SecuentialGenerator() {
		super(0);
	}

	@Override
	public int generate() {
		return ++this.value;
	}

}
