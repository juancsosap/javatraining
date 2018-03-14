package Memento;

public class Memento implements IMemento {

	private IGenerator value;
	
	public Memento(IGenerator value) {
		this.value = value;
	}
	
	public IGenerator getValue() { 
		return this.value;
	}
	
	public void setValue(IGenerator value) { 
		this.value = value; 
	}

}
