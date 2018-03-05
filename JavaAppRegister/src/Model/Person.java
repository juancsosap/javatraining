package Model;

public class Person implements DBInteractive {
	
	private String rut;
	public String getRut() { return rut; }
	public void setRut(String rut) { this.rut = rut; }

	private String name;
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }

	private String surname;
	public String getSurname() { return surname; }
	public void setSurname(String surname) { this.surname = surname; }
	
	public Person(String name, String surname, String rut) {
		this.setName(name);
		this.setSurname(surname);
		this.setRut(rut);
	}
	public Person(String rut) {
		this("", "", rut);
	}
	
	@Override
	public void save() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public String[] load() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void delete() {
		// TODO Auto-generated method stub
		
	}
	
}

