package SimpleFactory;

public class UserFactory {
	
	public static User make(UserType type, String username, String password) {
		switch(type) {
			case Admin: return new AdminUser(username, password);
			case Regular: return new RegularUser(username, password);
			case Guest: return new GuestUser(username, password);
			default: return null;
		}
	}

}
