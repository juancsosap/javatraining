package States;

public class _Program {

	public static void main(String[] args) {
		
		IOpenable door = new Openable("Door", new CloseOpenableState());
		door.open();
		door.open();
		door.close();
		door.close();
		
		System.out.println();
		
		IOpenable window = new Openable("Window", new OpenOpenableState());
		window.close();
		window.close();
		window.open();
		window.open();
		
	}

}
