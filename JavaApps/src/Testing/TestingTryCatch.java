package Testing;

public class TestingTryCatch implements AutoCloseable {

	public static void main(String[] args) {
		try(TestingTryCatch test = new TestingTryCatch()) {
			System.out.println("Opened....");
		} catch(Exception e) {
			System.out.println("Failing....");
		}
	}

	public TestingTryCatch() throws Exception {
		System.out.println("Opening....");
		throw new Exception();
	}
	
	@Override
	public void close() throws Exception {
		System.out.println("Closing....");
	}
	
}
