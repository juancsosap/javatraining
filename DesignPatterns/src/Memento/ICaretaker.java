package Memento;

public interface ICaretaker {

	public void addMemento(IMemento memento);
	public IMemento getMemento(int index);
	
}
