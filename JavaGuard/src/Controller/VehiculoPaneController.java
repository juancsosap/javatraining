package Controller;

import Model.Patente;
import Model.Vehiculo;
import View.MainPane;
import View.VehiculoPane;

public class VehiculoPaneController {
	
	public static void guardar(VehiculoPane src) {
		Vehiculo vehiculo = new Vehiculo();
		
		MainPane parent = (MainPane) src.getParent();
		
		if(Patente.isPatente(src.tfPatente.getText())) {
			vehiculo.setPatente(new Patente(src.tfPatente.getText()));
			vehiculo.setMarca(src.tfMarca.getText());
			vehiculo.setModelo(src.tfModelo.getText());
			vehiculo.setColor(src.tfColor.getText());
			
			vehiculo.guardarDB();
			
			parent.lbMensaje.getStyleClass().add("label-ok");
			parent.lbMensaje.getStyleClass().removeAll("label-error");
			parent.lbMensaje.setText("Vehiculo Registrado");
			
			parent.cbPatente.getItems().add(vehiculo.getPatente().getValor());
			parent.cbPatente.getItems().sort((p1, p2) -> p1.compareTo(p2));
		} else {
			parent.lbMensaje.getStyleClass().add("label-error");
			parent.lbMensaje.getStyleClass().removeAll("label-ok");
			parent.lbMensaje.setText("Patente no Valida");
		}
		
		cancelar(src);
	}
	
	public static void cancelar(VehiculoPane src) {
		MainPane parent = (MainPane) src.getParent();
		src.tfPatente.clear();
		src.tfMarca.clear();
		src.tfModelo.clear();
		src.tfColor.clear();
		parent.vehiculoPane.setVisible(false);
		parent.initialPane.setVisible(true);
	}

}
