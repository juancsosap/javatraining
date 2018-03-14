package Memento;

public interface IOriginator {

	public IMemento createMemento();
	public void setMemento(IMemento memento);
	
	public IGenerator getValue();
	public void setValue(IGenerator value);
	
}
