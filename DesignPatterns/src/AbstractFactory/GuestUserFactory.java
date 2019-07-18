package AbstractFactory;

public class GuestUserFactory implements UserFactory {

	@Override
	public UserPriviledge setPriviledge() {
		return new GuestUserPriviledge();
	}

}
