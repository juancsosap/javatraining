package Memento;

public class Originator implements IOriginator {
	
	private IGenerator value;

	public IGenerator getValue() { return value; }
	public void setValue(IGenerator value) { this.value = value; }
	
	public IMemento createMemento() {
		return new Memento(this.value);
	}
	
	public void setMemento(IMemento memento) {
		this.value = memento.getValue();
	}

}
