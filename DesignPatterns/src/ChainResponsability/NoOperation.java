package ChainResponsability;

public class NoOperation implements Chainnable {
	
	@Override
	public void setNextChain(Chainnable nextChain) {}

	@Override
	public void excecute(Numbers request) {
		System.out.println("No operation was excecuted");
	}
	
}
