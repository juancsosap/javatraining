package Decorator;

public class User extends AbstractUser {

	public User(String username, String password) {
		super(username, password);
		System.out.println(this.getUsername() + " Created");
	}

	@Override
	public String getPriviledge() {
		return "";
	}
	
}
