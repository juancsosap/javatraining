package Decorator;

public class OpenPriviledgeDecorator extends PriviledgeDecorator {

	public OpenPriviledgeDecorator(AbstractUser user) {
		super(user.getUsername(), user.getPassword());
		this.user = user;
	}

	public void open() {
		System.out.println(getUsername() + " is Opening");
	}

	@Override
	public String getPriviledge() {
		return user.getPriviledge() + ":Open";
	}

}
