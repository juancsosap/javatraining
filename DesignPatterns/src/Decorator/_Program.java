package Decorator;

public class _Program {

	public static void main(String[] args) {
		
		AbstractUser user = new OpenPriviledgeDecorator(
				            new EditPriviledgeDecorator(
						    new ExecutePriviledgeDecorator(
							new User("admin", "admin"))));
		
		System.out.println(user.getUsername() + " have " + user.getPriviledge() + " Priviledges");
		
		if(user.getPriviledge().contains("Open"))
			(new OpenPriviledgeDecorator(user)).open();
		
		if(user.getPriviledge().contains("Edit"))
			(new EditPriviledgeDecorator(user)).edit();
		
		if(user.getPriviledge().contains("Execute"))
			(new ExecutePriviledgeDecorator(user)).execute();
		
	}

}
