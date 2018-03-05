package JavaFXTemplates;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

public class AnchorPaneTemplatePane extends TemplatePane {
	
	public AnchorPaneTemplatePane() {
		super("AnchorPane Template");
		
		AnchorPane layout = new AnchorPane();
		layout.getStylesheets().add("layoutStyle.css");
		
		Label topleftLabel = new Label("TOP-LEFT");
		AnchorPane.setTopAnchor(topleftLabel, 20.0);
		AnchorPane.setLeftAnchor(topleftLabel, 60.0);
	    topleftLabel.setMinSize(150, 40);
		
	    Label toprightLabel = new Label("TOP-RIGHT");
		AnchorPane.setTopAnchor(toprightLabel, 10.0);
		AnchorPane.setRightAnchor(toprightLabel, 10.0);
	    toprightLabel.setMinSize(200, 50);
		
	    Label bottomleftLabel = new Label("BOTTOM-LEFT");
		AnchorPane.setBottomAnchor(bottomleftLabel, 10.0);
		AnchorPane.setLeftAnchor(bottomleftLabel, 10.0);
	    bottomleftLabel.setMinSize(200, 50);
		
	    Label bottomrightLabel = new Label("BOTTOM-RIGHT");
		AnchorPane.setBottomAnchor(bottomrightLabel, 30.0);
		AnchorPane.setRightAnchor(bottomrightLabel, 110.0);
	    bottomrightLabel.setMinSize(100, 30);
		
		layout.getChildren().addAll(topleftLabel, toprightLabel, bottomleftLabel, bottomrightLabel);
		layout.setPadding(new Insets(50, 50, 50, 50));
		
		setCenter(layout);
	}

}
