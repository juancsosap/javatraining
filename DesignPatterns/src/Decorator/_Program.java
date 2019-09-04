package Decorator;

public class _Program {

	public static void main(String[] args) {
		
		AbstractUser user = new OpenPriviledgeDecorator(
				            new EditPriviledgeDecorator(
						    new ExecutePriviledgeDecorator(
							new User("admin", "admin"))));
		
		System.out.println(user.getUsername() + " have " + user.getPriviledge() + " Priviledges");
		
		if(user.getPriviledge().contains("Open"))
			((OpenPriviledgeDecorator) user).open();
		
		if(user.getPriviledge().contains("Edit"))
			((EditPriviledgeDecorator) user).edit();
		
		if(user.getPriviledge().contains("Execute"))
			((ExecutePriviledgeDecorator) user).execute();
		
	}

}
