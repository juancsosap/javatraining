package ocp.tracking;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class Trayecto {

	public Trayecto(Movil movil, Persona persona) {
		this.movil = movil;
		this.persona = persona;
		this.inicio = LocalDateTime.now();
		this.data = new HashMap<>();
	}
	
	public void agregarData(Ubicacion ubi) {
		this.data.put(LocalDateTime.now(), ubi);
	}
	
	public Movil movil;
	public Persona persona;
	public LocalDateTime inicio, fin;
	public Map<LocalDateTime, Ubicacion> data;
	
}
