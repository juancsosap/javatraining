package JavaFXTemplates;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;

public class StackPaneTemplatePane extends TemplatePane {
	
	public StackPaneTemplatePane() {
		super("StackPane Template");
		
		StackPane layout = new StackPane();
		layout.getStylesheets().add("layoutStyle.css");
		
		Label underLabel = new Label("UNDER");
		underLabel.setStyle("-fx-alignment: top-center");
		underLabel.setMinSize(400, 100);
		
		Label topLabel = new Label("TOP");
		topLabel.setStyle("-fx-background-color: #AAAAAA");
		topLabel.setMinSize(300, 50);
		
		layout.getChildren().addAll(underLabel, topLabel);
		layout.setPadding(new Insets(50, 50, 50, 50));
		
		setCenter(layout);
	}

}
