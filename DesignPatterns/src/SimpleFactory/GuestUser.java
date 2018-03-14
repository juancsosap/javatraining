package SimpleFactory;

public class GuestUser extends User {

	public GuestUser(String username, String password) {
		super(username, password);
	}

	@Override
	public String toString() {
		return getUsername() + "(Guest)";
	}
	
	@Override
	public void administer() {
		System.out.println(getUsername() + " haven't Admin Privileges");
	}

	@Override
	public void browse() {
		System.out.println(getUsername() + " haven't Regular Privileges");
	}
	
	@Override
	public void visit() {
		System.out.println(getUsername() + " is Visiting");
	}

}
