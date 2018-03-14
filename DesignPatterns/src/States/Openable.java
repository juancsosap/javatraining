package States;

public class Openable implements IOpenable {

	private String name;
	private IOpenableState state;
	
	public Openable(String name, IOpenableState initialState) { 
		this.name = name;
		this.state = initialState; 
	}
	
	public void open() { this.state.open(this); }
	public void close() { this.state.close(this); }
	public void setState(IOpenableState state) { this.state = state; }

	public String getName() { return this.name; }
	
}
