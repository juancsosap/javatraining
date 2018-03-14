package AbstractFactory;

public class UserBuilder {

	public static User make(UserType type, String username, String password) {
		
		User user = null;
		switch(type) {
			case Admin: user = new AdminUser(new AdminUserFactory(), username, password);
			case Regular: user = new RegularUser(new RegularUserFactory(), username, password);
			case Guest: user = new GuestUser(new GuestUserFactory(), username, password);
		}
		
		user.make();
		
		return user;
	}
	
}
