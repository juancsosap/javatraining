package JavaFXTemplates;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class VBoxTemplatePane extends TemplatePane {
	
	public VBoxTemplatePane() {
		super("VBox Template");
		
		VBox layout = new VBox(10);
		layout.getStylesheets().add("layoutStyle.css");
		layout.setAlignment(Pos.CENTER);
		
		Label firstLabel = new Label("First");
		firstLabel.setMinSize(300, 40);
		
		Label secondLabel = new Label("Second");
		secondLabel.setMinSize(300, 40);
		
		Label thirdLabel = new Label("Third");
		thirdLabel.setMinSize(300, 40);
		
		layout.getChildren().addAll(firstLabel, secondLabel, thirdLabel);
		layout.setPadding(new Insets(50, 50, 50, 50));
		
		setCenter(layout);
	}

}
