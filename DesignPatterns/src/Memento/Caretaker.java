package Memento;

import java.util.ArrayList;
import java.util.List;

public class Caretaker implements ICaretaker {

	private List<IMemento> valueList =new ArrayList<>();
	
	@Override
	public void addMemento(IMemento memento) {
		this.valueList.add(memento);
	}

	@Override
	public IMemento getMemento(int index) {
		return this.valueList.get(index);
	}

}
