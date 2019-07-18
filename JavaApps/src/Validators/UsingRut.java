package Validators;

public class UsingRut {

	public static void main(String[] args) {
		String rut = "30686957-k";
		System.out.println(rut);
		Rut miRut = new Rut(rut);
		System.out.println(miRut.getRut());
	}

}
