package Decorator;

public class ExecutePriviledgeDecorator extends PriviledgeDecorator {

	public ExecutePriviledgeDecorator(AbstractUser user) {
		super(user.getUsername(), user.getPassword());
		this.user = user;
	}

	public void execute() {
		System.out.println(getUsername() + " is Executing");
	}

	@Override
	public String getPriviledge() {
		return user.getPriviledge() + ":Execute";
	}

}
