package Model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Dictionary;

public class Acceso {
	
	private Vehiculo vehiculo;
	public Vehiculo getVehiculo() { return vehiculo; }
	public void setVehiculo(Vehiculo vehiculo) { this.vehiculo = vehiculo; }
	
	private Persona persona;
	public Persona getPersona() { return persona; }
	public void setPersona(Persona persona) { this.persona = persona; }
	
	private String dpto;
	public String getDepartamento() { return dpto; }
	public void setDepartamento(String departamento) { dpto = departamento; }

	private Horario horario;
	public Horario getHorario() { return horario; }
	public void setHorario(Horario horario) { this.horario = horario; }

	private boolean visitante;
	public boolean isVisitante() { return visitante; }
	public void setVisitante(boolean visitante) { this.visitante = visitante; }
	
	public Acceso(Vehiculo vehiculo, Persona persona, String departamento, Horario horario, boolean visitante) {
		this.vehiculo = vehiculo;
		this.persona = persona;
		this.dpto = departamento;
		this.horario = horario;
		this.visitante = visitante;
	}
	public Acceso() { this(null, null, "", new Horario(), false); }
	
	public void guardarDB() {
		DBManager dbman = new DBManager("src/dbconfig.txt", "register");
		if(dbman.isConnected()) {
			int idpersona = getPersona().getID();
			int idvehiculo = getVehiculo().getID();
			Date entrada = getHorario().getEntrada();
			Date salida = getHorario().getSalida();
			
			String sqlStr = "INSERT INTO vehiculo "
					+ "(idpersona, idvehiculo, entrada, salida, departamento, visitante) VALUES "
					+ "(" + idpersona + ", " + idvehiculo + ", " + entrada + ", " + salida 
					+ ", '" + getDepartamento() + "', '" + isVisitante() + "')";
			dbman.writeDB(sqlStr);
			dbman.disconnect();
		}
	}
	
	public static Acceso cargarDB(String patentestr, String rutstr) {
		DBManager dbman = new DBManager("src/dbconfig.txt", "register");
		if(dbman.isConnected()) {
			String sqlStr = "SELECT * FROM fullacceso WHERE rut = '" + rutstr + "' AND patente = '" + patentestr + "'";
			ArrayList<Dictionary<String, Object>> resultAcceso = dbman.readDB(sqlStr);
			
			Acceso acceso = new Acceso();
			if(resultAcceso.size() > 0) {
				Vehiculo vehiculo = Vehiculo.cargarDB(patentestr);
				Persona persona = Persona.cargarDB(rutstr);
				
				Date entrada = (Date) resultAcceso.get(0).get("entrada");
				Date salida = (Date) resultAcceso.get(0).get("salida");
				Horario horarios = new Horario(entrada, salida);
				
				String departamento = (String) resultAcceso.get(0).get("departamento");
				boolean visitante = (Boolean) resultAcceso.get(0).get("visitante");
				
				acceso = new Acceso(vehiculo, persona, departamento, horarios, visitante);
			}
			
			dbman.disconnect();
			
			return acceso;
		} else { return null; }
	}
	
	public static Acceso[] cargarTodoDB() {
		DBManager dbman = new DBManager("src/dbconfig.txt", "register");
		if(dbman.isConnected()) {
			String sqlStr = "SELECT * FROM fullacceso";
			ArrayList<Dictionary<String, Object>> resultado = dbman.readDB(sqlStr);
			
			Acceso[] accesos = new Acceso[resultado.size()];
			
			if(resultado.size() > 0) {
				for(int i=0; i<resultado.size(); i++) {
					String patentestr = (String) resultado.get(i).get("patente");
					Vehiculo vehiculo = Vehiculo.cargarDB(patentestr);
					
					String rutstr = (String) resultado.get(i).get("rut");
					Persona persona = Persona.cargarDB(rutstr);
					
					Date entrada = (Date) resultado.get(i).get("entrada");
					Date salida = (Date) resultado.get(i).get("salida");
					Horario horarios = new Horario(entrada, salida);
					
					String departamento = (String) resultado.get(i).get("departamento");
					boolean visitante = (Boolean) resultado.get(i).get("visitante");
					
					accesos[i] = new Acceso(vehiculo, persona, departamento, horarios, visitante);
				}
			} else {
				return null;
			}
			
			dbman.disconnect();
			
			return accesos;
		} else { return null; }
	}

}
