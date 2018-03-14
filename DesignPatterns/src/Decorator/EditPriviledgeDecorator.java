package Decorator;

public class EditPriviledgeDecorator extends PriviledgeDecorator {

	public EditPriviledgeDecorator(AbstractUser user) {
		super(user.getUsername(), user.getPassword());
		this.user = user;
	}

	public void edit() {
		System.out.println(getUsername() + " is Editing");
	}

	@Override
	public String getPriviledge() {
		return user.getPriviledge() + ":Edit";
	}

}
