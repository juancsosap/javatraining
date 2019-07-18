package Model;

public class Patente {
	
	private String valor;
	
	public Patente(String valor) {
		setValor(valor);
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) throws IllegalArgumentException {
		if(isPatente(valor))
			this.valor = valor;
		else
			throw new IllegalArgumentException("El formato de la Patente no es valido");
	}
	
	public static boolean isPatente(String valor) {
		return valor.matches("^[0-9]{4}[A-Z]{2}$") || 
				   valor.matches("^[BCDFGHJKLMNPQRSTVWXYZ]{4}[0-9]{2}$");
	}

}
