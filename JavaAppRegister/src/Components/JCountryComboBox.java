package Components;

import java.util.ArrayList;
import java.util.Dictionary;

import javax.swing.JComboBox;

import Controler.DBManager;
import Template.ProjectFont;

@SuppressWarnings("serial")
public class JCountryComboBox extends JComboBox<String> {
	
	public JCountryComboBox() {
		setFont(new ProjectFont());
		DBManager dbman = new DBManager("src/dbconfig.txt", "world");
		String sqlStr = "SELECT name FROM world.country WHERE continent = 'South America'";
		ArrayList<Dictionary<String, Object>> result = dbman.readDB(sqlStr);
		dbman.disconnect();
		
		if(!(null == result)) {
			for(Dictionary<String, Object> row : result) {
				addItem((String) row.get("name"));
			}
		}
	}

}
