package AbstractFactory;

public class AdminUserFactory implements UserFactory {

	@Override
	public UserPriviledge setPriviledge() {
		return new AdminUserPriviledge();
	}

}
