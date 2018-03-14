package Decorator;

public abstract class PriviledgeDecorator extends AbstractUser {

	protected AbstractUser user;
	
	public PriviledgeDecorator(String username, String password) {
		super(username, password);
	}
	
}
