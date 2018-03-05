package View;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class MainPane extends StackPane {
	
	public VehiculoPane vehiculoPane =  new VehiculoPane();
	public PersonaPane personaPane =  new PersonaPane();
	public VBox initialPane = new VBox(5);
	
	public Button btNuevaPatente, btNuevoRut, btAcceder;
	public ComboBox<String> cbPatente, cbRut;
	public TextField tfTiempo;
	public CheckBox ckbVisita;
	public Label lbTiempo, lbMensaje;
	
	public MainPane() {
		vehiculoPane.setVisible(false);
		personaPane.setVisible(false);
		
		// Patente
		HBox hbPatente = new HBox(20);
		initialPane.getChildren().add(hbPatente);
		
		Label lbPatente = new Label("Patente");
		hbPatente.getChildren().add(lbPatente);
		
		Region spacePatente = new Region();
		HBox.setHgrow(spacePatente, Priority.ALWAYS);
		hbPatente.getChildren().add(spacePatente);
		
		btNuevaPatente = new Button("Verificar");
		btNuevaPatente.getStyleClass().add("new-button");
		hbPatente.getChildren().add(btNuevaPatente);
		
		cbPatente = new ComboBox<>();
		cbPatente.setEditable(true);
		cbPatente.setValue("");
		initialPane.getChildren().add(cbPatente);
		
		// Rut
		HBox hbRut = new HBox();
		initialPane.getChildren().add(hbRut);
		
		Label lbRut = new Label("Rut");
		hbRut.getChildren().add(lbRut);
		
		Region spaceRut = new Region();
		HBox.setHgrow(spaceRut, Priority.ALWAYS);
		hbRut.getChildren().add(spaceRut);
		
		btNuevoRut = new Button("Verificar");
		btNuevoRut.getStyleClass().add("new-button");
		hbRut.getChildren().add(btNuevoRut);
		
		cbRut = new ComboBox<>();
		cbRut.setEditable(true);
		cbRut.setValue("");
		initialPane.getChildren().add(cbRut);
		
		// Visita
		ckbVisita = new CheckBox("Visita");
		initialPane.getChildren().add(ckbVisita);
		
		// Tiempo
		lbTiempo = new Label("Tiempo");
		lbTiempo.setDisable(true);
		initialPane.getChildren().add(lbTiempo);
		
		tfTiempo = new TextField();
		tfTiempo.setDisable(true);
		initialPane.getChildren().add(tfTiempo);
		
		// Boton Acceder
		HBox hbAcceder = new HBox();
		initialPane.getChildren().add(hbAcceder);
		
		Region spaceAcceder = new Region();
		HBox.setHgrow(spaceAcceder, Priority.ALWAYS);
		hbAcceder.getChildren().add(spaceAcceder);
		
		btAcceder = new Button("Acceder");
		btAcceder.getStyleClass().add("final-button");
		hbAcceder.getChildren().add(btAcceder);
		
		Region spaceMensaje = new Region();
		VBox.setVgrow(spaceMensaje, Priority.ALWAYS);
		initialPane.getChildren().add(spaceMensaje);
		
		lbMensaje = new Label();
		lbMensaje.getStyleClass().add("label-msg");
		lbMensaje.setMinSize(250, 40);
		initialPane.getChildren().add(lbMensaje);
		
		this.setPadding(new Insets(25, 25, 25, 25));
		this.getChildren().addAll(vehiculoPane, personaPane, initialPane);
		
	}

}
