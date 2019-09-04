package P25_UnitTests;

public class App {
    
    public static void main(String[] args) {
        
    }
    
}

class Operator {
	
	public int add(int e1, int e2) {
		return e1 + e2;
	}
	
}

class Accumulator {
	
	protected int value;
	
	public Accumulator(int initial) {
		this.value = initial;
	}
	
	public int add(int value) {
		this.value += value;
		return this.value;
	}
	
}

class AccumulatorPlus extends Accumulator {
	
	public AccumulatorPlus(int initial) {
		super(initial);
	}

	public void set(int value) {
		this.value = value;
	}
	
	public int get() {
		return this.value;
	}
	
}

class OperatorPlus {
	
	public int add(int e1, int e2) throws ArithmeticException {
		int r = e1 + e2;
		if(e1 > 0 && e2 > 0 && r < 0 ) throw new ArithmeticException();
		if(e1 < 0 && e2 < 0 && r > 0 ) throw new ArithmeticException();
		return r;
	}
	
}

class OperatorUltra {
	
	public Integer add(Integer e1, Integer e2) throws ArithmeticException {
		if(e1 == null || e2 == null) return null;
		int r = e1 + e2;
		if(e1 > 0 && e2 > 0 && r < 0 ) throw new ArithmeticException();
		if(e1 < 0 && e2 < 0 && r > 0 ) throw new ArithmeticException();
		return r;
	}
	
}