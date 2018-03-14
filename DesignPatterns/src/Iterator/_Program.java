package Iterator;

public class _Program {

	public static void main(String[] args) {
		
		GradeGenerator gGen = new GradeGenerator(0, 10);
		gGen.setIterator(IteratorType.SECUENTIAL);
		
		for(double value : gGen) {
			System.out.println(value);
		}
		
		RadianGenerator rGen = new RadianGenerator(0, Math.PI / 9);
		rGen.setIterator(IteratorType.SECUENTIAL);
		
		for(double value : rGen) {
			System.out.println(value);
		}
		
	}

}
