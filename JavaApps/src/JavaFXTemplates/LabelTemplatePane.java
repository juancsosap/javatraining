package JavaFXTemplates;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;

public class LabelTemplatePane extends TemplatePane {
	
	private Label labelLabel;
	
	public LabelTemplatePane() {
		super("Label Template");
		
		labelLabel = new Label("This Pane have the basic template for the Label Definition");
		labelLabel.setFont(new Font("Arial", 35));
		labelLabel.setWrapText(true);
		labelLabel.setAlignment(Pos.CENTER);
		
		StackPane layout = new StackPane();
		layout.getChildren().add(labelLabel);
		layout.setPadding(new Insets(50, 50, 50, 50));
		
		setCenter(layout);
	}

}
