package JavaFXTemplates;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class RadioButtonTemplatePane extends TemplatePane {
	
	private RadioButton[] radioButtons;
	
	public RadioButtonTemplatePane() {
		super("RadioButton Template");
		
		Label colorLabel = new Label("What is your favorite color?");
		
		String[] colors = {"Red", "Blue", "White", "Yellow", "Gray", "Green", "Black", "Brown", "Pink", "Purple"};
		
		radioButtons = new RadioButton[colors.length];
		ToggleGroup colorGroup = new ToggleGroup();
		
		GridPane grid = new GridPane();
		grid.setVgap(20);
		grid.setHgap(20);
		
		for(int i=0; i<colors.length; i++) {
			radioButtons[i] = new RadioButton(colors[i]);
			radioButtons[i].setToggleGroup(colorGroup);
			radioButtons[i].setMinWidth(80);
			GridPane.setConstraints(radioButtons[i], i/2, i%2);
		}		
		
		grid.getChildren().addAll(radioButtons);

		radioButtons[0].setSelected(true);
		
		VBox layout = new VBox(20);
		layout.getChildren().addAll(colorLabel, grid);
		layout.setPadding(new Insets(50, 50, 50, 50));
		
		setCenter(layout);
	}

}
