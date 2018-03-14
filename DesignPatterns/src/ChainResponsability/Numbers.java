package ChainResponsability;

public class Numbers {
	
	private int num1, num2;
	
	private Operation operation;
	
	public Numbers(int num1, int num2, Operation operation) {
		this.num1 = num1;
		this.num2 = num2;
		this.operation = operation;
	}

	public int getNum1() { return num1; }
	public int getNum2() { return num2; }
	
	public Operation getOperation() { return operation; }

}
