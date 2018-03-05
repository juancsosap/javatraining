package JavaFXTemplates;

import javafx.geometry.Insets;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.StackPane;

public class ComboBoxTemplatePane extends TemplatePane {
	
	private ComboBox<String> comboBox;
	
	public ComboBoxTemplatePane() {
		super("ComboBox Template");
		
		comboBox = new ComboBox<>();
		comboBox.setMinSize(200, 50);
		comboBox.setEditable(true);
		comboBox.setPromptText("Enter your Nationality");
		comboBox.getItems().addAll("Chile", "Peru", "Colombia", "Argentina");
		comboBox.setValue("Chile");
		comboBox.setOnAction(ae -> validateCountry());
		
		StackPane layout = new StackPane();
		layout.getChildren().addAll(comboBox);
		layout.setPadding(new Insets(50, 50, 50, 50));
		
		setCenter(layout);
	}
	
	private void validateCountry() {
		if(!comboBox.getValue().matches("[A-Za-z ]+")){
			comboBox.setValue("");
		}
	}

}
