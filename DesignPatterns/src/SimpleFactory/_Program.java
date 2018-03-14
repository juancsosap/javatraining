package SimpleFactory;

public class _Program {

	public static void main(String[] args) {
		
		User[] users = new User[3];
		
		System.out.println("---- Creating Users from Factory ----");
		users[0] = UserFactory.make(UserType.Admin, "admin", "admin");
		users[1] = UserFactory.make(UserType.Regular, "user", "user");
		users[2] = UserFactory.make(UserType.Guest, "guest", "guest");
		System.out.println();
		
		for(User user : users){
			System.out.println("---- Testing " + user + " Privileges ----");
			user.administer();
			user.browse();
			user.visit();
			System.out.println();
		}
		
	}

}
