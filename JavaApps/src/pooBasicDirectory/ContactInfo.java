package pooBasicDirectory;

public class ContactInfo {
	
	private String address;
	private String[] phones;
	
	public ContactInfo(String address, String[] phones) {
		setAddress(address);
		setPhones(phones);
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getAddress() {
		return this.address;
	}
	
	public void setPhones(String[] phones) {
		this.phones = phones;
	}
	
	public String[] getPhones() {
		return this.phones;
	}

}
