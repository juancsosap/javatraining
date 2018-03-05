package Model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Dictionary;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Vehiculo {
	
	private Patente patente;
	public Patente getPatente() { return patente; }
	public void setPatente(Patente patente) { this.patente = patente; }

	private String marca;
	public String getMarca() { return marca; }
	public void setMarca(String marca) { this.marca = marca; }
	
	private String modelo;
	public String getModelo() { return modelo; }
	public void setModelo(String modelo) { this.modelo = modelo; }

	private String color;
	public String getColor() { return color; }
	public void setColor(String color) { this.color = color; }
	
	public Vehiculo(Patente patente, String modelo, String color, String marca) {
		this.setPatente(patente);
		this.setModelo(modelo);
		this.setColor(color);
		this.setMarca(marca);
	}
	public Vehiculo() { this(null, "", "", ""); }

	public int getID() {
		DBManager dbman = new DBManager("src/dbconfig.txt", "register");
		String sqlStr = "SELECT idvehiculo FROM vehiculo WHERE patente = '" + patente + "'";
		ArrayList<Dictionary<String, Object>> resultado = dbman.readDB(sqlStr);
		
		int id = 0;
		if(resultado.size() > 0)
			id = (int) resultado.get(0).get("idvehiculo");
		
		dbman.disconnect();
		
		return id;
	}
	
	public void guardarDB() {
		DBManager dbman = new DBManager("src/dbconfig.txt", "register");
		if(dbman.isConnected()) {
			String sqlStr = "INSERT INTO vehiculo (patente, marca, modelo, color) VALUES "
				+ "('" + getPatente().getValor() + "', '" + getMarca() + "', '" + 
				getModelo() + "', '" + getColor() + "')";
			dbman.writeDB(sqlStr);
			dbman.disconnect();
		}
	}
	
	public static Vehiculo cargarDB(String patentestr) {
		DBManager dbman = new DBManager("src/dbconfig.txt", "register");
		if(dbman.isConnected()) {
			String sqlStr = "SELECT * FROM vehiculo WHERE patente = '" + patentestr + "'";
			ArrayList<Dictionary<String, Object>> resultado = dbman.readDB(sqlStr);
			
			Vehiculo vehiculo = new Vehiculo();
			if(resultado.size() > 0) {
				vehiculo.setPatente(new Patente((String) resultado.get(0).get("patente")));
				vehiculo.setMarca((String) resultado.get(0).get("marca"));
				vehiculo.setModelo((String) resultado.get(0).get("modelo"));
				vehiculo.setColor((String) resultado.get(0).get("color"));
			}
			
			dbman.disconnect();
			
			return vehiculo;
		} else { return null; }
	}
	
	public static Vehiculo[] cargarTodoDB() {
		DBManager dbman = new DBManager("src/dbconfig.txt", "register");
		if(dbman.isConnected()) {
			String sqlStr = "SELECT * FROM vehiculo";
			ArrayList<Dictionary<String, Object>> resultado = dbman.readDB(sqlStr);
			
			Vehiculo[] vehiculos = new Vehiculo[resultado.size()];
			
			if(resultado.size() > 0) {
				for(int i=0; i<resultado.size(); i++) {
					Patente patente = new Patente((String) resultado.get(i).get("patente"));
					String marca = (String) resultado.get(i).get("marca");
					String modelo = (String) resultado.get(i).get("modelo");
					String color = (String) resultado.get(i).get("color");
					vehiculos[i] = new Vehiculo(patente, marca, modelo, color);
				}
			} else {
				return null;
			}
			
			dbman.disconnect();
			
			return vehiculos;
		} else { return null; }
	}
	
	public static ObservableList<String> cargarPatentesDB() {
		ObservableList<String> data = FXCollections.observableArrayList(); 
		
		DBManager dbman = new DBManager("src/dbconfig.txt", "register");
		if(dbman.isConnected()) {
			String sqlStr = "SELECT patente FROM vehiculo GROUP BY patente ORDER BY patente";
			ArrayList<Dictionary<String, Object>> resultado = dbman.readDB(sqlStr);
			
			if(resultado.size() > 0) {
				for(int i=0; i<resultado.size(); i++) {
					String patente = (String) resultado.get(i).get("patente");
					data.add(patente);
				}
			}
			
			dbman.disconnect();
		}
				
		return data;
	}
	
	public final static Comparator<Vehiculo> PATENTECOMPARATOR = (v1, v2) -> v1.getPatente().getValor().compareTo(v2.getPatente().getValor());
	public final static Comparator<Vehiculo> MARCACOMPARATOR = (v1, v2) -> v1.getMarca().compareTo(v2.getMarca());
	public final static Comparator<Vehiculo> MODELOCOMPARATOR = (v1, v2) -> v1.getModelo().compareTo(v2.getModelo());
	public final static Comparator<Vehiculo> COLORCOMPARATOR = (v1, v2) -> v1.getColor().compareTo(v2.getColor());

}
