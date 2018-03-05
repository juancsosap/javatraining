package View;

import Controller.VehiculoPaneController;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class VehiculoPane extends VBox {
	
	public TextField tfPatente, tfMarca, tfModelo, tfColor;
	public Button btGuardar, btCancelar;
	
	public VehiculoPane() {
		super(5);
		
		Label lbPatente = new Label("Patente");
		tfPatente = new TextField();
		this.getChildren().addAll(lbPatente, tfPatente);
		
		Label lbMarca = new Label("Marca");
		tfMarca = new TextField();
		this.getChildren().addAll(lbMarca, tfMarca);
		
		Label lbModelo = new Label("Modelo");
		tfModelo = new TextField();
		this.getChildren().addAll(lbModelo, tfModelo);
		
		Label lbColor = new Label("Color");
		tfColor = new TextField();
		this.getChildren().addAll(lbColor, tfColor);
		
		btGuardar = new Button("Guardar");
		btGuardar.getStyleClass().add("final-button");
		btGuardar.setOnAction(ae -> VehiculoPaneController.guardar(this));
		
		btCancelar = new Button("Cancelar");
		btCancelar.getStyleClass().add("final-button");
		btCancelar.setOnAction(ae -> VehiculoPaneController.cancelar(this));
		
		HBox hbox = new HBox(20);
		hbox.getChildren().addAll(btCancelar, btGuardar);
		this.getChildren().add(hbox);
	}
	
}
