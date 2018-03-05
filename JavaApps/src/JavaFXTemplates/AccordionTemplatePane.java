package JavaFXTemplates;

import javafx.geometry.Insets;
import javafx.scene.control.Accordion;
import javafx.scene.control.Label;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.StackPane;

public class AccordionTemplatePane extends TemplatePane {
	
	public AccordionTemplatePane() {
		super("Accordion Template");
		
		StackPane layout = new StackPane();
		
		Accordion accordion = new Accordion();        		
		
		TitledPane basicLayout = new TitledPane("Basic Info", new Label("Basic Information"));
		TitledPane addressLayout = new TitledPane("Address Info", new Label("Address Information"));
		TitledPane otherLayout = new TitledPane("Other Info", new Label("Other Information"));
		TitledPane aditionalLayout = new TitledPane("Aditional Info", new Label("Aditional Information"));
		
		accordion.getPanes().addAll(basicLayout, addressLayout, otherLayout, aditionalLayout);
		
		layout.getChildren().addAll(accordion);
		layout.setPadding(new Insets(50, 50, 50, 50));
		
		setCenter(layout);
	}

}
