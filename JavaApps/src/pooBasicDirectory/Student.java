package pooBasicDirectory;

public class Student extends Person {
	
	private String branch;
	private ContactInfo contact;
	
	public Student(Person person, String branch, ContactInfo contact) {
		super(person.getName(), person.getGender(), person.getAge());
		setBranch(branch);
		setContact(contact);
	}
	
	public void setBranch(String branch) throws IllegalArgumentException {
		if(branch.matches("^[-a-zA-Z'. ]+$")) {
			this.branch = branch;
		} else {
			throw new IllegalArgumentException();
		}
	}
	
	public String getBranch() {
		return this.branch;
	}
	
	public void setContact(ContactInfo contact) {
		this.contact = contact;
	}
	
	public ContactInfo getContact() {
		return this.contact;
	}
}
