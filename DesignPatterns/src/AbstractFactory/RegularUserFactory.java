package AbstractFactory;

public class RegularUserFactory implements UserFactory {

	@Override
	public UserPriviledge setPriviledge() {
		return new RegularUserPriviledge();
	}

}
