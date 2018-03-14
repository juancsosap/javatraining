package ChainResponsability;

public interface Chainnable {
	
	public void setNextChain(Chainnable nextChain);
	public void excecute(Numbers request);
	
}
