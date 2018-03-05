package Model;

import java.util.Calendar;
import java.util.Date;

public class Horario {
	private Date entrada;
	private Date salida;
	
	public Horario(Date entrada, Date salida) {
		this.entrada = entrada;
		this.salida = salida;
	}
	public Horario(Date entrada, int horas) {
		this(entrada, Horario.addTime(entrada, horas));
	}
	public Horario() { this(null, null); }
	
	private static Date addTime(Date time, int hours) {
		Calendar cal = Calendar.getInstance();
        cal.setTime(time);
        cal.add(Calendar.HOUR, hours);
        return cal.getTime();
	}
	
	public Date getEntrada() {
		return entrada;
	}
	public void setEntrada(Date entrada) {
		this.entrada = entrada;
	}
	
	public Date getSalida() {
		return salida;
	}
	public void setSalida(Date salida) {
		this.salida = salida;
	}
	
}
