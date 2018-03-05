package JavaFXTemplates;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;

public class TemplatePane extends BorderPane {
	
	private Label titleLabel;
	
	public TemplatePane(String title) {
		super();
		
		titleLabel = new Label(title);
		titleLabel.getStyleClass().add("title-label");
		
		setPadding(new Insets(20, 20, 20, 20));
		this.setTop(titleLabel);
	}

}
