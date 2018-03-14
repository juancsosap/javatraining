package Memento;

public class _Program {

	public static void main(String[] args) {
		
		IGenerator evenGenerator = new EvenGenerator();
		
		IOriginator originator = new Originator();
		originator.setValue(evenGenerator);
		
		ICaretaker caretaker = new Caretaker();
		caretaker.addMemento(originator.createMemento());
		
		for(int i = 0; i < 10; i++)
			System.out.println(originator.getValue().generate());
		
		System.out.println();
		
		IGenerator oddGenerator = new OddGenerator();
		
		originator.setValue(oddGenerator);
		caretaker.addMemento(originator.createMemento());
		
		for(int i = 0; i < 10; i++)
			System.out.println(originator.getValue().generate());
		
		System.out.println();
		
		originator.setMemento(caretaker.getMemento(0));
		
		for(int i = 0; i < 10; i++)
			System.out.println(originator.getValue().generate());
		
		System.out.println();
		
		IGenerator fibonacciGenerator = new FibonacciGenerator();
		
		originator.setValue(fibonacciGenerator);
		caretaker.addMemento(originator.createMemento());
		
		for(int i = 0; i < 10; i++)
			System.out.println(originator.getValue().generate());
		
		originator.setMemento(caretaker.getMemento(1));
		
		System.out.println();
		
		for(int i = 0; i < 10; i++)
			System.out.println(originator.getValue().generate());
		
	}

}
