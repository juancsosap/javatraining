package Fundaments;

import java.time.LocalDate;

public class PersonClass {
	String name;
	String surname;
	String id;
	int age;
	LocalDate birthday;
	Address address;
	String email;
	boolean isActive; // True False
	Gender gender;
	
	public PersonClass(String name, String surname) {
		this.name = name;
		this.surname = surname;
		id = "";
		age = 0;
		birthday = LocalDate.now();
		gender = Gender.MALE;
	}
}

enum Gender { MALE, FEMALE, OTHER }

class Address {
	String country;
	String city;
	String district;
	String street;
	String number;
	String other;
	
	public Address(String country) {
		this.country = country;
	}
}

class Contact {
	Email email;
}

class Email {
	String email;
	
}

class UsingPerson {
	public static void main(String[] args) {
		PersonClass pepe = new PersonClass("Pepe","Perez");
		pepe.gender = Gender.FEMALE;
		Address micasa = new Address("Chile");
		pepe.address = micasa;
	}
}
