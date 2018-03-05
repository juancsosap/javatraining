package JavaFXTemplates;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;

public class ButtonTemplatePane extends TemplatePane {
	
	private Button buttonOn, buttonOff;
	
	public ButtonTemplatePane() {
		super("Button Template");
		
		buttonOn = new Button("On");
		buttonOn.setMinSize(100, 50);
		buttonOn.setOnAction(ae -> swapButtons());
		
		buttonOff = new Button("Off");
		buttonOff.setMinSize(100, 50);
		buttonOff.setOnAction(ae -> swapButtons());
		buttonOff.setVisible(false);
		
		StackPane layout = new StackPane();
		layout.getChildren().addAll(buttonOn, buttonOff);
		layout.setPadding(new Insets(50, 50, 50, 50));
		
		setCenter(layout);
	}
	
	private void swapButtons() {
		buttonOn.setVisible(!buttonOn.isVisible());
		buttonOff.setVisible(!buttonOff.isVisible());
	}

}
