package JavaFXTemplates;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;

public class BorderPaneTemplatePane extends TemplatePane {
	
	public BorderPaneTemplatePane() {
		super("BorderPane Template");
		
		BorderPane layout = new BorderPane();
		layout.getStylesheets().add("layoutStyle.css");
		
		Label topLabel = new Label("TOP");
		topLabel.setMinSize(430, 30);
		BorderPane.setAlignment(topLabel, Pos.CENTER);
		layout.setTop(topLabel);
		
		Label bottomLabel = new Label("BOTTOM");
		bottomLabel.setMinSize(430, 30);
		BorderPane.setAlignment(bottomLabel, Pos.CENTER);
		layout.setBottom(bottomLabel);
		
		Label rightLabel = new Label("RIGHT");
		rightLabel.setMinSize(35, 70);
		BorderPane.setAlignment(rightLabel, Pos.CENTER);
		layout.setRight(rightLabel);
		
		Label leftLabel = new Label("LEFT");
		leftLabel.setMinSize(35, 70);
		BorderPane.setAlignment(leftLabel, Pos.CENTER);
		layout.setLeft(leftLabel);
		
		Label centerLabel = new Label("CENTER");
		centerLabel.setMinSize(390, 60);
		BorderPane.setAlignment(centerLabel, Pos.CENTER);
		layout.setCenter(centerLabel);
		
		layout.setPadding(new Insets(50, 50, 50, 50));
		
		setCenter(layout);
	}

}
