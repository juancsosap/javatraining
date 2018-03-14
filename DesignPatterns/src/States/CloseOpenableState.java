package States;

public class CloseOpenableState implements IOpenableState {

	@Override
	public void open(IOpenable element) {
		System.out.println("Opening the " + element.getName() + ".");
		element.setState(new OpenOpenableState()); 
	}

	@Override
	public void close(IOpenable element) {
		System.out.println("The " + element.getName() + " is already close.");
	}

}
