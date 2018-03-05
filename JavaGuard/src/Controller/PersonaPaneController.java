package Controller;

import Model.Persona;
import Model.Rut;
import View.MainPane;
import View.PersonaPane;

public class PersonaPaneController {
	
	public static void guardar(PersonaPane src) {
		Persona persona = new Persona();
		
		MainPane parent = (MainPane) src.getParent();
		
		if(Rut.isRut(src.tfRut.getText())) {
			persona.setRut(new Rut(src.tfRut.getText()));
			persona.setNombre(src.tfNombre.getText());
			persona.setApellido(src.tfApellido.getText());
			
			persona.guardarDB();
			
			parent.lbMensaje.getStyleClass().add("label-ok");
			parent.lbMensaje.getStyleClass().removeAll("label-error");
			parent.lbMensaje.setText("Persona Registrado");
			
			parent.cbRut.getItems().add(persona.getRut().getValue());
			parent.cbRut.getItems().sort((r1, r2) -> r1.compareTo(r2));
		} else {
			parent.lbMensaje.getStyleClass().add("label-error");
			parent.lbMensaje.getStyleClass().removeAll("label-ok");
			parent.lbMensaje.setText("Rut no Valido");
		}
		
		cancelar(src);
	}
	
	public static void cancelar(PersonaPane src) {
		MainPane parent = (MainPane) src.getParent();
		src.tfRut.clear();
		src.tfNombre.clear();
		src.tfApellido.clear();
		parent.personaPane.setVisible(false);
		parent.initialPane.setVisible(true);
	}

}
