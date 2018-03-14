package AbstractFactory;

public class RegularUser extends User {

	public RegularUser(UserFactory factory, String username, String password) {
		super(username, password);
		this.factory = factory;
	}

	@Override
	public String toString() {
		return getUsername() + "(Regular)";
	}

	@Override
	public void administer() {
		System.out.println(getUsername() + " haven't Admin Privilege");
	}
	
	@Override
	public void browse() {
		System.out.println(getUsername() + " is Browsing");
	}
	
	@Override
	public void visit() {
		System.out.println(getUsername() + " is Visiting");
	}

	@Override
	public void make() {
		priviledge = factory.setPriviledge();
	}
	
}
