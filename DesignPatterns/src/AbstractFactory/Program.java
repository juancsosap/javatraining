package AbstractFactory;

public class Program {

	public static void main(String[] args) {
		
		User[] users = new User[3];
		
		System.out.println("---- Creating Users from Factory ----");
		users[0] = UserBuilder.make(UserType.Admin, "admin", "admin");
		users[1] = UserBuilder.make(UserType.Regular, "user", "user");
		users[2] = UserBuilder.make(UserType.Guest, "guest", "guest");
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
