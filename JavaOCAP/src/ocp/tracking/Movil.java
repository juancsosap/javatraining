package ocp.tracking;

public class Movil {

	public Movil(Movil.Tipo tipo, int granularidadSeg) {
		this.tipo = tipo;
		this.granularidad = granularidadSeg;
	}
	
	public Movil.Tipo tipo;
	public int granularidad;
	
	public static enum Tipo { PIE, BICI, AUTO, MOTO }
	
}
