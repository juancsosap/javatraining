package Model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Dictionary;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Persona {
	
	private Rut rut;
	public Rut getRut() { return rut; }
	public void setRut(Rut rut) { this.rut = rut; }

	private String nombre;
	public String getNombre() { return nombre; }
	public void setNombre(String nombre) { this.nombre = nombre; }

	private String apellido;
	public String getApellido() { return apellido; }
	public void setApellido(String apellido) { this.apellido = apellido; }
	
	public Persona(String nombre, String apellido, Rut rut) {
		this.setNombre(nombre);
		this.setApellido(apellido);
		this.setRut(rut);
	}
	public Persona() { this("", "", null); }
	
	public int getID() {
		DBManager dbman = new DBManager("src/dbconfig.txt", "register");
		if(dbman.isConnected()) {
			String sqlStr = "SELECT idpersona FROM persona WHERE rut = '" + rut + "'";
			ArrayList<Dictionary<String, Object>> resultado = dbman.readDB(sqlStr);
			
			int id = 0;
			if(resultado.size() > 0)
				id = (int) resultado.get(0).get("idpersona");
			
			dbman.disconnect();
			
			return id;
		} else { return 0; }
	}
	
	public void guardarDB() {
		DBManager dbman = new DBManager("src/dbconfig.txt", "register");
		if(dbman.isConnected()) {
			String sqlStr = "INSERT INTO persona (nombre, apellido, rut) VALUES "
				+ "('" + getNombre() + "', '" + getApellido() + "', '" 
				+ getRut().getValue() + "')";
			dbman.writeDB(sqlStr);
			dbman.disconnect();
		}
	}

	public static Persona cargarDB(String rutstr) {
		DBManager dbman = new DBManager("src/dbconfig.txt", "register");
		if(dbman.isConnected()) {
			String sqlStr = "SELECT * FROM persona WHERE rut = '" + rutstr + "'";
			ArrayList<Dictionary<String, Object>> resultado = dbman.readDB(sqlStr);
			
			Persona persona = new Persona();
			if(resultado.size() > 0) {
				persona.setNombre((String) resultado.get(0).get("nombre"));
				persona.setApellido((String) resultado.get(0).get("apellido"));
				persona.setRut(new Rut((String) resultado.get(0).get("rut")));
			}
			
			dbman.disconnect();
			
			return persona;
		} else { return null; }
	}
	
	public static Persona[] cargarTodoDB() {
		DBManager dbman = new DBManager("src/dbconfig.txt", "register");
		if(dbman.isConnected()) {
			String sqlStr = "SELECT * FROM persona";
			ArrayList<Dictionary<String, Object>> resultado = dbman.readDB(sqlStr);
			
			Persona[] personas = new Persona[resultado.size()];
			
			if(resultado.size() > 0) {
				for(int i=0; i<resultado.size(); i++) {
					String nombre = (String) resultado.get(i).get("nombre");
					String apellido = (String) resultado.get(i).get("apellido");
					Rut rut = new Rut((String) resultado.get(i).get("rut"));
					
					personas[i] = new Persona(nombre, apellido, rut);
				}
			} else {
				return null;
			}
			
			dbman.disconnect();
			
			return personas;
		} else { return null; }
	}
	
	public static ObservableList<String> cargarRutsDB() {
		ObservableList<String> data = FXCollections.observableArrayList(); 
		
		DBManager dbman = new DBManager("src/dbconfig.txt", "register");
		if(dbman.isConnected()) {
			String sqlStr = "SELECT rut FROM persona GROUP BY rut ORDER BY rut";
			ArrayList<Dictionary<String, Object>> resultado = dbman.readDB(sqlStr);
			
			if(resultado.size() > 0) {
				for(int i=0; i<resultado.size(); i++) {
					String rut = (String) resultado.get(i).get("rut");
					data.add(rut);
				}
			}
			
			dbman.disconnect();
		}
		
		return data;
	}
	
	public final static Comparator<Persona> RUTCOMPARATOR = (p1, p2) -> p1.getRut().getValue().compareTo(p2.getRut().getValue()); 
	public final static Comparator<Persona> NOMBRECOMPARATOR = (p1, p2) -> p1.getNombre().compareTo(p2.getNombre());
	public final static Comparator<Persona> APELLIDOCOMPARATOR = (p1, p2) -> p1.getApellido().compareTo(p2.getApellido());
	
}

