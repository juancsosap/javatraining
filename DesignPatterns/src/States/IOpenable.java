package States;

public interface IOpenable {

	public void open();
	public void close();
	
	public String getName();
	
	public void setState(IOpenableState state);

}
