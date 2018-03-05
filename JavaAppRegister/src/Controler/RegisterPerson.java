package Controler;

import Model.PersonData;

public class RegisterPerson {

	public RegisterPerson(PersonData persondata) {
		DBManager dbman = new DBManager("src/dbconfig.txt", "register");
		String sqlStr = "INSERT INTO person (name, surname, rut) VALUES ('" + 
		                persondata.getName() + "', '" + 
				        persondata.getSurname() + "', '" + 
		                persondata.getRut() + "')";
		dbman.writeDB(sqlStr);
		sqlStr = "INSERT INTO persondata (address, age, country, email, ismale) VALUES ('" +
		         persondata.getAddress() + "', " +
				 persondata.getAge() + ", '" +
		         persondata.getCountry() + "', '" +
				 persondata.getEmail() + "', " + 
		         persondata.isMale() + ")";
		dbman.writeDB(sqlStr);
		dbman.disconnect();
	}

}
