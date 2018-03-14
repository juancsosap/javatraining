package ChainResponsability;

public class _Program {
	
	public static void main(String[] args) {
		
		Chainnable addCalc = new AddNumbers();
		Chainnable subCalc = new SubNumbers();
		Chainnable mulCalc = new MulNumbers();
		Chainnable divCalc = new DivNumbers();
		Chainnable notCalc = new NoOperation();
		
		addCalc.setNextChain(subCalc);
		subCalc.setNextChain(mulCalc);
		mulCalc.setNextChain(divCalc);
		divCalc.setNextChain(notCalc);
		
		Chainnable calc = addCalc;
		
		Numbers request;
		
		request = new Numbers(4, 4, Operation.ADD);
		calc.excecute(request);
		
		request = new Numbers(4, 4, Operation.SUB);
		calc.excecute(request);
		
		request = new Numbers(4, 4, Operation.MUL);
		calc.excecute(request);
		
		request = new Numbers(4, 4, Operation.DIV);
		calc.excecute(request);
		
		request = new Numbers(4, 4, Operation.NOP);
		calc.excecute(request);
		
	}

}
