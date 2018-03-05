package JavaFXTemplates;

import javafx.geometry.Insets;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class CheckBoxTemplatePane extends TemplatePane {
	
	private CheckBox[] checkBoxes;
	
	public CheckBoxTemplatePane() {
		super("CheckBox Template");
		
		Label preferenceLabel = new Label("Choose two Preference:");
		
		String[] preferences = {"Technology", "Health",
		                        "Fitness", "Science",
		                        "Food", "Travel",
		                        "Animals", "Flowers"};
		
		checkBoxes = new CheckBox[preferences.length];
		
		GridPane grid = new GridPane();
		grid.setVgap(20);
		grid.setHgap(20);
		
		for(int i=0; i<preferences.length; i++) {
			checkBoxes[i] = new CheckBox(preferences[i]);
			checkBoxes[i].setOnAction(ae -> validatePreferences());
			checkBoxes[i].setMinWidth(100);
			GridPane.setConstraints(checkBoxes[i], i/2, i%2);
			grid.getChildren().add(checkBoxes[i]);
		}		
		
		VBox layout = new VBox(20);
		layout.getChildren().addAll(preferenceLabel, grid);
		layout.setPadding(new Insets(50, 50, 50, 50));
		
		setCenter(layout);
	}
	
	private void validatePreferences() {
		int checked = 0;
		for(int i=0; i< checkBoxes.length; i++)
			if(checkBoxes[i].isSelected())
				checked++;
		if(checked > 2)
			for(int i=0; i< checkBoxes.length; i++)
				checkBoxes[i].setSelected(false);
	}

}
