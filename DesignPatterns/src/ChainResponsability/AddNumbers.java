package ChainResponsability;

public class AddNumbers implements Chainnable {
	
	private Chainnable next;

	@Override
	public void setNextChain(Chainnable nextChain) {
		this.next = nextChain;
	}

	@Override
	public void excecute(Numbers request) {
		if(request.getOperation().equals(Operation.ADD))
			System.out.printf("%,d + %,d = %,d%n", request.getNum1(), request.getNum2(),
					request.getNum1() + request.getNum2());
		else
			next.excecute(request);
	}
	
}
