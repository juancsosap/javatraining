package View;

import Controller.PersonaPaneController;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class PersonaPane extends VBox {
	
	public TextField tfRut, tfNombre, tfApellido;
	public Button btGuardar, btCancelar;
	
	public PersonaPane() {
		super(5);
		
		Label lbRut = new Label("Rut");
		tfRut = new TextField();
		this.getChildren().addAll(lbRut, tfRut);
		
		Label lbNombre = new Label("Nombre");
		tfNombre = new TextField();
		this.getChildren().addAll(lbNombre, tfNombre);
		
		Label lbApellido = new Label("Apellido");
		tfApellido = new TextField();
		this.getChildren().addAll(lbApellido, tfApellido);
		
		btGuardar = new Button("Guardar");
		btGuardar.getStyleClass().add("final-button");
		btGuardar.setOnAction(ae -> PersonaPaneController.guardar(this));
		
		btCancelar = new Button("Cancelar");
		btCancelar.getStyleClass().add("final-button");
		btCancelar.setOnAction(ae -> PersonaPaneController.cancelar(this));
		
		HBox hbox = new HBox(20);
		hbox.getChildren().addAll(btCancelar, btGuardar);
		this.getChildren().add(hbox);
	}

}
