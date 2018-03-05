package Controller;

import Model.Patente;
import Model.Persona;
import Model.Rut;
import Model.Vehiculo;
import View.MainPane;

public class MainPaneController {
	
	public static void validarPatente(MainPane src) {
		Vehiculo vehiculo = new Vehiculo();
		if(Patente.isPatente(src.cbPatente.getValue())) {
			vehiculo = Vehiculo.cargarDB(src.cbPatente.getValue());
			if(vehiculo.getPatente() != null)
				src.vehiculoPane.tfPatente.setText(vehiculo.getPatente().getValor());
			else
				src.vehiculoPane.tfPatente.setText(src.cbPatente.getValue());
		}
		
		src.vehiculoPane.tfMarca.setText(vehiculo.getMarca());
		src.vehiculoPane.tfModelo.setText(vehiculo.getModelo());
		src.vehiculoPane.tfColor.setText(vehiculo.getColor());
		
		src.initialPane.setVisible(false);
		src.vehiculoPane.setVisible(true);
	}
	
	public static void validarRut(MainPane src) {
		Persona persona = new Persona();
		if(Rut.isRut(src.cbRut.getValue())) {
			Rut rut = new Rut(src.cbRut.getValue());
			persona = Persona.cargarDB(rut.getValue());
			if(persona.getRut() != null)
				src.personaPane.tfRut.setText(persona.getRut().getValue());
			else
				src.personaPane.tfRut.setText(rut.getValue());
		}
				
		src.personaPane.tfNombre.setText(persona.getNombre());
		src.personaPane.tfApellido.setText(persona.getApellido());
		
		src.initialPane.setVisible(false);
		src.personaPane.setVisible(true);
	}
	
	public static void checkVisitante(MainPane src) {
		src.lbTiempo.setDisable(!src.ckbVisita.isSelected());
		src.tfTiempo.setDisable(!src.ckbVisita.isSelected());
		if(!src.ckbVisita.isSelected())
			src.tfTiempo.clear();
	}
	
	public static void cargarInicial(MainPane src) {
		src.btNuevaPatente.setOnAction(ae -> validarPatente(src));
		src.btNuevoRut.setOnAction(ae -> validarRut(src));
		src.ckbVisita.setOnAction(ae -> checkVisitante(src));
		
		src.cbRut.getItems().addAll(Persona.cargarRutsDB());
		src.cbPatente.getItems().addAll(Model.Vehiculo.cargarPatentesDB());
	}

}
