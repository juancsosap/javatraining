package States;

public class OpenOpenableState implements IOpenableState {

	@Override
	public void open(IOpenable element) {
		System.out.println("The " + element.getName() + " is already open."); 
	}

	@Override
	public void close(IOpenable element) {
		System.out.println("Closing the " + element.getName() + ".");
		element.setState(new CloseOpenableState());
	}

}
