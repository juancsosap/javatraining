package JavaFXTemplates;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class HBoxTemplatePane extends TemplatePane {
	
	public HBoxTemplatePane() {
		super("HBox Template");
		
		HBox layout = new HBox(10);
		layout.getStylesheets().add("layoutStyle.css");
		layout.setAlignment(Pos.CENTER);
		
		Label firstLabel = new Label("First");
		firstLabel.setMinSize(100, 130);
		
		Label secondLabel = new Label("Second");
		secondLabel.setMinSize(100, 130);
		
		Label thirdLabel = new Label("Third");
		thirdLabel.setMinSize(100, 130);
		
		Label fourthLabel = new Label("Fourth");
		fourthLabel.setMinSize(100, 130);
		
		layout.getChildren().addAll(firstLabel, secondLabel, thirdLabel, fourthLabel);
		layout.setPadding(new Insets(50, 50, 50, 50));
		
		setCenter(layout);
	}

}
