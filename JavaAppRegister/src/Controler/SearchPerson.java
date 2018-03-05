package Controler;

import java.util.ArrayList;
import java.util.Dictionary;

import Model.Person;
import Model.PersonData;

public class SearchPerson {

	public static PersonData search(String rut) {
		DBManager dbman = new DBManager("src/dbconfig.txt", "register");
		String sqlStr = "SELECT * FROM fullperson WHERE rut = '" + rut + "'";
		ArrayList<Dictionary<String, Object>> resultPerson = dbman.readDB(sqlStr);
		
		Person p;
		PersonData pd;
		
		if(resultPerson.size() > 0) {
			p = new Person((String) resultPerson.get(0).get("name"),
				  	       (String) resultPerson.get(0).get("surname"),
					       (String) resultPerson.get(0).get("rut"));
			pd = new PersonData(p, (boolean) resultPerson.get(0).get("isMale"),
		               (int) resultPerson.get(0).get("age"),
		               (String) resultPerson.get(0).get("country"),
		               (String) resultPerson.get(0).get("email"),
		               (String) resultPerson.get(0).get("address"));
		} else {
			return null;
		}
		
		dbman.disconnect();
		
		return pd;
	}
	
	public static PersonData[] searchAll() {
		DBManager dbman = new DBManager("src/dbconfig.txt", "register");
		String sqlStr = "SELECT * FROM fullperson";
		ArrayList<Dictionary<String, Object>> resultPerson = dbman.readDB(sqlStr);
		
		Person p;
		PersonData[] pd = new PersonData[resultPerson.size()];
		
		if(resultPerson.size() > 0) {
			for(int i=0; i<resultPerson.size(); i++) {
				p = new Person((String) resultPerson.get(i).get("name"),
					  	       (String) resultPerson.get(i).get("surname"),
						       (String) resultPerson.get(i).get("rut"));
				pd[i] = new PersonData(p, (boolean) resultPerson.get(i).get("isMale"),
			               (int) resultPerson.get(i).get("age"),
			               (String) resultPerson.get(i).get("country"),
			               (String) resultPerson.get(i).get("email"),
			               (String) resultPerson.get(i).get("address"));
			}
		} else {
			return null;
		}
		
		dbman.disconnect();
		
		return pd;
	}

}
